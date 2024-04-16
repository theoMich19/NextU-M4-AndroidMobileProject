package fr.nextu.Michellon_theo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import fr.nextu.Michellon_theo.databinding.ActivityMain2Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listMovies.apply {
            adapter = MovieAdapter(Movies(emptyList()))
            layoutManager = LinearLayoutManager(this@MainActivity2)
        }
    }

    override fun onStart() {
        super.onStart()
        getPictureList()
    }


    private fun getPictureList() {
        CoroutineScope(Dispatchers.IO).launch {
            requestPictureList{
                binding.listMovies.adapter = MovieAdapter(moviesFromJson(it))

            }
        }
    }

    private fun moviesFromJson(json: String): Movies {
        val gson = Gson()
        return gson.fromJson(json, Movies::class.java)
    }

    private fun requestPictureList(callback: (String)-> Unit ) {
        val client = OkHttpClient()

        val request: Request = Request.Builder()
            .url("https://api.betaseries.com/movies/list")
            .get()
            .addHeader("X-BetaSeries-Key", "470d2afc452f")
            .build()

        val response: Response = client.newCall(request).execute() // request web

        CoroutineScope(Dispatchers.Main).launch {
            callback(response.body?.string() ?:"")
        }
    }

}