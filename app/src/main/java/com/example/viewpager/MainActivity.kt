package com.example.viewpager

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.wh.viewpagerkotlin.MyAdapter
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : BaseActivity(), ViewPager.OnPageChangeListener, View.OnClickListener {
    companion object {
        private const val TAG = "MainActivity"
    }

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

        val singleTon = SingleTon.getInstance()
        Log.i(TAG, "onCreate: " + singleTon.getS())
        Log.i(TAG, "onCreate: " + StaticMethod.getNull())
        toast("toast", Toast.LENGTH_LONG)
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
            iv.setOnClickListener(this)
            mView.add(iv)
        }
    }

    private fun initPoint() {
        val params = LinearLayout.LayoutParams(18, 18)
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
        val opt = BitmapFactory.Options()
        opt.inPreferredConfig = Bitmap.Config.RGB_565
        opt.inPurgeable = true
        opt.inInputShareable = true
        val inputStream = resources.openRawResource(resId)
        return BitmapFactory.decodeStream(inputStream, null, opt)!!
    }

    override fun onClick(v: View?) {
        Log.i(TAG, "onClick: v = 第 $mPrePos 个")
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
