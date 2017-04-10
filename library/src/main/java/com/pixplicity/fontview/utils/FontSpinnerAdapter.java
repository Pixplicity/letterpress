package com.pixplicity.fontview.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.ArrayRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.pixplicity.fontview.R;

/**
 * A simple ArrayAdapter meant to apply the default typeface to Spinners
 */
public class FontSpinnerAdapter extends ArrayAdapter<String> {

    private final Typeface mTypeface;

    public FontSpinnerAdapter(@NonNull Context context, @NonNull Typeface typeface,
                              @ArrayRes int strArray) {
        this(context, typeface, R.layout.li_spinner, strArray);
    }

    public FontSpinnerAdapter(@NonNull Context context, @NonNull Typeface typeface,
                              @LayoutRes int listItem, @ArrayRes int strArray) {
        super(context, listItem, context.getResources().getStringArray(strArray));
        mTypeface = typeface;
    }

    // Affects default (closed) state of the spinner
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        FontUtil.applyTypeface(view, mTypeface);
        return view;
    }

    // Affects opened state of the spinner
    @NonNull
    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        TextView view = (TextView) super.getDropDownView(position, convertView, parent);
        FontUtil.applyTypeface(view, mTypeface);
        return view;
    }
}