package cg.tutorials.example.alertdialog

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var result : EditText?=null
        var btn1OpenDialog : Button?= null
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        result=findViewById(R.id.etResult)
        btn1OpenDialog=findViewById(R.id.btn)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn1OpenDialog?.setOnClickListener {
            var inputText: String = result.text.trim().toString()
            if(inputText.isNotEmpty()){
    AlertDialog.Builder(this).apply {
        setTitle("HELLO!!")
        setMessage(buildString {
            append("Press + to Add ${result.text}\n ")
            append("Press - to Add ${result.text?.trim()?.toString()}\n")
            append("Press Reset ")
        })
        setPositiveButton("+") { _, _ ->
            val currentVal = result.text.toString().toInt()
            val newVal = currentVal + inputText.toInt()
            result.setText(newVal.toString())
        }
        setNegativeButton("-"){ _ ,_ ->
            val currentVal = result.text.toString().toInt()
            val newVal = currentVal - inputText.toInt()
            result.setText(newVal.toString())
        }
        setNeutralButton("Reset"){_,_ ->
            val newVal:String ?= null
            result.setText(newVal)
        }
        setCancelable(false)
        show()
    }
}
else {
    Snackbar.make(it, "enter the no.", Snackbar.LENGTH_SHORT).show()
}
            }
        }
    }
