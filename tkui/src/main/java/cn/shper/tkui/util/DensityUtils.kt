package cn.shper.tkui.util

import android.content.Context
import android.util.DisplayMetrics


/**
 * Author : Shper
 * Date : 2020/8/24
 */
object DensityUtils {

  /**
   * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
   *
   * @param context 上下文
   * @param dpValue 尺寸dip
   * @return 像素值
   */
  fun dp2px(context: Context, dpValue: Float): Float {
    val scale: Float = context.resources.displayMetrics.density
    return dpValue * scale
  }

  /**
   * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
   *
   * @param context 上下文
   * @param pxValue 尺寸像素
   * @return DIP值
   */
  fun px2dp(context: Context, pxValue: Float): Float {
    val scale: Float = context.resources.displayMetrics.density
    return pxValue / scale
  }

  /**
   * 根据手机的分辨率从 px(像素) 的单位 转成为 sp
   *
   * @param pxValue 尺寸像素
   * @return SP值
   */
  fun px2sp(context: Context, pxValue: Float): Float {
    val fontScale: Float = context.resources.displayMetrics.scaledDensity
    return pxValue / fontScale
  }

  /**
   * 根据手机的分辨率从 sp 的单位 转成为 px
   *
   * @param spValue SP值
   * @return 像素值
   */
  fun sp2px(context: Context, spValue: Float): Float {
    val fontScale: Float = context.resources.displayMetrics.scaledDensity
    return spValue * fontScale
  }

  /**
   * DisplayMetrics
   *
   * @return
   */
  fun getDisplayMetrics(context: Context): DisplayMetrics {
    return context.resources.displayMetrics
  }

  /**
   * 获取屏幕分辨率
   *
   * @return 屏幕分辨率幕高度
   */
  fun getScreenDpi(context: Context): Int {
    return getDisplayMetrics(context).densityDpi
  }

  /**
   * 获取真实屏幕密度
   *
   * @param context 上下文【注意，Application和Activity的屏幕密度是不一样的】
   * @return
   */
  fun getRealDpi(context: Context): Int {
    val metric: DisplayMetrics = context.resources.displayMetrics
    val xdpi = metric.xdpi
    val ydpi = metric.ydpi
    return ((xdpi + ydpi) / 2.0f + 0.5f).toInt()
  }

}