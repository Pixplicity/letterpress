package com.pixplicity.fontview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

import com.pixplicity.fontview.utils.FontUtil;

public class FontToggleButton extends ToggleButton {

    public FontToggleButton(Context context) {
        super(context);
    }

    public FontToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(attrs, android.R.attr.buttonStyleToggle);
    }

    public FontToggleButton(Context context, AttributeSet attrs, int defStyle) {
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
