package com.veibloc.cole.BLOC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.veibloc.cole.BLOC.Games.FragmentSliding;
import com.veibloc.cole.BLOC.Games.FragmentStacker;

/**
 * Created by Cole on 10/16/17.
 */

public class FragmentExplore extends Fragment implements View.OnClickListener{
    private Button stacker, sliding;
    private Fragment currentFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.explore_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        stacker = (Button) rootView.findViewById(R.id.button_stacker);
        sliding = (Button) rootView.findViewById(R.id.button_sliding);

        //get any other initial set up done
        setOnClickListeners();
        currentFragment = new FragmentExplore();

        //return the view that we inflated
        return rootView;
    }

    private void setOnClickListeners() {
        stacker.setOnClickListener(this);
        sliding.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_stacker:
                currentFragment = new FragmentStacker();
                switchToNewScreen();
                break;
            case R.id.button_sliding:
                currentFragment = new FragmentSliding();
                switchToNewScreen();
                break;
        }

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
}
