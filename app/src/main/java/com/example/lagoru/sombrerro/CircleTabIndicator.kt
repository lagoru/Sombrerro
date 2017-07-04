package com.example.lagoru.sombrerro

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout


/**
 * Created by lagoru on 03.06.17.
 */

class CircleTabIndicator : FrameLayout {

    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)

    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int) : super(ctx, attrs, defStyleAttr)

    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(ctx, attrs, defStyleAttr, defStyleRes)

    private val boundRect: Rect = Rect()
    private val prevChildRect: Rect = Rect()

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        // These are the far left and right edges in which we are performing layout.
        val leftPos = paddingLeft
        val rightPos = right - left - paddingRight

        // These are the top and bottom edges in which we are performing layout.
        val parentTop = paddingTop
        val parentBottom = bottom - top - paddingBottom

        val centerX = (leftPos + rightPos) / 2
        val centerY = (parentTop + parentBottom) / 2

        val radius = centerY - parentTop

        for (i in 0..childCount - 1) {
            val child = getChildAt(i)
            val width = child.measuredWidth
            val halfWidth = width / 2
            child.pivotX = centerX.toFloat()
            child.pivotY = centerY.toFloat()

            if (child.visibility == View.GONE) {
                continue
            }
            boundRect.left = centerX - halfWidth /*+ lp.leftMargin;*/
            boundRect.right = centerX + halfWidth /*+ width + lp.rightMargin;*/
            boundRect.top = parentTop
            boundRect.bottom = child.measuredHeight
            if (0 != i) child.rotation = i * 10F
            child.layout(boundRect.left, boundRect.top, boundRect.right, boundRect.bottom)
            prevChildRect.set(boundRect)
        }
    }
}