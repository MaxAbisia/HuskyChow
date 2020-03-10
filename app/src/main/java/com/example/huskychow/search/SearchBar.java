package com.example.huskychow.search;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.huskychow.R;

public class SearchBar extends FrameLayout {

    public SearchBar(@NonNull Context context) {
        super(context);
    }

    public SearchBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SearchBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SearchBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
