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

public class FragmentProducts extends Fragment {
    private Button button3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.products_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        button3 = (Button) rootView.findViewById(R.id.button3);

        //get any other initial set up done
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Products", Toast.LENGTH_SHORT).show();
            }
        });

        //return the view that we inflated
        return rootView;
    }
}
