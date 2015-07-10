package com.pixplicity.fontview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;

import com.pixplicity.fontview.utils.FontUtil;

public class FontMultiAutoCompleteTextView extends MultiAutoCompleteTextView {
    public FontMultiAutoCompleteTextView(Context context) {
        super(context);
    }

    public FontMultiAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(attrs, android.R.attr.autoCompleteTextViewStyle);
    }

    public FontMultiAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(attrs, defStyle);
    }

    private void setCustomFont(AttributeSet attrs, int defStyle) {
        FontUtil.setFont(this, attrs, defStyle);
    }

    public void setFont(String font) {
        FontUtil.setFont(this, font);
    }
}
