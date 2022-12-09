package com.example.weatherapp

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.FragmentManager
import com.google.android.material.switchmaterial.SwitchMaterial
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var modeSwitch : Switch;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        modeSwitch = findViewById(R.id.nightMode);


        modeSwitch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            // do something, the isChecked will be
            // true if the switch is in the On position
            if (isChecked)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            else
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        })

        val fm: FragmentManager = supportFragmentManager

        fm.beginTransaction()
            .replace(R.id.infoFrag,InfoFragment(),null)
            .addToBackStack(null)
            .commit()

        fm.beginTransaction()
            .replace(R.id.detailsFrag1,DetailsFragment(),null)
            .addToBackStack(null)
            .commit()

        fm.beginTransaction()
            .add(R.id.detailsFrag2,DetailsFragment(),null)
            .addToBackStack(null)
            .commit()


    }
}