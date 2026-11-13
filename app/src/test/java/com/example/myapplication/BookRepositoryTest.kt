package com.example.myapplication

import com.example.myapplication.data.BookRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class BookRepositoryTest {

    @Test
    fun booksAreSortedByPriceAscending() {
        val prices = BookRepository.getBooksSortedByPrice().map { it.price }

        assertTrue(prices.size > 1)
        assertEquals(prices.sorted(), prices)
    }
}
