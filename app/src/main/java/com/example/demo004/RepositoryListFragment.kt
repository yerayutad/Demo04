package com.example.demo004

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.demo004.databinding.ActivityMainBinding
import com.example.demo004.databinding.FragmentRepositoryDetailBinding
import com.example.demo004.model.Beer
import com.example.demo004.network.PunkApiSevice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log


class RepositoryListFragment : Fragment() {
    private lateinit var clickMe : TextView
    private var _binding: FragmentRepositoryDetailBinding? = null
    private val binding
    get() = _binding !!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun requestData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.punkapi.com/v2")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(PunkApiSevice::class.java)
        service.getAllBeers().enqueue(object : Callback<List<Beer>>{
            override fun onResponse(call: Call<List<Beer>>, response: Response<List<Beer>>) {
                if (response.isSuccessful) {
                    Log.d("getAllBeers", "beers:${response.body()}")
                }else{
                    showError()
                }
            }

            override fun onFailure(call: Call<List<Beer>>, t: Throwable) {
                Log.d("OnFailure", "error ${t.message}", t)
            }
        })
    }
    private fun showError(){
        Toast.makeText(context, "Error en la peticion", Toast.LENGTH_SHORT).show()
    }
}