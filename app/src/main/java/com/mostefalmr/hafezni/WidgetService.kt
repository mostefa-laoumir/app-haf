package com.mostefalmr.hafezni

import android.app.Service
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class WidgetService: Service() {
    var LAYOUT_FLAG:Int? = null
    var mFloatingView: View?=null
    var windowManager: WindowManager?=null
    var imageClose: ImageView?=null
    var tvWidget: TextView?=null
    var height:Int? = null
    var width:Int? = null

    override fun onBind(intent: Intent?): IBinder? {

        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        }else{
            LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE

        }
        mFloatingView = LayoutInflater.from(this).inflate(R.layout.layout_widget, null)
        var layoutParams: WindowManager.LayoutParams = WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                LAYOUT_FLAG!!,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT)
                layoutParams.gravity = Gravity.TOP or Gravity.RIGHT
                layoutParams.x = 0
                layoutParams.y = 100


        var imageParams: WindowManager.LayoutParams = WindowManager.LayoutParams(800,200,LAYOUT_FLAG!!,WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,PixelFormat.TRANSLUCENT)
        imageParams.gravity = Gravity.BOTTOM or Gravity.CENTER
        imageParams.y = 100
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        imageClose = ImageView(this)
        imageClose!!.setImageResource(R.drawable.close)
        imageClose!!.visibility = View.INVISIBLE
        windowManager!!.addView(imageClose, imageParams)
        windowManager!!.addView(mFloatingView, layoutParams)
        mFloatingView!!.visibility= View.VISIBLE

        height = windowManager!!.defaultDisplay.height
        width = windowManager!!.defaultDisplay.width
        tvWidget = mFloatingView!!.findViewById(R.id.text_widget) as TextView
        tvWidget!!.text = "BE MOTIVATED"
        
        tvWidget!!.setOnTouchListener(object : View.OnTouchListener{
            var initialX: Int? = null
            var initialY: Int? = null
            var initialTouchX: Float? = null
            var initialTouchY: Float? = null
            var startClickTime: Long? = null
            var MAX_CLICK_DURATION = 200
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when(event?.action){
                    MotionEvent.ACTION_DOWN ->{
                        startClickTime = Calendar.getInstance().timeInMillis
                        imageClose!!.visibility =View.VISIBLE

                        initialX = layoutParams.x
                        initialY = layoutParams.y

                        initialTouchX = event.getRawX()
                        initialTouchY = event.getRawY()
                        return true
                    }
                    MotionEvent.ACTION_UP->{
                        var clickDuration:Long = Calendar.getInstance().timeInMillis - startClickTime!!
                        imageClose!!.visibility = View.GONE
                        layoutParams.x = initialX!! + (initialTouchX!!.toInt()-event.getRawX().toInt())
                        layoutParams.y = initialY!! + (event.getRawY().toInt()- initialTouchY!!.toInt())

                        if(clickDuration<MAX_CLICK_DURATION){
                            Toast.makeText(this@WidgetService, tvWidget!!.text,Toast.LENGTH_SHORT).show()
                        }else{
                            if(layoutParams.y>(height!! *0.6)){
                                stopSelf()
                            }
                        }
                        return true
                    }
                    MotionEvent.ACTION_MOVE->{
                        layoutParams.x = initialX!! + (initialTouchX!!.toInt()-event.getRawX().toInt())
                        layoutParams.y = initialY!! + (event.getRawY().toInt()- initialTouchY!!.toInt())as Int

                        windowManager!!.updateViewLayout(mFloatingView,layoutParams)
                        if (layoutParams.y>(height!! * 0.6)){
                            imageClose!!.setImageResource(R.drawable.close_red)
                        }else{
                            imageClose!!.setImageResource(R.drawable.close)
                        }
                        return true
                    }
                }


                return false
            }

        })


        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        if(mFloatingView!=null){
            windowManager!!.removeView(mFloatingView)
        }
        if(imageClose!=null){
            windowManager!!.removeView(imageClose)

        }
    }
}