package de.jodamob.android.autolayout;

import android.app.Activity;
import android.app.Fragment;
import android.preference.PreferenceFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NameConverter {

    public static int convertToResourceMenuId(Fragment fragment) {
        return DynamicResourceLoader.getStringResourceByName(
                DynamicResourceLoader.TYPE_MENU,
                fragment.getActivity().getPackageName(),
                fragment.getResources(),
                convertToResourceName(fragment));
    }

    public static int convertToResourceLayoutId(Fragment fragment) {
        Class<?> aClass = fragment.getClass();
        if (aClass.isAnnotationPresent(InjectLayout.class)) {
            return aClass.getAnnotation(InjectLayout.class).value();
        }
        return DynamicResourceLoader.getStringResourceByName(
                DynamicResourceLoader.TYPE_LAYOUT,
                fragment.getActivity().getPackageName(),
                fragment.getResources(),
                convertToResourceName(fragment));
    }

    public static int convertToResourceXmlId(PreferenceFragment fragment) {
        return DynamicResourceLoader.getStringResourceByName(
                DynamicResourceLoader.TYPE_XML,
                fragment.getActivity().getPackageName(),
                fragment.getResources(),
                convertToResourceName(fragment));
    }

    public static int convertToResourceLayoutId(Activity activity) {
        Class<?> aClass = activity.getClass();
        if (aClass.isAnnotationPresent(InjectLayout.class)) {
            return aClass.getAnnotation(InjectLayout.class).value();
        }
        return DynamicResourceLoader.getStringResourceByName(
                DynamicResourceLoader.TYPE_LAYOUT,
                   activity.getPackageName(),
                   activity.getResources(),
                   convertToResourceName(activity));
    }

    public static int convertToResourceMenuId(Activity activity) {
        return DynamicResourceLoader.getStringResourceByName(
                DynamicResourceLoader.TYPE_MENU,
                activity.getPackageName(),
                activity.getResources(),
                convertToResourceName(activity));
    }
    
    static String[] convertToResourceName(Object object) {
        String pureClassname = getPureClassname(object);
        return asVariants(asLayoutNameCharacters(pureClassname));
    }

    private static String[] asVariants(String name) {
        String[] parts = name.split("_");
        List<String> fullnames = new ArrayList<String>(parts.length);
        for(String part : parts) {
            fullnames.add((fullnames.isEmpty() ? "" : fullnames.get(fullnames.size()-1) + "_") + part) ;
        }
        Collections.reverse(fullnames);
        return fullnames.toArray(new String[fullnames.size()]);
    }

    private static String getPureClassname(Object object) {
        String name = object.getClass().getName();
        return name.substring(name.lastIndexOf('.') +1);
    }

    private static String asLayoutNameCharacters(String name) {
        return asLayoutNameCharacters(name, new StringBuilder(name.length() *1/3)).toString();
    }

    private static StringBuilder asLayoutNameCharacters(String name,  StringBuilder res) {
        return asLayoutNameCharacters(name.toCharArray(), res);
    }

    private static StringBuilder asLayoutNameCharacters(char[] name, StringBuilder res) {
        res.append(Character.toLowerCase(name[0]));
        for(int i = 1; i < name.length; i++) {
           addAsLayoutNameCharacter(name[i], res, i);
        }
        return res;
    }

    private static StringBuilder addAsLayoutNameCharacter(char ch, StringBuilder res, int i) {
        if(Character.isUpperCase(ch) && i>0) {
            res.append("_");
            res.append(Character.toLowerCase(ch));
        } else {
            res.append(ch);
        }
        return res;
    }
}
