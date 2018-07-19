package com.kotlintut.prathamesh.planetviewer

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import android.widget.Toast
import com.kotlintut.prathamesh.planetviewer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        val POSPLANET:String="planet position"
    }
    val pl=PlanetList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var amb: ActivityMainBinding = DataBindingUtil.setContentView(this@MainActivity,R.layout.activity_main)
        amb.recyclerView.setLayoutManager(LinearLayoutManager(this))
        amb.recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        var la=ListAdapter(this,pl)
        amb.recyclerView.setAdapter(la)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        val id = item?.itemId;
        when(id){

            R.id.AscendOption -> {
                pl.list.sortBy{it.diameter}

            }

            R.id.DescendOption -> {
                pl.list.sortByDescending{it.diameter}
            }

            else -> Toast.makeText(this,"Nothing!!",Toast.LENGTH_SHORT).show()
        }

        var amb2 : ActivityMainBinding = DataBindingUtil.setContentView(this@MainActivity,R.layout.activity_main)
        amb2.recyclerView.setLayoutManager(LinearLayoutManager(this))
        amb2.recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        var la=ListAdapter(this,pl)
        amb2.recyclerView.setAdapter(la)
        return super.onOptionsItemSelected(item)
    }
}
