package com.example.cole.BLOC.Packages;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.cole.BLOC.R;

/**
 * Created by Cole on 11/3/17.
 */

public class FragmentSmall extends Fragment implements View.OnClickListener {
    private ImageView smallImage, white, grey, fun, right, left;
    private Button purchase;
    private int[] image;
    private int currentImage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.package_small_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        wireWidgets(rootView);

        //get any other initial set up done
        currentImage = 0;
        initializeImages();
        setListeners();

        //return the view that we inflated
        return rootView;
    }

    private void initializeImages() {
        image = new int[2];
        image[0] = R.drawable.small1;
        image[1] = R.drawable.small2;
    }

    private void setListeners() {
        grey.setOnClickListener(this);
        white.setOnClickListener(this);
        fun.setOnClickListener(this);
        purchase.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
    }

    private void wireWidgets(View rootView) {
        smallImage = (ImageView) rootView.findViewById(R.id.imageView_small);
        grey = (ImageView) rootView.findViewById(R.id.imageView_grey);
        white = (ImageView) rootView.findViewById(R.id.imageView_white);
        fun = (ImageView) rootView.findViewById(R.id.imageView_fun);
        purchase = (Button) rootView.findViewById(R.id.button_small);
        left = (ImageView) rootView.findViewById(R.id.imageView_left);
        right = (ImageView) rootView.findViewById(R.id.imageView_right);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageView_grey:
                grey.setBackgroundColor(Color.rgb(245, 124, 0));
                white.setBackgroundColor(Color.argb(0, 0, 0, 0));
                fun.setBackgroundColor(Color.argb(0, 0, 0, 0));
                break;
            case R.id.imageView_white:
                white.setBackgroundColor(Color.rgb(245, 124, 0));
                grey.setBackgroundColor(Color.argb(0, 0, 0, 0));
                fun.setBackgroundColor(Color.argb(0, 0, 0, 0));
                break;
            case R.id.imageView_fun:
                fun.setBackgroundColor(Color.rgb(245, 124, 0));
                grey.setBackgroundColor(Color.argb(0, 0, 0, 0));
                white.setBackgroundColor(Color.argb(0, 0, 0, 0));
                break;
            case R.id.imageView_left:
                if(currentImage != 0) {
                    smallImage.setImageResource(image[currentImage-1]);
                    currentImage--;
                }
                else {
                    smallImage.setImageResource(image[image.length-1]);
                    currentImage = image.length-1;
                }
                break;
            case R.id.imageView_right:
                if(currentImage != image.length-1) {
                    smallImage.setImageResource(image[currentImage+1]);
                    currentImage++;
                }
                else {
                    smallImage.setImageResource(image[0]);
                    currentImage = 0;
                }
                break;
        }
    }
}
