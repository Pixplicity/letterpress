package com.pixplicity.fontview;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import com.pixplicity.fontview.utils.FontUtil;

public class FontAppCompatEditText extends AppCompatEditText {
    public FontAppCompatEditText(Context context) {
        super(context);
    }

    public FontAppCompatEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(attrs, R.attr.editTextStyle);
    }

    public FontAppCompatEditText(Context context, AttributeSet attrs, int defStyle) {
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
