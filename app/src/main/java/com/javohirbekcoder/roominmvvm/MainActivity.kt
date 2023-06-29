package com.javohirbekcoder.roominmvvm

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.javohirbekcoder.roominmvvm.database.UserDatabase
import com.javohirbekcoder.roominmvvm.databinding.ActivityMainBinding
import com.javohirbekcoder.roominmvvm.factory.Factory
import com.javohirbekcoder.roominmvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, Factory(application))[MainViewModel::class.java]

        binding.saveBtn.setOnClickListener {
            val name = binding.nameEt.text.toString()
            if (name.isNotEmpty() || name.length > 2){
                viewModel.saveUser(name)
                binding.nameEt.text.clear()
                Toast.makeText(this, "User Saved!", Toast.LENGTH_SHORT).show()
            }else{
                binding.nameEt.error = "Error!"
            }
        }

        viewModel.getListOfUser().observe(this){
            Toast.makeText(this, it.size.toString(), Toast.LENGTH_SHORT).show()
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, it)
            binding.myListView.adapter = adapter
        }
    }
}