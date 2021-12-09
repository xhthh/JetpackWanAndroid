package com.xht.base_lib.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 基础数据层
 */
open class BaseRepository {
    /**
     * 在协程作用域中切换至IO线程
     */
    protected suspend fun <T> withIO(block: suspend () -> T): T {
        return withContext(Dispatchers.IO) {
            block.invoke()
        }
    }
}