package com.example.wh.viewpagerkotlin

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter

class MyAdapter(context: Context, arrayList: ArrayList<ImageView>) : PagerAdapter() {
    private var mContext: Context? = null
    private var mList: ArrayList<ImageView> = arrayListOf<ImageView>()

    init {
        mList = arrayList
    }

    override fun getCount(): Int {
        return mList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container!!.addView(mList[position])
        return mList.get(position)
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container!!.removeView(mList[position])
    }
}