package com.supremehyo.ui

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import android.R
import android.graphics.Color
import android.view.Gravity
import android.widget.Toast


class Button2 : AppCompatButton
{
    constructor(context: Context) : super(context){
        init(context)
    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        init(context)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init(context)
    }

    fun init(context: Context){
        gravity = Gravity.CENTER
        text = "UI 모듈 테스트 버튼"
        setBackgroundColor(Color.parseColor("#000000"))
        setTextColor(Color.WHITE)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> Toast.makeText(context, "다운", Toast.LENGTH_SHORT).show()
            MotionEvent.ACTION_UP -> Toast.makeText(context, "업", Toast.LENGTH_SHORT).show()
        }

        invalidate()
        return true
    }
}