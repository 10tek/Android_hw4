package kz.step.hw4

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SecondTaskActivity : AppCompatActivity() {
    var signInButton: Button? = null
    var loginText: EditText? = null
    var passwordText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task)
        initializeViews()
        initializeLiseners()
    }

    private fun initializeViews() {
        signInButton = findViewById(R.id.button_second_task_activity_sign_in)
        loginText = findViewById(R.id.textview_second_task_activity_login)
        passwordText = findViewById(R.id.textview_second_task_activity_password)
    }

    private fun initializeLiseners() {
        signInButton?.setOnClickListener{
            val installed = isAppInstalled("com.whatsapp")

            if (installed) {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Login: $loginText\nPassword: $passwordText")
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, null)
                sendIntent.setPackage ("com.whatsapp");
                startActivity(shareIntent)
            } else {
                Toast.makeText(this@SecondTaskActivity, "Whatsapp is not installed!", Toast.LENGTH_SHORT)
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