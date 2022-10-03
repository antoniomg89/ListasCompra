package com.example.listascompra

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.listascompra.databinding.ActivityLoginBinding
import com.example.listascompra.databinding.ActivityMainBinding
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())
        window.sharedElementsUseOverlay = false

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //val user = intent.getStringExtra("username")
        //textViewMainActivityProductos.text = "nuevo"

        binding.cardProductos.setOnClickListener {
            val intent = Intent(this, ProductTypesActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this, binding.cardProductos, "shared_element_container_productos")
            startActivity(intent,options.toBundle());
        }

        binding.cardListas.setOnClickListener {
            val intent = Intent(this, ShoppingListsActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this, binding.cardListas, "shared_element_container_listas")
            startActivity(intent,options.toBundle());
        }

    }

    override fun onBackPressed() {
        super.onBackPressed();

        val intent = Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}