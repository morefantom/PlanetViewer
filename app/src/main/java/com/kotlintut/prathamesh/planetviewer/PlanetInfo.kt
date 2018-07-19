package com.kotlintut.prathamesh.planetviewer

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlintut.prathamesh.planetviewer.databinding.ActivityPlanetInfoBinding

class PlanetInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val apib : ActivityPlanetInfoBinding = DataBindingUtil.setContentView(this,R.layout.activity_planet_info)
        val pos : Int = intent.getIntExtra(MainActivity.POSPLANET,-1)
        val pl=PlanetList()
        val data=pl.list.get(pos-1)
        apib.feed=data
        supportActionBar?.title=data.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
