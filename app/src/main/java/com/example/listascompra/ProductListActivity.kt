package com.example.listascompra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.example.listascompra.databinding.ActivityMainBinding
import com.example.listascompra.databinding.ActivityProductListBinding
import com.example.listascompra.databinding.ActivityProductTypesBinding
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class ProductListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val nameContainer = intent.getStringExtra("shared_element_container")
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        if (nameContainer.equals("shared_element_container_frutas_verduras")) {
            findViewById<View>(android.R.id.content).transitionName = "shared_element_container_frutas_verduras";
        }

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
        binding = ActivityProductListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}