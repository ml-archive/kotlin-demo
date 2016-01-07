package com.fuzz.android.kotlin.fuzztest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by cesaraguilar on 1/5/16.
 */

public class SimpleFragment extends Fragment {

    @Bind(R.id.secondtext) TextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity)getActivity()).fakePublicFunction();
        View view = inflater.inflate(R.layout.fragment_simple, null);
        TextGenerator generator = new TextGenerator();
        SecondGenerator second = new SecondGenerator();
        //TODO the following fails because this convention is a Kotlin only capability
//        generator.generateText().duplicateString();
        ButterKnife.bind(this,getActivity());
        text.setText(generator.generateText() + " " + second.generateText());

        return view;
    }
}
