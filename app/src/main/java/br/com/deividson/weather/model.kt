package br.com.deividson.weather
import com.google.gson.annotations.SerializedName

class model {

    data class Main(
        @SerializedName("temp")
        var temp: String = "",

        @SerializedName("temp_min")
        var temp_min: String = "",

        @SerializedName("temp_max")
        var temp_max: String = "",

        @SerializedName("pressure")
        var pressure: String = "",

        @SerializedName("humidity")
        var humidity: String = "",
    )

    data class Weather(
        @SerializedName("description")
        var description: String = "",
    )

    data class Posts(
        @SerializedName("name")
        var name : String,

        @SerializedName("base")
        var base : String,

        @SerializedName("main", )
        var main : Main,

        @SerializedName("weather", )
        var weather : List<Weather>,

    )
}