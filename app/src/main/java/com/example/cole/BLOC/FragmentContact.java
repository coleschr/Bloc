package com.example.cole.BLOC;

import android.content.Intent;
import android.net.Uri;
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

public class FragmentContact extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.contact_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        TextView website = (TextView) rootView.findViewById(R.id.textView_website);
        TextView instagram = (TextView) rootView.findViewById(R.id.textView_instagram);
        TextView twitter = (TextView) rootView.findViewById(R.id.textView_twitter);
        TextView facebook = (TextView) rootView.findViewById(R.id.textView_facebook);
        TextView location = (TextView) rootView.findViewById(R.id.textView_location);
        TextView email = (TextView) rootView.findViewById(R.id.textView_email);
        TextView phone = (TextView) rootView.findViewById(R.id.textView_phone_num);

        //get any other initial set up done
        website.setOnClickListener(this);
        instagram.setOnClickListener(this);
        twitter.setOnClickListener(this);
        facebook.setOnClickListener(this);
        location.setOnClickListener(this);
        email.setOnClickListener(this);
        phone.setOnClickListener(this);

        //return the view that we inflated
        return rootView;
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openMap(String geoLocation) {
        Uri location = Uri.parse(geoLocation);
        Intent intent = new Intent(Intent.ACTION_VIEW, location);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        }
    }

    public void composeEmail(String address, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:bloc.ca@veinternational.org")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, address);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            //intent.setPackage("com.google.android.apps.email");
            //startActivity(intent);
            startActivity(intent);
        }
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.textView_website:
                openWebPage("http://vei-bloc.com");
                break;
            case R.id.textView_email:
                composeEmail("bloc.ca@veinternational.org", "Concerned Customer");
                break;
            case R.id.textView_location:
                openMap("geo:0,0?q=1401 Fremont Avenue, South+Pasadena, California");
                break;
            case R.id.textView_twitter:
                openWebPage("https://twitter.com/vei_BLOC?lang=en");
                break;
            case R.id.textView_instagram:
                openWebPage("http://www.instagram.com/vei.bloc/?hl=en");
                break;
            case R.id.textView_facebook:
                openWebPage("https://www.facebook.com/vei.bloc");
                break;
            case R.id.textView_phone_num:
                dialPhoneNumber("(626)441-5820");
                break;

        }


    }
}


