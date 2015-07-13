package com.pixplicity.fontview.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.pixplicity.fontview.R;

import java.util.HashMap;

public final class FontUtil {

    private static final HashMap<String, Typeface> TYPEFACES
            = new HashMap<>();

    private static String getFontFromAttributes(@NonNull View view, @NonNull AttributeSet attrs, int defStyle) {
        String fontName = "";
        // Look up any layout-defined attributes
        // First obtain the textStyle
        TypedArray a = view.getContext()
                .obtainStyledAttributes(attrs, new int[]{
                        android.R.attr.textStyle
                });
        int fontStyle = 0;
        for (int i = 0; i < a.getIndexCount(); i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case 0:
                    fontStyle = a.getInt(attr, 0);
                    break;
            }
        }

        a.recycle();
        // Do the same for our custom attribute set
        a = view.getContext().obtainStyledAttributes(
                attrs, R.styleable.FontTextView, defStyle, 0);
        for (int i = 0; i < a.getIndexCount(); i++) {
            final int attr = a.getIndex(i);
            if (attr == R.styleable.FontTextView_pix_font) {
                if (TextUtils.isEmpty(fontName)) {
                    fontName = a.getString(attr);
                }
            } else if (attr == R.styleable.FontTextView_pix_fontBold) {
                if (TextUtils.isEmpty(fontName)
                        || ((fontStyle & Typeface.BOLD) != 0
                        && (fontStyle & Typeface.ITALIC) == 0)) {
                    fontName = a.getString(attr);
                }

            } else if (attr == R.styleable.FontTextView_pix_fontItalic) {
                if (TextUtils.isEmpty(fontName)
                        || ((fontStyle & Typeface.BOLD) == 0
                        && (fontStyle & Typeface.ITALIC) != 0)) {
                    fontName = a.getString(attr);
                }

            } else if (attr == R.styleable.FontTextView_pix_fontBoldItalic) {
                if (TextUtils.isEmpty(fontName)
                        || ((fontStyle & Typeface.BOLD) != 0
                        && (fontStyle & Typeface.ITALIC) != 0)) {
                    fontName = a.getString(attr);
                }
            }
        }
        a.recycle();
        return fontName;
    }

    public static Typeface getTypeface(@NonNull View view, @NonNull AttributeSet attrs, int defStyle) {
        return getTypeface(view.getContext(), getFontFromAttributes(view, attrs, defStyle));
    }

    public static Typeface getTypeface(@NonNull Context context, @NonNull String font) {
        synchronized (TYPEFACES) {
            Typeface tf = TYPEFACES.get(font);
            if (tf == null) {
                try {
                    tf = Typeface.createFromAsset(context.getAssets(), font);
                } catch (Exception e) {
                    Log.e("FontText", "Could not get typeface: " + e.getMessage());
                }
                TYPEFACES.put(font, tf);
            }
            return tf;
        }
    }

    private FontUtil() {
    }
}
