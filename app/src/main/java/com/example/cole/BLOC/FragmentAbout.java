package com.example.cole.BLOC;

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

public class FragmentAbout extends Fragment {
    private TextView companyDesc, companyDescTitle, csrTitle, csr;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        //Inflate the layout we made (one_fragment.xml)
        View rootView = inflater.inflate(R.layout.about_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        companyDesc= (TextView) rootView.findViewById(R.id.textView_company_desc);
        csrTitle= (TextView) rootView.findViewById(R.id.textView_title_csr);
        companyDescTitle= (TextView) rootView.findViewById(R.id.textView_title_company_desc);
        csr= (TextView) rootView.findViewById(R.id.textView_csr);

        //get any other initial set up done
        companyDesc.setText(R.string.desc_company);
        companyDescTitle.setText(com.example.cole.BLOC.R.string.title_company_desc);
        csrTitle.setText(R.string.csr_title);
        csr.setText(R.string.csr);

        //return the view that we inflated
        return rootView;
    }
}
