package com.llx278.asyncresult;

import android.content.Intent;

import androidx.annotation.Nullable;

public class Result {
    public final int resultCode;
    public final Intent data;
    Result(int resultCode, @Nullable Intent data) {
        this.resultCode = resultCode;
        this.data = data;
    }
}
