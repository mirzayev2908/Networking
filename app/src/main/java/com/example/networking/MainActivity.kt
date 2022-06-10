package com.example.networking

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build.VERSION.SDK
import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.networking.databinding.ActivityMainBinding
import com.example.networking.utils.NetworkHelper

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var networkHelper: NetworkHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        networkHelper= NetworkHelper(this)

        if (networkHelper.isNetworkConnected()){
            binding.tv.text="Connected"
        }else{
            binding.tv.text="Disconnected"
        }

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