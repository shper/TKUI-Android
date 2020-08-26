package cn.shper.tkui

import android.app.Activity
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.tkui_layout_titlebar.view.*

/**
 * Author : Shper
 * Date : 2020/8/24
 */
class TKTitleBar @JvmOverloads constructor(context: Context,
                                           attrs: AttributeSet? = null,
                                           defStyleAttr: Int = 0) :
  RelativeLayout(context, attrs, defStyleAttr) {

  private lateinit var leftView: View
  private lateinit var titleView: TKIconTextView

  init {
    View.inflate(context, R.layout.tkui_layout_titlebar, this)
    val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TKTitleBar)

    initTitleBar(typedArray)
    initLeftView(typedArray)
    initTitle(typedArray)
    //    initRightView(typedArray)
    //    initBottomLine(typedArray)

    typedArray.recycle()
  }

  fun initTitleBar(typedArray: TypedArray) {
    if (!typedArray.hasValue(R.styleable.TKTitleBar_android_background)) {
      setBackgroundColor(context.resources.getColor(R.color.tkui_white))
    }
  }

  fun initLeftView(typedArray: TypedArray) {
    leftView = tkui_titlebar_left_icon

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
    titleView = tkui_titlebar_title_tv

    val title = typedArray.getString(R.styleable.TKTitleBar_title)
    title?.let {
      titleView.text = title
    }
  }

  fun setLeftIcon(@StringRes resId: Int) {
    if (leftView is TKIconTextView) {
      (leftView as TKIconTextView).setText(resId)
    }
  }

  fun setLeftIconVisibility(visible: Boolean) {
    leftView.visibility = if (visible) View.VISIBLE else View.GONE
  }

  fun setLiftOnClickListener(listener: OnClickListener) {
    leftView.setOnClickListener(listener)
  }

}