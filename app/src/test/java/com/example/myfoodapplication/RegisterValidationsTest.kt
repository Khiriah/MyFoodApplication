package com.example.myfoodapplication

import com.example.myfoodapplication.Util.RegisterValidations
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class RegisterValidationsTest {


    @Test
    fun emailIsValidWithInvalidEmailThenReturnFalseValue() {
        val validation = RegisterValidations.emailIsValid("test-dd.com")

        Assert.assertEquals(false, validation)
    }

    @Test
    fun emailIsValidWithValidEmailThenReturnTrueValue() {
        val validation = RegisterValidations.emailIsValid("test@test.com")

        Assert.assertEquals(true, validation)
    }


    @Test
    fun passwordIsValidWithInvalidPasswordThenReturnFalseValue() {
        val validation = RegisterValidations.passwordIsValid("73")

        Assert.assertEquals(false, validation)
    }


    @Test
    fun passwordIsValidWithValidPasswordThenReturnTrueValue() {
        val validation = RegisterValidations.passwordIsValid("Tu@2185697")

        Assert.assertEquals(true, validation)
    }

}