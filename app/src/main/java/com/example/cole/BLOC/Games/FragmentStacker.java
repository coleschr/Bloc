package com.example.cole.BLOC.Games;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cole.BLOC.FragmentExplore;
import com.example.cole.BLOC.R;

/**
 * Created by Cole on 12/4/17.
 */

public class FragmentStacker extends Fragment implements View.OnClickListener{
    private ImageView back;
    private Fragment currentFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.stacker_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        wireWidgets(rootView);

        //get any other initial set up done
        setOnClickListeners();

        //return the view that we inflated
        return rootView;
    }

    private void wireWidgets(View rootView) {
        back = (ImageView) rootView.findViewById(R.id.imageView_stacker_back);
    }

    private void setOnClickListeners() {
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageView_stacker_back:
                currentFragment = new FragmentExplore();
                switchToNewScreen(currentFragment);
                break;
        }
    }

    private void switchToNewScreen(Fragment currentFragment) {
        //tell the fragment manager that if our current fragment isn't null, to replace whatever is there with it
        FragmentManager fm = getFragmentManager();
        if (currentFragment != null) {
            fm.beginTransaction()
                    .replace(R.id.fragment_container, currentFragment)
                    .commit();
        }
    }
}
