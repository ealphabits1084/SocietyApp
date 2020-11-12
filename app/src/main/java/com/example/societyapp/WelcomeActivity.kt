package com.example.societyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.example.societyapp.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        uiListeners()
    }

    /*****************************************************************
     * Method Name : uiListeners
     * Description : This method is used for handling click UI
     * listeners
     *****************************************************************/
    private fun uiListeners() {
        binding.btnLogin.setOnClickListener(fun(_: View) {
            startActivity(Intent(this, LoginActivity::class.java))
        })
    }
}