package com.llx278.asyncresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Random;

public class TransparentFragment extends Fragment {

    private Callback callback;
    private Intent intent;
    private int requestCode = randomCode();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (callback == null || intent == null) {
            removeMyself();
            return;
        }
        startActivityForResult(intent,requestCode);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == this.requestCode) {
            callback.onActivityResult(new Result(requestCode,data));
        } else {
            callback.onActivityResult(new Result(Activity.RESULT_CANCELED,null));
        }
        removeMyself();
    }

    private void removeMyself() {
        FragmentManager m  = getFragmentManager();
        if (m != null) {
            m.beginTransaction().remove(this).commitAllowingStateLoss();
        }
    }

    void injectIntentAndCallback(@NonNull Intent intent, @NonNull Callback callback) {
        this.callback = callback;
        this.intent = intent;
    }

    private int randomCode() {
        return new Random().nextInt(65536);
    }
}
