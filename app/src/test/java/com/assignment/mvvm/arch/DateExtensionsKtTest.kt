package com.assignment.mvvm.arch

import com.assignment.mvvm.ext.getDisplayableDate
import org.junit.Assert.assertEquals
import org.junit.Test


class DateExtensionsKtTest {

    // TODO: Write UT for DateExtentionsKt.transformDateFormat method
    @Test
    fun transformDateFormatTest() {

    }

    @Test
    fun getDisplayableDateTest() {
        val actual = "2021-01-17T15:46:22Z".getDisplayableDate()
        assertEquals("2021-01-17", actual)
    }

}