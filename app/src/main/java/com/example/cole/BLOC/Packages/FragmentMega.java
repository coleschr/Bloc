package com.example.cole.BLOC.Packages;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cole.BLOC.FragmentProducts;
import com.example.cole.BLOC.R;

/**
 * Created by Cole on 11/3/17.
 */

public class FragmentMega extends Fragment implements View.OnClickListener {
    private ImageView megaImage, white, grey, fun, right, left, back;
    private Button purchase;
    private int[] image;
    private int currentImage;
    private int color;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.package_mega_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        wireWidgets(rootView);

        //get any other initial set up done
        currentImage = 0;
        color = 0;
        initializeImages();
        setListeners();

        //return the view that we inflated
        return rootView;
    }

    private void initializeImages() {
        image = new int[5];
        image[0] = R.drawable.mega1;
        image[1] = R.drawable.mega2;
        image[2] = R.drawable.mega3;
        image[3] = R.drawable.mega4;
        image[4] = R.drawable.mega5;
    }

    private void setListeners() {
        grey.setOnClickListener(this);
        white.setOnClickListener(this);
        fun.setOnClickListener(this);
        purchase.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private void wireWidgets(View rootView) {
        megaImage = (ImageView) rootView.findViewById(R.id.imageView_mega);
        grey = (ImageView) rootView.findViewById(R.id.imageView_mega_grey);
        white = (ImageView) rootView.findViewById(R.id.imageView_mega_white);
        fun = (ImageView) rootView.findViewById(R.id.imageView_mega_fun);
        purchase = (Button) rootView.findViewById(R.id.button_mega);
        left = (ImageView) rootView.findViewById(R.id.imageView_mega_left);
        right = (ImageView) rootView.findViewById(R.id.imageView_mega_right);
        back = (ImageView) rootView.findViewById(R.id.imageView_mega_back);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView_mega_grey:
                grey.setBackgroundColor(Color.rgb(245, 124, 0));
                white.setBackgroundColor(Color.argb(0, 0, 0, 0));
                fun.setBackgroundColor(Color.argb(0, 0, 0, 0));
                color = 1;
                break;
            case R.id.imageView_mega_white:
                white.setBackgroundColor(Color.rgb(245, 124, 0));
                grey.setBackgroundColor(Color.argb(0, 0, 0, 0));
                fun.setBackgroundColor(Color.argb(0, 0, 0, 0));
                color = 0;
                break;
            case R.id.imageView_mega_fun:
                fun.setBackgroundColor(Color.rgb(245, 124, 0));
                grey.setBackgroundColor(Color.argb(0, 0, 0, 0));
                white.setBackgroundColor(Color.argb(0, 0, 0, 0));
                color = 2;
                break;
            case R.id.imageView_mega_left:
                if(currentImage != 0) {
                    megaImage.setImageResource(image[currentImage-1]);
                    currentImage--;
                }
                else {
                    megaImage.setImageResource(image[image.length-1]);
                    currentImage = image.length-1;
                }
                break;
            case R.id.imageView_mega_right:
                if(currentImage != image.length-1) {
                    megaImage.setImageResource(image[currentImage+1]);
                    currentImage++;
                }
                else {
                    megaImage.setImageResource(image[0]);
                    currentImage = 0;
                }
                break;
            case R.id.button_mega:
                if(color == 0){
                    openWebPage("https://portal.veinternational.org/buybuttons/us021804/btn/mega-package-sleek-42/");
                }
                else if (color == 1){
                    openWebPage("https://portal.veinternational.org/buybuttons/us021804/btn/mega-package-slate-43/");
                }
                else {
                    openWebPage("https://portal.veinternational.org/buybuttons/us021804/btn/mega-package-vivid-41/");
                }
                break;
            case R.id.imageView_mega_back:
                Fragment currentFragment = new FragmentProducts();
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

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}