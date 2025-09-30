package com.example.codelab_fragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    val btnFragmentSatu = findViewById<Button>(R.id.btnFragmentSatu)
    val btnFragmentDua = findViewById<Button>(R.id.btnFragmentDua)


        if (savedInstanceState==null){
            replaceFragment(FSatu())
        }

    }



    private fun replaceFragment(fragment : Fragment){
        val fragmentmanaget = supportFragmentManager
        val fragmenttransaction = fragmentmanaget.beginTransaction()

        fragmenttransaction.replace(R.id.fragment_container,fragment)
        fragmenttransaction.addToBackStack(null)
        fragmenttransaction.commit()

    }

}