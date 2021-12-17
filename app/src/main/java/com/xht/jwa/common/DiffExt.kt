package com.xht.jwa.common

import androidx.recyclerview.widget.DiffUtil
import com.xht.jwa.common.bean.ArticleListBean

/**
 * diff扩展函数
 */

/**
 * 文章diff
 */
fun getArticleDiff(): DiffUtil.ItemCallback<ArticleListBean> {
    return object : DiffUtil.ItemCallback<ArticleListBean>() {
        override fun areItemsTheSame(oldItem: ArticleListBean, newItem: ArticleListBean): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ArticleListBean,
            newItem: ArticleListBean
        ): Boolean {
            //只有点赞和时间可能存在改变
            return oldItem.collect == newItem.collect
                    && oldItem.date == newItem.date
        }
    }
}