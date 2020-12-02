package com.example.mymockitoapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class CalculatorTest {

    @Mock
    lateinit var operators: Operators
    lateinit var calculator: Calculator

    @Before
    fun onSetup() {
        MockitoAnnotations.initMocks(this)
        calculator = Calculator(operators)
    }

    @Test
    fun `operator add should call once if call calculator add`() {
        val a = 10
        val b = 20
        calculator.addTwoNumbers(a, b)
        verify(operators).add(a, b)
    }

    @Test
    fun `operator subtract should call once if call calculator subtract`() {
        val a = 50
        val b = 20
        calculator.subtractTwoNumbers(a, b)
        verify(operators).subtract(a, b)
    }

    @Test
    fun `operator multiply should call once if call calculator multiply`() {
        val a = 10
        val b = 20
        calculator.multiplyTwoNumbers(a, b)
        verify(operators).multiply(a, b)
    }

    @Test
    fun `operator divide should call once if call calculator divide`() {
        val a = 10
        val b = 2
        calculator.divideTwoNumbers(a, b)
        verify(operators).divide(a, b)
    }

    @Test
    fun providedNumber_isSum_true() {
        val mockUtil = Mockito.mock(UtiliyClass::class.java)
        Mockito.`when`(mockUtil.getSum(1, 2)).thenReturn(3)
        val actualResult = mockUtil.getSum(1, 2)
        Assert.assertEquals(3, actualResult)
    }
}