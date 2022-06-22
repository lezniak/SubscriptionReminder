package com.example.subscriptionreminder.infrastructure.common

import junit.framework.Assert
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import java.lang.Exception

class ValidationTest : TestCase(){
    lateinit var validation : Validation

    @Before
    @Throws(Exception::class)
    override fun setUp() {
        validation = Validation()
    }
    @Test
    fun aEmailShort(){
        val  result = validation.validateEmail("a@a.a")
        assertEquals(0,result.getStatus())
    }

    @Test
    fun testEmailLong(){
        val  result = validation.validateEmail("dasdsadasdasddsadsaasdasdadlkasjdlkjsadlkjsalkdsdasdasdas@o2.pl")
        assertEquals(0,result.getStatus())
    }

    @Test
    fun test_empty_email_statuszero(){
        val  result = validation.validateEmail("")
        assertEquals(0,result.getStatus())
    }
    @Test
    fun test_withoutAt_email_statuszero(){
        val  result = validation.validateEmail("aa.pl")
        assertEquals(0,result.getStatus())
    }
    @Test
    fun test_withoutDot_email_statuszero(){
        val  result = validation.validateEmail("aa@pl")
        assertEquals(0,result.getStatus())
    }
}