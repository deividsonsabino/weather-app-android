package br.com.deividson.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://api.openweathermap.org/data/2.5/")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPosts()

        val tempView = findViewById<TextView>(R.id.temp);
        val cityView = findViewById<TextView>(R.id.city);
        val tempMinView = findViewById<TextView>(R.id.temp_min);
        val pressureView = findViewById<TextView>(R.id.pressure);
        val humidityView = findViewById<TextView>(R.id.humidity);
        val descriptionView = findViewById<TextView>(R.id.description)

        callback.enqueue(object : Callback<model.Posts> {

            override fun onFailure(call: Call<model.Posts>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<model.Posts>, response: Response<model.Posts>) {
                tempView.text = response.body()?.main?.temp.toString() + "Cº";
                val list = response.body()?.weather
                if (list != null) {
                    for (item in list) {
                        descriptionView.text = item.description.toString();
                    }
                }
                tempMinView.text = response.body()?.main?.temp_min.toString() + "º" + " / " + response.body()?.main?.temp_max.toString() + "º";
                pressureView.text = response.body()?.main?.pressure.toString() + "hPa";
                humidityView.text = response.body()?.main?.humidity.toString() + "%";
                cityView.text = "Tempo agora em " + response.body()?.name.toString();
            }
        })
    }
}

