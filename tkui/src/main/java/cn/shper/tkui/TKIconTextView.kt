package cn.shper.tkui

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * Author : Shper
 * Date : 2020/8/24
 */
class TKIconTextView @JvmOverloads constructor(context: Context,
                                               attrs: AttributeSet? = null,
                                               defStyleAttr: Int = 0) :
  AppCompatTextView(context, attrs, defStyleAttr) {

  init {
    val iconFont = Typeface.createFromAsset(context.assets, "tkui/tk_iconfont.ttf")
    typeface = iconFont
  }

}