package com.llx278.asyncresult;

import android.content.Intent;

import androidx.annotation.Nullable;

public class Result {
    public final int code;
    public final Intent data;
    Result(int code, @Nullable Intent data) {
        this.code = code;
        this.data = data;
    }
}
