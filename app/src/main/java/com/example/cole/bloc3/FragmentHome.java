package com.example.cole.bloc3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Cole on 10/16/17.
 */

public class FragmentHome extends Fragment {
    private TextView missionStatement;
    private String ms;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);

        missionStatement= (TextView) rootView.findViewById(R.id.text_ms);
        //wire any widgets -- must use rootView.findViewById

        ms= getString(R.string.mission_statement);

        missionStatement.setText(ms);
        //get any other initial set up done


        //return the view that we inflated
        return rootView;
    }
}

