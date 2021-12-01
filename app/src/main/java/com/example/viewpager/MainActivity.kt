package com.example.viewpager

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import com.example.wh.viewpagerkotlin.MyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream

@Suppress("DEPRECATION")
class MainActivity : Activity(), ViewPager.OnPageChangeListener {
    val TAG = "MainActivity"
    private var mPrePos = 0
    private var mView: ArrayList<ImageView> = arrayListOf()
    private var mBitmap: ArrayList<Bitmap> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initPoint()
        viewpager.adapter = MyAdapter(this, mView)
        viewpager.addOnPageChangeListener(this)

        Log.i(TAG, "onCreate: " + StaticMethod.getNull())
    }

    private fun initData() {
        mBitmap.add(readBitMap(R.drawable.ic_default1))
        mBitmap.add(readBitMap(R.drawable.ic_default2))
        mBitmap.add(readBitMap(R.drawable.ic_default3))
        mBitmap.add(readBitMap(R.drawable.ic_default4))
        mBitmap.add(readBitMap(R.drawable.ic_default5))

        for (i in 0 until mBitmap.size) {
            val iv = ImageView(this)
            iv.scaleType = ImageView.ScaleType.FIT_XY
            iv.setImageBitmap(mBitmap[i])
            mView.add(iv)
        }
    }

    private fun initPoint() {
        val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(18, 18)
        params.leftMargin = 15
        params.rightMargin = 15
        for (i in 0..4) {
            val iv = ImageView(this)
            iv.setBackgroundResource(R.drawable.pic_dot_normal)
            iv.layoutParams = params
            ll.addView(iv)
        }
        ll.getChildAt(0).setBackgroundResource(R.drawable.pic_dot_focus)
    }

    private fun readBitMap(resId: Int): Bitmap {
        val opt: BitmapFactory.Options = BitmapFactory.Options()
        opt.inPreferredConfig = Bitmap.Config.RGB_565
        opt.inPurgeable = true
        opt.inInputShareable = true
        val inputStream: InputStream? = resources.openRawResource(resId)
        return BitmapFactory.decodeStream(inputStream, null, opt)!!
    }

    /*******************OnPageChangeListener*******************/
    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        ll.getChildAt(mPrePos).setBackgroundResource(R.drawable.pic_dot_normal)
        ll.getChildAt(position).setBackgroundResource(R.drawable.pic_dot_focus)
        mPrePos = position
    }
}
