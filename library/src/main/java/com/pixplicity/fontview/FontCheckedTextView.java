package com.pixplicity.fontview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

import com.pixplicity.fontview.utils.FontUtil;


/**
 * Extension of {@link CheckedTextView} to cope with custom typefaces. Specify the desired font using the
 * {@code font="myfont.ttf"} attribute, or specify it directly using {@link #setFont(String)}.
 * <p>
 * Typeface management is regulated through {@link FontUtil}.
 * </p>
 *
 * @author Pixplicity
 */
@TargetApi(3)
public class FontCheckedTextView extends CheckedTextView {
    public FontCheckedTextView(Context context) {
        super(context);
    }

    public FontCheckedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(attrs, R.attr.checkedTextViewStyle);
    }

    public FontCheckedTextView(Context context, AttributeSet attrs, int defStyle) {
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
