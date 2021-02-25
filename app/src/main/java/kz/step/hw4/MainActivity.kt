package kz.step.hw4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var sendMessageButton: Button? = null
    var signUpButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
        initializeLiseners()
    }

    private fun initializeViews() {
        sendMessageButton = findViewById(R.id.button_main_activity_send_message)
        signUpButton = findViewById(R.id.button_main_activity_sign_up)
    }

    private fun initializeLiseners() {
        sendMessageButton?.setOnClickListener {
            val intent = Intent(this@MainActivity, FirstTaskActivity::class.java)
            startActivity(intent)
        }

        signUpButton?.setOnClickListener{
        }
    }
}