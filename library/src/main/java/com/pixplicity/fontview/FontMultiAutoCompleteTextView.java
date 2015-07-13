package com.pixplicity.fontview;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;

import com.pixplicity.fontview.utils.FontUtil;

public class FontMultiAutoCompleteTextView extends MultiAutoCompleteTextView {

    public FontMultiAutoCompleteTextView(Context context) {
        super(context);
    }

    public FontMultiAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomTypeface(attrs, android.R.attr.autoCompleteTextViewStyle);
    }

    public FontMultiAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomTypeface(attrs, defStyle);
    }

    public void setCustomTypeface(String font) {
        final Typeface tf = FontUtil.getTypeface(getContext(), font);
        setCustomTypeface(tf);
    }

    private void setCustomTypeface(AttributeSet attrs, int defStyle) {
        final Typeface tf = FontUtil.getTypeface(this, attrs, defStyle);
        setCustomTypeface(tf);
    }

    private void setCustomTypeface(Typeface tf) {
        setPaintFlags(getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        setTypeface(tf);
    }

}
