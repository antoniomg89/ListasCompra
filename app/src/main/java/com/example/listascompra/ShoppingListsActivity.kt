package com.example.listascompra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class ShoppingListsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        findViewById<View>(android.R.id.content).transitionName = "shared_element_container_listas";
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
        setContentView(R.layout.activity_shopping_lists)
    }
}