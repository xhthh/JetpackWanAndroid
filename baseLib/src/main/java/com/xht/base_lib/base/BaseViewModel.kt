package com.xht.base_lib.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xht.base_lib.BuildConfig
import com.xht.base_lib.common.toast
import com.xht.base_lib.http.ApiException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * 基础vm
 */
open class BaseViewModel : ViewModel() {

    /**
     * 错误信息liveData
     */
    val errorLiveData = MutableLiveData<ApiException>()

    /**
     * 无更多数据
     */
    val footLiveDate = MutableLiveData<Any>()

    /**
     * 无数据
     */
    val emptyLiveDate = MutableLiveData<Any>()

    /**
     * 使用runCatching函数式处理错误，封装了 try catch，使用函数式处理，异常捕获
     * runCatching在try{}catch{e: Throwable}内执行指定的代码块，如果调用成功，则返回结果，如果失败，则抛出异常
     */
    protected fun <T> launch(block: suspend () -> T) {
        viewModelScope.launch {
            println("BaseViewModel---launch()1---当前线程=" + Thread.currentThread().name)
            runCatching {
                println("BaseViewModel---launch()2---当前线程=" + Thread.currentThread().name)
                block()
            }.onFailure {
                if (BuildConfig.DEBUG) {
                    it.printStackTrace()
                    return@onFailure
                }
                getApiException(it).apply {
                    withContext(Dispatchers.Main) {
                        toast(errorMessage)
                        //统一响应错误信息
                        errorLiveData.value = this@apply
                    }
                }
            }
        }
    }


    /**
     * 捕获异常信息
     */
    private fun getApiException(e: Throwable): ApiException {
        return when (e) {
            is UnknownHostException -> {
                ApiException("网络异常", -100)
            }
            is JSONException -> {//|| e is JsonParseException
                ApiException("数据异常", -100)
            }
            is SocketTimeoutException -> {
                ApiException("连接超时", -100)
            }
            is ConnectException -> {
                ApiException("连接错误", -100)
            }
            is HttpException -> {
                ApiException("http code ${e.code()}", -100)
            }
            is ApiException -> {
                e
            }
            /**
             * 如果协程还在运行，个别机型退出当前界面时，viewModel会通过抛出CancellationException，
             * 强行结束协程，与java中InterruptException类似，所以不必理会,只需将toast隐藏即可
             */
            is CancellationException -> {
                ApiException("", -10)
            }
            else -> {
                ApiException("未知错误", -100)
            }
        }
    }

    /**
     * 处理列表是否有更多数据
     */
    protected fun <T> handleList(listLiveData: LiveData<MutableList<T>>, pageSize: Int = 20) {
        val listSize = listLiveData.value?.size ?: 0
        if (listSize % pageSize != 0) {
            footLiveDate.value = 1
        }
    }
}