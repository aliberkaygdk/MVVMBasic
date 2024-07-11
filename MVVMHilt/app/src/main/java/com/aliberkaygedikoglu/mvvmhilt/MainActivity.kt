package com.aliberkaygedikoglu.mvvmhilt

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.liveData
import com.aliberkaygedikoglu.mvvmhilt.databinding.ActivityMainBinding
import com.aliberkaygedikoglu.mvvmhilt.ui.viewmodel.ProductViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),LifecycleOwner {
    private lateinit var binding: ActivityMainBinding
    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.apply {
            button.setOnClickListener {
                if (binding.editTextId.text.isNotEmpty()){
                    productViewModel.getProduct(binding.editTextId.text.toString().toInt())
                }else{
                    Toast.makeText(this@MainActivity,"ID girin",Toast.LENGTH_SHORT).show()
                }

            }
        }

        productViewModel.product.observe(this){
            Log.d("Product",it.title)
            binding.textViewName.text = it.title
            Glide.with(this).load(it.thumbnail).into(binding.imageView)
        }

    }
}