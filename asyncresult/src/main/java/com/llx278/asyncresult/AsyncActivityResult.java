package com.llx278.asyncresult;


import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class AsyncActivityResult {

    private static final String TAG = "llx278AsyncResult";

    public void startActivityForResult(@NonNull FragmentActivity activity, @NonNull Intent intent, @NonNull Callback callback) {

        FragmentManager manager = activity.getSupportFragmentManager();
        Fragment tagF = manager.findFragmentByTag(TAG);
        if (tagF != null) {
            callback.onActivityResult(new Result(Activity.RESULT_CANCELED,null));
            return;
        }

        TransparentFragment f = new TransparentFragment();
        f.injectIntentAndCallback(intent,callback);
        manager.beginTransaction().add(f,TAG).commitAllowingStateLoss();
    }
}
