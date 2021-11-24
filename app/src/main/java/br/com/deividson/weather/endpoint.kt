package br.com.deividson.weather


import br.com.deividson.weather.model.Posts
import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    @GET("weather?q=piracicaba,br&appid=ecaa2fdbff88f4da0abd46935943ad9f&lang=pt_br&units=metric")
    fun getPosts() : Call<Posts>
}
