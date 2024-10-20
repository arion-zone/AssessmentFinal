package com.assessmentfinal.assessmentfinal

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.assessmentfinal.assessmentfinal.models.LoginResponse
import com.assessmentfinal.assessmentfinal.viewmodel.LoginRepository
import com.assessmentfinal.assessmentfinal.viewmodel.LoginViewModel
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response
import kotlin.test.assertEquals

class LoginViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var loginViewModel: LoginViewModel

    @Mock
    private lateinit var loginRepository: LoginRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        loginViewModel = LoginViewModel(loginRepository)
    }
    @Test
    fun `login returns success with valid credentials`() = runBlocking {
        // Arrange
        val expectedKeypass = "topicName"
        val loginResponse = LoginResponse(expectedKeypass)

        // Creating a mock Response object
        val mockResponse = Response.success(loginResponse)

        // Mocking the loginRepository's login function to return the mock Response
        Mockito.`when`(loginRepository.login("username", "password", "location"))
            .thenReturn(mockResponse)

        // Act
        loginViewModel.login("username", "password", "location")

        // Assert
        loginViewModel.loginResult.observeForever { result ->
            result.onSuccess {
                assertEquals(expectedKeypass, it.keypass)
            }
        }
    }

    @Test
    fun `login returns failure with invalid credentials`() = runBlocking {
        // Arrange
        val errorMessage = "Login Failed"
        val mockResponse: Response<LoginResponse> = Response.error(401, ResponseBody.create(null, errorMessage))

        // Mocking the loginRepository's login function to return the mock Response
        Mockito.`when`(loginRepository.login("username", "wrongPassword", "location"))
            .thenReturn(mockResponse)

        // Act
        loginViewModel.login("username", "wrongPassword", "location")

        // Assert
        loginViewModel.loginResult.observeForever { result ->
            result.onFailure {
                assertEquals(errorMessage, it.message)
            }
        }
    }
    @After
    fun tearDown() {
        // Clean up resources if needed
    }
}
