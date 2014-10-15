package de.jodamob.android.autolayout;

import android.content.res.Resources;

import java.util.Arrays;

import de.jodamob.android.logging.Log;

public class DynamicResourceLoader {

    public static final String TYPE_XML = "xml";
    public static final String TYPE_STRING = "string";
    public static final String TYPE_LAYOUT = "layout";
    public static final String TYPE_MENU = "menu";
    public static final String TYPE_DRAWABLE = "drawable";

    public static int getStringResourceByName(String type, String packageName, Resources resources, String... resourceNames) {
        for (String name : resourceNames) {
            int layout = resources.getIdentifier(name, type, packageName);
            if (layout > 0) {
                return layout;
            }
        }
        Log.e("could not find one of" + Arrays.toString(resourceNames));
        return 0;
    }
}
