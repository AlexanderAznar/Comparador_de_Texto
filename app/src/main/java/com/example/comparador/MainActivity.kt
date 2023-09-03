package com.example.comparador

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import android.widget.TextView
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import com.example.comparador.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)

        // Agrega un observador para el resultado y el color del texto
        viewModel.result.observe(this, Observer { result ->
            binding.resultTextView.text = result
        })

        viewModel.textColor.observe(this, Observer { color ->
            binding.resultTextView.setTextColor(color)
        })

        binding.compareButton.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()

            viewModel.setText1(text1)
            viewModel.setText2(text2)

            viewModel.compareTexts()

            // Cerrar el teclado virtual
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }

    fun openLinkedInProfile(view: View) {
        val linkedinUrl = "https://www.linkedin.com/in/alexanderaznar/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedinUrl))
        startActivity(intent)
    }

    fun openGitHubProfile(view: View) {
        val githubUrl = "https://github.com/AlexanderAznar"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
        startActivity(intent)
    }
}
