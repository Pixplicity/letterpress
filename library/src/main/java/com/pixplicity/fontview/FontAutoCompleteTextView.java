package com.pixplicity.fontview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import com.pixplicity.fontview.utils.FontUtil;

/**
 * Extension of {@link AutoCompleteTextView} to cope with custom typefaces. Specify the desired font
 * using the {@code font="myfont.ttf"} attribute, or specify it directly using
 * {@link #setFont(String)}.
 * <p>
 * Typeface management is regulated through {@link FontUtil}.
 * </p>
 *
 * @author Pixplicity
 */
@TargetApi(3)
public class FontAutoCompleteTextView extends AutoCompleteTextView {

    public FontAutoCompleteTextView(Context context) {
        super(context);
    }

    public FontAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(attrs, android.R.attr.autoCompleteTextViewStyle);
    }

    public FontAutoCompleteTextView(Context context, AttributeSet attrs,
                                    int defStyle) {
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
