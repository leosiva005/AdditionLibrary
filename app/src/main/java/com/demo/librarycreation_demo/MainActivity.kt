package com.demo.librarycreation_demo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.demo.addition.Addition
import com.demo.librarycreation_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.addBtn.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.addBtn ->{
                if (binding.firstValue.text.isEmpty() && binding.secondValue.text.isEmpty()){
                    Toast.makeText(this, "Please enter values", Toast.LENGTH_SHORT).show()
                }else if (binding.firstValue.text.isEmpty()){
                    Toast.makeText(this, "Please first values", Toast.LENGTH_SHORT).show()
                }else if (binding.secondValue.text.isEmpty()){
                    Toast.makeText(this, "Please second values", Toast.LENGTH_SHORT).show()
                }else{

                    binding.answerTxt.text =   Addition.add(binding.firstValue.text.toString().toInt(),binding.secondValue.text.toString().toInt()).toString()
                }
            }
        }
    }
}

fun add(a:Int,b:Int):Int{
    return a + b
}