package com.padcmyanmar.padc9.padc9_adapterbasedviews_std.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.R;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.models.EventModel;
import com.padcmyanmar.padc9.padc9_adapterbasedviews_std.data.models.EventModelImpl;

public abstract class BaseActivity extends AppCompatActivity {

    protected EventModel eventModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        eventModel = EventModelImpl.getObjInstance();
    }

    protected void showSnackbar(String message){
        final Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), message, Snackbar.LENGTH_LONG);
        snackbar.setAction(getString(R.string.snackbar_msg), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
            }
        });
    }

}
