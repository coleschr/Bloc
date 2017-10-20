package com.example.cole.bloc3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Cole on 10/16/17.
 */

public class FragmentContact extends Fragment {
    private Button button4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.contact_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        button4 = (Button) rootView.findViewById(R.id.button4);

        //get any other initial set up done
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Contact", Toast.LENGTH_SHORT).show();
            }
        });

        //return the view that we inflated
        return rootView;
    }
}