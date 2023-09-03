package com.example.comparador

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        viewModel = MainViewModel()
    }

    @Test
    fun testCompareTexts_WhenTextsAreEqual_ResultIsEqual() {
        // Arrange
        val text1 = "Texto igual"
        val text2 = "Texto igual"

        // Act
        viewModel.setText1(text1)
        viewModel.setText2(text2)
        viewModel.compareTexts()

        // Assert
        assertEquals("Los textos son iguales", viewModel.result.value)
    }

    @Test
    fun testCompareTexts_WhenTextsAreDifferent_ResultIsDifferent() {
        // Arrange
        val text1 = "Texto 1"
        val text2 = "Texto 2"

        // Act
        viewModel.setText1(text1)
        viewModel.setText2(text2)
        viewModel.compareTexts()

        // Assert
        assertEquals("Los textos son diferentes", viewModel.result.value)
    }
}

