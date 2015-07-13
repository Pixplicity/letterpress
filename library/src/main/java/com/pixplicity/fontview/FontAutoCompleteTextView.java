package com.pixplicity.fontview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

import com.pixplicity.fontview.utils.FontUtil;

/**
 * Extension of {@link AutoCompleteTextView} to cope with custom typefaces. Specify the desired font
 * using the {@code font="myfont.ttf"} attribute, or specify it directly using
 * {@link #setCustomTypeface(String)}.
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
        setCustomTypeface(attrs, android.R.attr.autoCompleteTextViewStyle);
    }

    public FontAutoCompleteTextView(Context context, AttributeSet attrs,
                                    int defStyle) {
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
