package com.swing.sample_mvp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lib.StarWars
import com.example.lib.src.component.base.ResponseOnListener
import com.example.lib.src.remote.model.People
import com.example.lib.src.utils.Response

class MainActivity : AppCompatActivity() {

    private val starWars by lazy {
        StarWars.Builder()
            .setContext(applicationContext)
            .create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.callnetwork)
            .setOnClickListener {
                starWars.getPeople(object : ResponseOnListener<Response<People>> {
                    override fun onResult(result: Response<People>) {
                        when (result) {
                            is Response.Success -> {
                                runOnUiThread {
                                    findViewById<TextView>(R.id.textView).text =
                                        "${result.data.itemCount}"
                                }
                                Log.d("RESULT:: ", "${result.data}")
                            }

                            is Response.Error -> {
                                Log.d("RESULT:: ", "ERROR..")
                            }

                            is Response.Loading -> {
                                Log.d("RESULT:: ", "LOADING..")
                            }
                        }
                    }

                    override fun onFailed(error: String) {

                    }
                })
            }


    }
}
