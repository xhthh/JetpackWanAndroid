package com.xht.base_lib.http

/**
 * 用来封装错误信息
 */
class ApiException(val errorMessage: String, val errorCode: Int) : Throwable()