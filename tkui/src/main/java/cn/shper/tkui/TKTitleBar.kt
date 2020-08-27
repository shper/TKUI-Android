package cn.shper.tkui

import android.app.Activity
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import cn.shper.tkui.model.TKTitleBarStyle
import kotlinx.android.synthetic.main.tkui_layout_titlebar.view.*

/**
 * Author : Shper
 * Date : 2020/8/24
 */
class TKTitleBar @JvmOverloads constructor(context: Context,
                                           attrs: AttributeSet? = null,
                                           defStyleAttr: Int = 0) :
  RelativeLayout(context, attrs, defStyleAttr) {

  private var leftView: TKIconTextView
  private var titleView: TKIconTextView

  init {
    View.inflate(context, R.layout.tkui_layout_titlebar, this)
    val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TKTitleBar)

    leftView = tkui_titlebar_left_icon
    titleView = tkui_titlebar_title_tv

    initTitleBar(typedArray)
    initLeftView(typedArray)
    initTitle(typedArray)
    //    initRightView(typedArray)
    //    initBottomLine(typedArray)

    typedArray.recycle()
  }

  fun initTitleBar(typedArray: TypedArray) {
    if (typedArray.hasValue(R.styleable.TKTitleBar_style)) {
      when (typedArray.getInt(R.styleable.TKTitleBar_style, 0)) {
        TKTitleBarStyle.BLUE.ordinal -> {
          leftView.setTextColor(context.resources.getColor(R.color.tkui_white))
          titleView.setTextColor(context.resources.getColor(R.color.tkui_white))
          setBackgroundColor(context.resources.getColor(R.color.tkui_blue))
        }

        TKTitleBarStyle.NORMAL.ordinal -> {
          if (!typedArray.hasValue(R.styleable.TKTitleBar_android_background)) {
            setBackgroundColor(context.resources.getColor(R.color.tkui_white))
          }
        }
      }
    }
  }

  fun initLeftView(typedArray: TypedArray) {
    setLeftIcon(R.string.tkui_icon_back)

    setLiftOnClickListener(OnClickListener {
      if (context == null || context !is Activity) {
        return@OnClickListener
      }

      (context as Activity).finish()
      //      hideSoftKeyboard(context, leftView)
    })
  }

  fun initTitle(typedArray: TypedArray) {
    val title = typedArray.getString(R.styleable.TKTitleBar_title)
    title?.let {
      titleView.text = title
    }
  }

  fun setLeftIcon(@StringRes resId: Int) {
    leftView.setText(resId)
  }

  fun setLeftIconVisibility(visible: Boolean) {
    leftView.visibility = if (visible) View.VISIBLE else View.GONE
  }

  fun setLiftOnClickListener(listener: OnClickListener) {
    leftView.setOnClickListener(listener)
  }

}