package com.meli.searcher

import com.meli.searcher.env.API_BASE_URL
import com.meli.searcher.env.TOKEN
import org.junit.Test
import org.junit.Assert.*

class ConstantsEnvTest {
    @Test
    fun isEmptyToken(){
        assertNotEquals("", TOKEN)
    }

    @Test
    fun isMeliUrlIsCorrect() {
        assertEquals("https://api.mercadolibre.com/", API_BASE_URL )
    }
}