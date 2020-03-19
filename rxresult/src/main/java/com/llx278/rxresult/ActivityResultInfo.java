package com.llx278.rxresult;

import android.content.Intent;


public class ActivityResultInfo {
    final int resultCode;
    final Intent data;

    ActivityResultInfo(int resultCode, Intent data) {
        this.resultCode = resultCode;
        this.data = data;
    }
}
