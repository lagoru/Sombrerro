package com.example.lagoru.sombrerro

import android.content.Context
import android.graphics.*
import android.view.View

/**
 * Created by lagoru on 03.06.17.
 */

class BendedText(context: Context) : View(context) {
    private val MY_TEXT = "xjaphx: Draw Text on Curve";
    private var arc: Path? = null

    private var paintText: Paint? = null

    init {
        arc = Path()
        val oval = RectF(50F, 100F, 200F, 250F)
        arc!!.addArc(oval, (-180).toFloat(), 200F)
        paintText = Paint(Paint.ANTI_ALIAS_FLAG)
        paintText!!.setStyle(Paint.Style.FILL_AND_STROKE)
        paintText!!.setColor(Color.WHITE)
        paintText!!.setTextSize(20f)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawTextOnPath(MY_TEXT, arc, 0F, 20F, paintText);
        invalidate();
    }
}