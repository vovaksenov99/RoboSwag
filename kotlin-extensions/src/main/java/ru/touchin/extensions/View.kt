package ru.touchin.extensions

import android.os.Build
import android.view.View

private const val RIPPLE_EFFECT_DELAY = 150L

/**
 * Sets click listener to view. On click it will call something after delay.
 *
 * @param delay     Delay after which click listener will be called;
 * @param listener  Click listener.
 */
fun View.setOnRippleClickListener(delay: Long = RIPPLE_EFFECT_DELAY, listener: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        setOnClickListener { postDelayed({ if (hasWindowFocus()) listener() }, delay) }
    } else {
        setOnClickListener { listener() }
    }
}