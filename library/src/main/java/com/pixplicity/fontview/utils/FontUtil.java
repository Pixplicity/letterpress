package com.pixplicity.fontview.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;

import com.pixplicity.fontview.R;

import java.util.Hashtable;

public final class FontUtil {

    private static final Hashtable<String, Typeface> TYPEFACES = new Hashtable<>();

    private static String getFontFromAttributes(@NonNull Context context, @NonNull AttributeSet attrs, int defStyle) {
        String fontName = "";
        // Look up any layout-defined attributes
        // First obtain the textStyle
        TypedArray a = context.obtainStyledAttributes(attrs, new int[]{
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
        a = context.obtainStyledAttributes(
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

    public static Typeface getTypeface(@NonNull Context context, @NonNull AttributeSet attrs, int defStyle) {
        return getTypeface(context, getFontFromAttributes(context, attrs, defStyle));
    }

    public static Typeface getTypeface(@NonNull Context context, @NonNull String fontName) {
        Typeface tf = TYPEFACES.get(fontName);
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), fontName);
            } catch (Exception e) {
                return null;
            }
            TYPEFACES.put(fontName, tf);
        }
        return tf;

    }

    private FontUtil() {
        // Forbid class creation
    }

}
