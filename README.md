Letter Press
==============
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Letter%20Press-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/2120)
[![Build Status](https://travis-ci.org/Pixplicity/letterpress.svg)](https://travis-ci.org/Pixplicity/letterpress)

Custom typefaces without a single line of code!

<img src="https://raw.githubusercontent.com/Pixplicity/letterpress/master/raw/sample.png" width="350px"/>

With Letter Press, adding custom fonts to your app means not a single line of code is needed; simply add the fonts to your app, replace your views with their Font counterparts, and specify the fonts through attributes, styles and themes.

All fonts are referenced into (subdirectories of) the app's `assets` folder.

## Sample

You can apply your custom fonts in a few ways: by using the theme, by specifying a specific style per view, or on the view explicitly using view attributes `pix_font`, `pix_fontBold`,`pix_fontItalic` or `pix_fontBoldItalic`.

[Check out the sample app](https://github.com/Pixplicity/letterpress/tree/master/app) to see how easy it is to set up.

### Basic sample

The easiest example is to set a typeface through layout attributes. In your layouts, replace Android widgets with the Font counterparts. For instance, use `FontTextView` instead of `TextView` and it will use the *Action Man* font.

```XML
<com.pixplicity.fontview.FontTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:pix_font="fonts/Action_Man.ttf"
    android:text="Custom font from attributes"/>
```

### Style sample

Through a style, you can provide the same style to multiple views. By overriding the default parent style, it's easy enough to swap out existing styles (but is not required).

```XML
<resources>
    <style name="FontTextViewStyle" parent="@android:style/TextAppearance.Widget.TextView">
        <item name="pix_font">fonts/Action_Man.ttf</item>
        <item name="pix_fontBold">fonts/Action_Man_Bold.ttf</item>
        <item name="pix_fontItalic">fonts/Action_Man_Italic.ttf</item>
        <item name="pix_fontBoldItalic">fonts/Action_Man_Bold_Italic.ttf</item>
    </style>
</resources>
```

Define the style once, and you can reference it in multiple views, for instance:

```XML
<com.pixplicity.fontview.FontTextView
    style="@style/FontEditTextStyle"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Custom font from style"/>
```

### Theme sample

The most scalable way to set a common typeface is through providing a custom theme:

```XML
<resources>
    <!-- Base application theme. -->
    <style name="BaseTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="android:autoCompleteTextViewStyle">@style/FontAutoCompleteTextViewStyle</item>
        <item name="android:buttonStyle">@style/FontButtonStyle</item>
        <item name="android:checkboxStyle">@style/FontCheckBoxStyle</item>
        <item name="android:editTextStyle">@style/FontEditTextStyle</item>
        <item name="android:radioButtonStyle">@style/FontRadioButtonStyle</item>
        <item name="android:textViewStyle">@style/FontTextViewStyle</item>
        <item name="android:buttonStyleToggle">@style/FontToggleButton</item>
        <item name="autoCompleteTextViewStyle">@style/FontAutoCompleteTextViewStyle</item>
        <item name="buttonStyle">@style/FontButtonStyle</item>
        <item name="checkboxStyle">@style/FontCheckBoxStyle</item>
        <item name="editTextStyle">@style/FontEditTextStyle</item>
        <item name="radioButtonStyle">@style/FontRadioButtonStyle</item>
    </style>
    <style name="AppTheme" parent="BaseTheme">
    </style>
</resources>
```

Now, your FontTextView doesn't need any attributes or styles at all, and inherits the attributes from the default style:

```XML
<com.pixplicity.fontview.FontTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Custom font from theme"/>
```

# Download

Download the latest [AAR](http://search.maven.org/#search|ga|1|g:"com.pixplicity.letterpress") or grab via Maven:

```XML
<dependency>
  <groupId>com.pixplicity.letterpress</groupId>
  <artifactId>library</artifactId>
  <version>(insert latest version)</version>
  <type>aar</type>
</dependency>
```

Provide the dependency in Gradle:
```Groovy
compile 'com.pixplicity.letterpress:library:(insert latest version)'
```

## License

Licensed under the Apache license.
