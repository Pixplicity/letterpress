Letter Press
==============
Custom typefaces without a single line of code!

<img src="https://raw.githubusercontent.com/Pixplicity/letterpress/master/raw/sample.png" width="350px"/>

With Letter Press, adding custom fonts to your app means not a single line of code is needed; simply add the fonts to your app, replace your views with their Font counterparts, and specify the fonts through attributes, styles and themes.

## Sample
The easiest way to set a common typeface is through providing a custom theme:

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

Specify the styles to point to the custom fonts in the app's `assets` folder. By overriding the default parent style, it's easy enough to swap out existing styles (but is not required).

```XML
<resources>
    <style name="FontButtonStyle" parent="Widget.AppCompat.Button">
        <item name="pix_font">fonts/Action_Man.ttf</item>
        <item name="pix_fontBold">fonts/Action_Man_Bold.ttf</item>
        <item name="pix_fontItalic">fonts/Action_Man_Italic.ttf</item>
        <item name="pix_fontBoldItalic">fonts/Action_Man_Bold_Italic.ttf</item>
    </style>
    .....
    <style name="FontTextViewStyle" parent="@android:style/TextAppearance.Widget.TextView">
        <item name="pix_font">fonts/Action_Man.ttf</item>
        <item name="pix_fontBold">fonts/Action_Man_Bold.ttf</item>
        <item name="pix_fontItalic">fonts/Action_Man_Italic.ttf</item>
        <item name="pix_fontBoldItalic">fonts/Action_Man_Bold_Italic.ttf</item>
    </style>
</resources>
```

Now, in your layouts, replace Android widgets with the Font counterparts. For instance, use `FontTextView` instead of `TextView` and it will use the Action Man font.

```XML
<com.pixplicity.fontview.FontTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Custom font from theme"/>
```

You can apply your custom fonts in a few ways: by using the theme, by specifying a specific style per view, or on the view explicitly using view attributes `pix_font`, `pix_fontBold`,`pix_fontItalic` or `pix_fontBoldItalic`.

[Check out the sample app](https://github.com/Pixplicity/letterpress/tree/master/app) to see how easy it is to set up.

# Download

Download the latest [AAR](http://search.maven.org/#search|ga|1|g:"com.pixplicity.letterpress") or grab via Maven:

```XML
<dependency>
  <groupId>com.pixplicity.letterpress</groupId>
  <artifactId>library</artifactId>
  <version>1.0</version>
  <type>aar</type>
</dependency>
```

Provide the dependency in Gradle:
```Groovy
compile 'com.pixplicity.letterpress:library:1.0'
```

## License

Licensed under the Apache license.
