package de.jodamob.android.autolayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class AutoLayoutActivity extends Activity {

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);       
        setContentView(NameConverter.convertToResourceLayoutId(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int id = NameConverter.convertToResourceMenuId(this);
        if (id > 0) {
            getMenuInflater().inflate(id, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }
}
