package com.pixplicity.fontview.utils;

import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import com.pixplicity.fontview.R;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class FontUtil {

    private static final HashMap<String, WeakReference<Typeface>> TYPEFACES
            = new HashMap<>();

    public static void setFont(@NonNull TextView view, @NonNull AttributeSet attrs, int defStyle) {
        setFontFromAttributes(view, attrs, defStyle);
    }

    private static void setFontFromAttributes(@NonNull TextView view, @NonNull AttributeSet attrs, int defStyle) {
        String fontName = null;
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

        if (!TextUtils.isEmpty(fontName)) {
            setFont(view, fontName);
        }
    }

    public static void setFont(@NonNull TextView view, @NonNull String font) {
        if (view.isInEditMode()) {
            return;
        }
        Typeface tf = null;
        WeakReference<Typeface> ref = TYPEFACES.get(font);
        if (ref != null) {
            tf = ref.get();
        }
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(view.getContext().getAssets(), font);
            } catch (Exception e) {
                Log.e("FontText", "Could not get typeface: " + e.getMessage());
            }
            TYPEFACES.put(font, new WeakReference<>(tf));
        }
        view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        view.setTypeface(tf);
    }

    private FontUtil() {
        // Forbid class creation
    }

}
