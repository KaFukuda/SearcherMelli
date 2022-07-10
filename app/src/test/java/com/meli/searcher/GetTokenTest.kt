package com.meli.searcher

import com.meli.searcher.env.TOKEN
import com.meli.searcher.service.api.RetrofitNetworkService.Companion.getToken
import org.junit.Assert.*
import org.junit.Test

class GetTokenTest {

    @Test
    fun isReceiveTokenValue() {
        assertEquals(
            "Bearer $TOKEN", getToken()
        )
    }

}