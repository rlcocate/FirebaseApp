package com.nossafirma.firebaseapp.firebaseapp.extensions

import android.support.design.widget.TextInputLayout

fun TextInputLayout.getText() : String {
    // ?  --> quase certeza que não vai ocorrer erro.
    // !! --> certeza que não vai ocorrer erro.
    return editText?.text.toString()
}