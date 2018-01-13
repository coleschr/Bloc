package com.veibloc.cole.BLOC;

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
    private TextView missionStatement, veStatement;
    private String ms;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        missionStatement = (TextView) rootView.findViewById(R.id.text_ms);
        ms = getString(R.string.mission_statement);

        //get any other initial set up done
        missionStatement.setText(ms);

        veStatement = (TextView) rootView.findViewById(R.id.text_ve);
        veStatement.setText(getString(R.string.ve_statement));

        //return the view that we inflated
        return rootView;
    }
}

