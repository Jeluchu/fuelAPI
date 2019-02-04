@file:Suppress("DEPRECATION")

package com.jeluchu.fuelapiapp

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager

class MainActivity : AppCompatActivity() {

    var tvGetResponse: TextView? = null
    var progress: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewsAndWidgets()

        FuelManager.instance.basePath = "https://api.github.com"
    }

    private fun initViewsAndWidgets() {
        tvGetResponse = findViewById(R.id.tvGetResponse)
        progress = ProgressDialog(this)
        progress!!.setTitle("Ejemplo de API")
        progress!!.setMessage("Cargando...")
    }

    fun httpGetJson(view: View) {
        try {
            progress!!.show()
            Fuel.get("users/Jeluchu/repos").responseJson { _, _, result ->
                tvGetResponse!!.text = result.get().content
            }
        } catch (e: Exception) {
            tvGetResponse!!.text = e.message
        } finally {
            progress!!.dismiss()
        }
    }

}