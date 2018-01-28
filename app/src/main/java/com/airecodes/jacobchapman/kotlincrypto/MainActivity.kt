package com.airecodes.jacobchapman.kotlincrypto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.airecodes.jacobchapman.kotlincrypto.views.CurrencyListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                    .replace(R.id.main_content, CurrencyListView())
                    .commit()
    }
}
