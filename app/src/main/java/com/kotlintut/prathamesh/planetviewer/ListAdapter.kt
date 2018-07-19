package com.kotlintut.prathamesh.planetviewer

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlintut.prathamesh.planetviewer.databinding.ListitemBinding

class ListAdapter(var context: Context,val pl:PlanetList) : RecyclerView.Adapter<ListAdapter.ViewHolder>(), ClickingInterface {
    override fun onItemClick(n: Int) {
        val planetIntent=Intent(context,PlanetInfo::class.java)
        planetIntent.putExtra(MainActivity.POSPLANET,n)
        context.startActivity(planetIntent)
    }

//    private var pl=PlanetList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding:ListitemBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.listitem,parent,false)
        var vh=ViewHolder(binding)
        return vh
    }

    override fun getItemCount(): Int {
        return pl.list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mlib.setFeed(pl.list[position])
        holder.mlib.setEvent(this)
    }


    inner class ViewHolder(lib:ListitemBinding):RecyclerView.ViewHolder(lib.root){
        var mlib=lib
    }
}