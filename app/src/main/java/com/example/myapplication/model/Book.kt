package com.example.myapplication.model

/**
 * 书籍实体类。
 *
 * @property title 书名
 * @property author 作者
 * @property publisher 出版社
 * @property price 价格（元）
 * @property publishYear 出版年份
 * @property isbn ISBN 编号
 * @property pageCount 页数
 * @property description 内容简介
 */
data class Book(
    val title: String,
    val author: String,
    val publisher: String,
    val price: Double,
    val publishYear: Int,
    val isbn: String,
    val pageCount: Int,
    val description: String
)
