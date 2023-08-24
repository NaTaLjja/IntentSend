package com.example.intentshw

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class EmailActivity: Activity() {

    private lateinit var email: EditText
    private lateinit var message: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_layout)
        val buttonSend = findViewById<Button>(R.id.sendMessage)
        email = findViewById(R.id.address)
        message = findViewById(R.id.messageBody)

        buttonSend.setOnClickListener {
            val mail = arrayOf(email.text.toString())
            val messageText = message.text.toString()
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_EMAIL,mail)
                putExtra(Intent.EXTRA_TEXT,messageText)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent,null)
            startActivityForResult(shareIntent, REQUEST_CODE)
        }
    }

    companion object{
        const val REQUEST_CODE = 600
    }
}