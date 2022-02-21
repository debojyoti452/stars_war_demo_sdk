package com.example.lib

import android.content.Context
import com.example.lib.src.component.usecases.PeopleUseCase
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class StarWarsTest {

    @MockK
    private lateinit var mockContext: Context

    @MockK
    private lateinit var peopleUseCase: PeopleUseCase

    @Before
    fun setUp() {

    }

    @Test
    fun `get 5 people eye color`() {

    }

    @Test
    fun getPlanets() {
    }

    @Test
    fun getFilm() {
    }
}
