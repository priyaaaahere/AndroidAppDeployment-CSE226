package com.example.cse226_etp

import junit.framework.TestCase.assertEquals
import org.junit.Test
import unit6.unitTesting.task1.Calculator

class AppCalculatorTest {
    private val calc= Calculator()

    @Test
    fun testAddition(){
        assertEquals(4,calc.addition(2,2))
    }
    fun subtraction(){
        assertEquals(0,calc.subtract(2,2))
    }
}