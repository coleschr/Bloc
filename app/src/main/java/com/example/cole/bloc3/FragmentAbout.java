package com.example.cole.bloc3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Cole on 10/16/17.
 */

public class FragmentAbout extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //Inflate the layout we made (one_fragment.xml)
        View rootView = inflater.inflate(R.layout.about_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById


        //get any other initial set up done


        //return the view that we inflated
        return rootView;
    }
}
