package kz.step.hw4

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class FirstTaskActivity : AppCompatActivity() {
    private val num = "+77756808577"
    var sendButton: Button? = null
    var messageText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_task)
        initializeViews()
        initializeLiseners()
    }

    private fun initializeViews() {
        sendButton = findViewById(R.id.button_first_task_activity_send)
        messageText = findViewById(R.id.textview_first_task_activity_message)
    }

    private fun initializeLiseners() {
        sendButton?.setOnClickListener{
            val installed = isAppInstalled("com.whatsapp")

            if (installed) {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data =
                    Uri.parse("http://api.whatsapp.com/send?phone=" + num + "&text=" + messageText?.text)
                startActivity(intent)
            } else {
                Toast.makeText(this@FirstTaskActivity, "Whatsapp is not installed!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun isAppInstalled(s: String): Boolean {
        val packageManager = packageManager
        var is_installed: Boolean
        try {
            packageManager.getPackageInfo(s, PackageManager.GET_ACTIVITIES)
            is_installed = true
        } catch (e: PackageManager.NameNotFoundException) {
            is_installed = false
            e.printStackTrace()
        }
        return is_installed
    }

}