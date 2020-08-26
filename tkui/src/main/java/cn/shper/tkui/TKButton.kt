package cn.shper.tkui

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import androidx.appcompat.widget.AppCompatButton

/**
 * Author : Shper
 * Date : 2020/8/24
 */
class TKButton @JvmOverloads constructor(context: Context,
                                         attrs: AttributeSet? = null,
                                         defStyleAttr: Int = 0) :
  AppCompatButton(context, attrs, defStyleAttr) {

  private lateinit var gradientDrawable: GradientDrawable

  init {
    val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TKButton)
    setupDefault()
    setupBackground(typedArray)
    typedArray.recycle()
  }

  private fun setupDefault() {
    isAllCaps = false
    gravity = Gravity.CENTER

    textAlignment = View.TEXT_ALIGNMENT_CENTER
    textSize = 18.0f
    setTextColor(context.resources.getColor(R.color.tkui_white))
  }

  private fun setupBackground(typedArray: TypedArray) {
    val radius: Int =
      typedArray.getDimensionPixelSize(R.styleable.TKButton_radius, -1)
    val leftTopRadius: Int =
      typedArray.getDimensionPixelSize(R.styleable.TKButton_leftTopRadius, -1)
    val leftBottomRadius: Int =
      typedArray.getDimensionPixelSize(R.styleable.TKButton_leftBottomRadius, -1)
    val rightTopRadius: Int =
      typedArray.getDimensionPixelSize(R.styleable.TKButton_rightTopRadius, -1)
    val rightBottomRadius: Int =
      typedArray.getDimensionPixelSize(R.styleable.TKButton_rightBottomRadius, -1)

    val backgroundColor = typedArray.getColor(R.styleable.TKButton_backgroundColor,
                                              context.resources.getColor(R.color.tkui_blue))

    gradientDrawable = GradientDrawable()
    gradientDrawable.setColor(backgroundColor)

    if (radius > 0) {
      gradientDrawable.cornerRadius = radius.toFloat()
    } else if (leftTopRadius > 0 || leftBottomRadius > 0 || rightTopRadius > 0 || rightBottomRadius > 0) {
      gradientDrawable.cornerRadii = floatArrayOf(leftTopRadius.toFloat(),
                                                  leftTopRadius.toFloat(),
                                                  rightTopRadius.toFloat(),
                                                  rightTopRadius.toFloat(),
                                                  rightBottomRadius.toFloat(),
                                                  rightBottomRadius.toFloat(),
                                                  leftBottomRadius.toFloat(),
                                                  leftBottomRadius.toFloat())
    } else {
      gradientDrawable.cornerRadius = context.resources.getDimension(R.dimen.tkui_30_dp)
    }

    setBackgroundDrawable(gradientDrawable)
  }

  /**
   * 设置圆角弧度
   *
   * @param radius     四周角的弧度
   */
  fun setRadius(radius: Float): TKButton? {
    gradientDrawable.cornerRadius = radius
    setBackgroundDrawable(gradientDrawable)
    return this
  }

  /**
   * 设置圆角弧度
   *
   * @param leftTopRadius     左上角弧度
   * @param leftBottomRadius  左下角弧度
   * @param rightTopRadius    右上角弧度
   * @param rightBottomRadius 右下角弧度
   */
  fun setRadius(leftTopRadius: Float, leftBottomRadius: Float,
                rightTopRadius: Float, rightBottomRadius: Float): TKButton? {
    gradientDrawable.cornerRadii = floatArrayOf(leftTopRadius,
                                                leftTopRadius,
                                                rightTopRadius,
                                                rightTopRadius,
                                                rightBottomRadius,
                                                rightBottomRadius,
                                                leftBottomRadius,
                                                leftBottomRadius)
    setBackgroundDrawable(gradientDrawable)
    return this
  }

}