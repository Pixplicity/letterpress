package com.pixplicity.fontview;

import android.content.Context;
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
        setCustomFont(attrs, defStyle);
    }

    private void setCustomFont(AttributeSet attrs, int defStyle) {
        FontUtil.setFont(this, attrs, defStyle);
    }

    public void setFont(String font) {
        FontUtil.setFont(this, font);
    }

}
