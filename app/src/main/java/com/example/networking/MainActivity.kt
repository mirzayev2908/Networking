package com.example.networking

import android.graphics.Bitmap
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.Volley
import com.example.networking.databinding.ActivityMainBinding
import com.example.networking.utils.NetworkHelper

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var networkHelper: NetworkHelper
    lateinit var requestQueue: RequestQueue


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkHelper = NetworkHelper(this)

        if (networkHelper.isNetworkConnected()) {
          requestQueue=Volley.newRequestQueue(this)

             fetchImageLoad()

//            binding.tv.text = "Connected"
        } else {

            binding.tv.text = "Disconnected"
        }

    }

    private fun fetchImageLoad() {
        val imageRequest=ImageRequest("https://www.instagram.com/p/CF2WtGDA_GE/",
            { response -> binding.imageView.setImageBitmap(response) },0,0,
            ImageView.ScaleType.CENTER_CROP,Bitmap.Config.ARGB_8888
        ) { error -> binding.tv.text = error?.message }
        requestQueue.add(imageRequest)
    }


//    private fun isNetworkConnected():Boolean{
//        val connectivityManager=getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//
//        if (android.os.Build.VERSION.SDK_INT==android.os.Build.VERSION_CODES.M){
//            val activeNetwork = connectivityManager.activeNetwork
//            val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)
//            return networkCapabilities!=null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
//        } else{
//            val activeNetworkInfo = connectivityManager.activeNetworkInfo
//            return activeNetworkInfo!=null&& activeNetworkInfo.isConnected
//        }
//    }
}