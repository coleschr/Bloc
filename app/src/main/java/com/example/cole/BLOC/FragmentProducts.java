package com.example.cole.BLOC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cole.BLOC.Packages.FragmentLarge;
import com.example.cole.BLOC.Packages.FragmentMedium;
import com.example.cole.BLOC.Packages.FragmentMega;
import com.example.cole.BLOC.Packages.FragmentSmall;

/**
 * Created by Cole on 10/16/17.
 */

public class FragmentProducts extends Fragment implements View.OnClickListener {
    private Fragment currentFragment;
    private TextView small, medium, large, mega;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.products_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        wireWidgets(rootView);

        //get any other initial set up done
        setOnClickListeners();
        currentFragment = new FragmentProducts();

        //return the view that we inflated
        return rootView;
    }

    private void wireWidgets(View rootView) {
        small = (TextView) rootView.findViewById(R.id.textView_small_package);
        medium = (TextView) rootView.findViewById(R.id.textView_medium_package);
        large = (TextView) rootView.findViewById(R.id.textView_large_package);
        mega = (TextView) rootView.findViewById(R.id.textView_mega_package);
    }

    private void setOnClickListeners() {
        small.setOnClickListener(this);
        medium.setOnClickListener(this);
        large.setOnClickListener(this);
        mega.setOnClickListener(this);
    }

    private void switchToNewScreen() {
        //tell the fragment manager that if our current fragment isn't null, to replace whatever is there with it
        FragmentManager fm = getFragmentManager();
        if (currentFragment != null) {
            fm.beginTransaction()
                    .replace(R.id.fragment_container, currentFragment)
                    .commit();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textView_small_package:
                currentFragment = new FragmentSmall();
                switchToNewScreen();
                break;
            case R.id.textView_medium_package:
                currentFragment = new FragmentMedium();
                switchToNewScreen();
                break;
            case R.id.textView_large_package:
                currentFragment = new FragmentLarge();
                switchToNewScreen();
                break;
            case R.id.textView_mega_package:
                currentFragment = new FragmentMega();
                switchToNewScreen();
                break;
        }
    }
}
