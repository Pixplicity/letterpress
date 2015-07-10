letterpress
==============
Custom fonts without writing code.

<img src="https://raw.githubusercontent.com/Pixplicity/letterpress/master/raw/sample.png" width="350px"/>

Add custom fonts to your app with out writing code, just add the fonts to your them and use the customViews.

## Sample
Just define the views you want to apply the custom fonts on.

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

define the custom fonts that are in the assets folder, overriding the default parent style should make it uniform across the app. This is not required though.

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

Then in your layouts just use `FontTextView` instead of `TextView` and it will use the Action_Man font.

```XML
<com.pixplicity.fontview.FontTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="custom font from theme"/>
```

You can apply your custom fonts in a few ways via the Theme or via styles directly on the view or via the view attributes `pix_font`, `pix_fontBold`,`pix_fontItalic` or `pix_fontBoldItalic`

Check out the sample app to see how to set it up [Sample app](https://github.com/Pixplicity/letterpress/tree/master/app)

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

or Gradle:
```Java
compile 'com.pixplicity.letterpress:library:1.0'
```

## License

Licensed under the Apache license.
