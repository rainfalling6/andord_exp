package com.example.myapplication.data

import com.example.myapplication.model.Book

/**
 * 书籍数据源。
 *
 * 书籍对象在代码中直接创建，并保存到数组中。
 */
object BookRepository {

    private val books: Array<Book> = arrayOf(
        Book(
            title = "百年孤独",
            author = "加西亚·马尔克斯",
            publisher = "南海出版公司",
            price = 55.00,
            publishYear = 2011,
            isbn = "9787544253994",
            pageCount = 360,
            description = "魔幻现实主义文学的代表作，描写了布恩迪亚家族七代人的传奇故事，"
                + "以及加勒比海沿岸小镇马孔多的百年兴衰。"
        ),
        Book(
            title = "活着",
            author = "余华",
            publisher = "作家出版社",
            price = 28.00,
            publishYear = 2012,
            isbn = "9787506365437",
            pageCount = 191,
            description = "讲述农村人福贵悲惨的人生遭遇。福贵一生经历了家庭变故与时代变迁，"
                + "却依然坚韧地活着。"
        ),
        Book(
            title = "三体",
            author = "刘慈欣",
            publisher = "重庆出版社",
            price = 46.00,
            publishYear = 2008,
            isbn = "9787536692930",
            pageCount = 302,
            description = "中国科幻文学的里程碑之作。地球文明向宇宙发出的一声啼鸣，"
                + "改变了人类的命运。"
        ),
        Book(
            title = "小王子",
            author = "安托万·德·圣埃克苏佩里",
            publisher = "人民文学出版社",
            price = 22.00,
            publishYear = 2003,
            isbn = "9787020042494",
            pageCount = 132,
            description = "一部写给大人的童话。小王子离开自己的星球，在旅途中遇见了形形色色的成年人，"
                + "也逐渐懂得了爱与责任。"
        ),
        Book(
            title = "平凡的世界",
            author = "路遥",
            publisher = "北京十月文艺出版社",
            price = 39.80,
            publishYear = 2017,
            isbn = "9787530216781",
            pageCount = 536,
            description = "以中国改革开放时期为背景，全景式地表现城乡社会生活的长篇小说，"
                + "刻画了普通人在时代洪流中的奋斗与追求。"
        ),
        Book(
            title = "白夜行",
            author = "东野圭吾",
            publisher = "南海出版公司",
            price = 52.00,
            publishYear = 2013,
            isbn = "9787544258609",
            pageCount = 467,
            description = "一桩十九年前的悬案，将两个孩子的人生紧紧缠绕。故事在光明与黑暗之间展开，"
                + "揭示了人性的复杂。"
        ),
        Book(
            title = "围城",
            author = "钱钟书",
            publisher = "人民文学出版社",
            price = 32.00,
            publishYear = 1991,
            isbn = "9787020024759",
            pageCount = 359,
            description = "以幽默讽刺的笔触描绘抗战初期知识分子的生活百态，"
                + "“城外的人想冲进去，城里的人想逃出来”。"
        ),
        Book(
            title = "人类简史",
            author = "尤瓦尔·赫拉利",
            publisher = "中信出版社",
            price = 68.00,
            publishYear = 2014,
            isbn = "9787508647357",
            pageCount = 440,
            description = "从认知革命、农业革命到科学革命，梳理智人如何从普通物种"
                + "一步步成为地球的主宰。"
        )
    )

    /**
     * 返回按价格从低到高排序后的书籍列表。
     */
    fun getBooksSortedByPrice(): List<Book> = books.sortedBy { it.price }
}
