package de.jodamob.android.autolayout;

import android.os.Bundle;
import android.preference.PreferenceFragment;

public class AutoLayoutPreferenceFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(NameConverter.convertToResourceXmlId(this));
    }
}
