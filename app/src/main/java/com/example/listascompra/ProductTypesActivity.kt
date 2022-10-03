package com.example.listascompra

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.example.listascompra.databinding.ActivityMainBinding
import com.example.listascompra.databinding.ActivityProductTypesBinding
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class ProductTypesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductTypesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        findViewById<View>(android.R.id.content).transitionName = "shared_element_container_productos";
        setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback());

        window.sharedElementEnterTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content);
            duration = 1000L;
        }
        window.sharedElementReturnTransition = MaterialContainerTransform().apply {
            addTarget(android.R.id.content);
            duration = 850L;
        }

        super.onCreate(savedInstanceState)
        binding = ActivityProductTypesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.cardFrutasVerduras.setOnClickListener {
            var nameContainer = "shared_element_container_frutas_verduras";
            val intent = Intent(this, ProductListActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this, binding.cardFrutasVerduras, nameContainer)
            intent.putExtra("shared_element_container", nameContainer)
            startActivity(intent,options.toBundle());
        }

    }
}