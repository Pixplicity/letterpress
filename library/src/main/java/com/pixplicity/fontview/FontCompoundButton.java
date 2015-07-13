package com.pixplicity.fontview;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.CompoundButton;

import com.pixplicity.fontview.utils.FontUtil;

public class FontCompoundButton extends CompoundButton {

    public FontCompoundButton(Context context) {
        super(context);
    }

    public FontCompoundButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(attrs, android.R.attr.buttonStyle);
    }

    public FontCompoundButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomTypeface(attrs, defStyle);
    }

    private void setCustomFont(AttributeSet attrs, int defStyle) {
        FontUtil.getTypeface(getContext(), attrs, defStyle);
    }

    public void setCustomTypeface(String font) {
        final Typeface tf = FontUtil.getTypeface(getContext(), font);
        setCustomTypeface(tf);
    }

    private void setCustomTypeface(AttributeSet attrs, int defStyle) {
        final Typeface tf = FontUtil.getTypeface(getContext(), attrs, defStyle);
        setCustomTypeface(tf);
    }

    private void setCustomTypeface(Typeface tf) {
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        setTypeface(tf);
    }

}
