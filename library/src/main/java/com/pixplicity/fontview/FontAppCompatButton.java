package com.pixplicity.fontview;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import com.pixplicity.fontview.utils.FontUtil;

public class FontAppCompatButton extends AppCompatButton {

    public FontAppCompatButton(Context context) {
        super(context);
    }

    public FontAppCompatButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(attrs, R.attr.buttonStyle);
    }

    public FontAppCompatButton(Context context, AttributeSet attrs, int defStyle) {
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
