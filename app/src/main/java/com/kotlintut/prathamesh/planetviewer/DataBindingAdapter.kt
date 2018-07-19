package com.kotlintut.prathamesh.planetviewer

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView

class DataBindingAdapter {

    companion object {
        @JvmStatic
        @BindingAdapter("imageResource")
        fun setImageResource(iv:ImageView, res:Int){iv.setImageResource(res)}

//        @JvmStatic
//        @BindingAdapter("android:text")
//        fun setText(view:TextView, value:Int){
//            if (view.text!=null && !view.text.toString().isEmpty() && (view.text.toString()).toInt()!=value)
//            view.setText(value.toString())
//        }
    }
}

