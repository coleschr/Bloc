package com.example.cole.BLOC.Games;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.example.cole.BLOC.FragmentExplore;
import com.example.cole.BLOC.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Cole on 12/4/17.
 */

public class FragmentSliding extends Fragment implements View.OnClickListener {
    private ImageView back, two, three, four, five, six, seven, eight, nine;
    private Fragment currentFragment;
    private ImageView[][] grid;
    private Button scramble;
    private int nullX, nullY;
    private GridLayout gridLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.sliding_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        wireWidgets(rootView);


        //get any other initial set up done
        setOnClickListeners();

        grid= new ImageView[3][3];
        grid[0][0]= null;
        grid[0][1]= two;
        grid[0][2]= three;
        grid[1][0]= four;
        grid[1][1]= five;
        grid[1][2]= six;
        grid[2][0]= seven;
        grid[2][1]= eight;
        grid[2][2]= nine;

        updateGridView();

        //return the view that we inflated
        return rootView;
    }

    private void wireWidgets(View rootView) {
        back = (ImageView) rootView.findViewById(R.id.imageView_sliding_back);
        two = (ImageView) rootView.findViewById(R.id.imageView2);
        three = (ImageView) rootView.findViewById(R.id.imageView3);
        four = (ImageView) rootView.findViewById(R.id.imageView4);
        five = (ImageView) rootView.findViewById(R.id.imageView5);
        six = (ImageView) rootView.findViewById(R.id.imageView6);
        seven = (ImageView) rootView.findViewById(R.id.imageView7);
        eight = (ImageView) rootView.findViewById(R.id.imageView8);
        nine = (ImageView) rootView.findViewById(R.id.imageView9);
        scramble = (Button) rootView.findViewById(R.id.button_scramble);
        gridLayout = (GridLayout) rootView.findViewById(R.id.gridLayout_grid);
    }

    private void setOnClickListeners() {

        back.setOnClickListener(this);
        scramble.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageView_sliding_back:
                currentFragment = new FragmentExplore();
                switchToNewScreen(currentFragment);
                break;
            case R.id.imageView2:
                Log.d(TAG, "onClick: clicking actually works");
                if(moveBloc(two))
                {
                    ((ViewGroup)gridLayout.getParent()).removeView(two);
                    gridLayout.removeViewAt(getLocation(getRow(two), getCol(two)));
                    gridLayout.addView(two, getLocation(nullX, nullY));
                    Log.d(TAG, "onClick: in the if statement" + getLocation(nullX, nullY));
                }
                break;
            case R.id.imageView3:
                if(moveBloc(three))
                {
                    gridLayout.removeViewAt(getLocation(getRow(three), getCol(three)));
                    gridLayout.addView(three, getLocation(nullX, nullY));
                }
                break;
            case R.id.imageView4:
                if(moveBloc(four))
                {
                    gridLayout.removeViewAt(getLocation(getRow(four), getCol(four)));
                    gridLayout.addView(four, getLocation(nullX, nullY));
                }
                break;
            case R.id.imageView5:
                if(moveBloc(five))
                {
                    gridLayout.removeViewAt(getLocation(getRow(five), getCol(five)));
                    gridLayout.addView(five, getLocation(nullX, nullY));
                }
                break;
            case R.id.imageView6:
                if(moveBloc(six))
                {
                    gridLayout.removeViewAt(getLocation(getRow(six), getCol(six)));
                    gridLayout.addView(six, getLocation(nullX, nullY));
                }
                break;
            case R.id.imageView7:
                if(moveBloc(seven))
                {
                    gridLayout.removeViewAt(getLocation(getRow(seven), getCol(seven)));
                    gridLayout.addView(seven, getLocation(nullX, nullY));
                }
                break;
            case R.id.imageView8:
                if(moveBloc(eight))
                {
                    gridLayout.removeViewAt(getLocation(getRow(eight), getCol(eight)));
                    gridLayout.addView(eight, getLocation(nullX, nullY));
                }
                break;
            case R.id.imageView9:
                if(moveBloc(nine))
                {
                    gridLayout.removeViewAt(getLocation(getRow(nine), getCol(nine)));
                    gridLayout.addView(nine, getLocation(nullX, nullY));
                }
                break;

        }
    }

    private int getLocation(int row, int col)
    {
       return col + 3 * row;
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

    private int getRow(ImageView image)
    {
        for(int row=0; row<3; row++)
        {
            for(int col=0; col<3; col++) {
                if (grid[row][col] == image)
                {
                    Log.d(TAG, "getRow: " + row);
                    return row;
                }
            }
        }
        return 0;
    }

    private int getCol(ImageView image)
    {
        for(int row=0; row<3; row++)
        {
            for(int col=0; col<3; col++) {
                if (grid[row][col] == image)
                {
                    Log.d(TAG, "getCol: " + col);
                    return col;
                }
            }
        }
        return 0;
    }

    private boolean moveBloc(ImageView image)
    {

        int row = getRow(image);
        int col = getCol(image);
        if(row + 1 < 3 && grid[row+1][col]== null)
        {
            nullX= row+1;
            nullY= col;
            Log.d(TAG, "null position: " + nullX + ", " + nullY);
            return true;
        }
        else if(row -1 >= 0 && grid[row-1][col]== null)
        {
            nullX= row-1;
            nullY= col;
            Log.d(TAG, "null position: " + nullX + ", " + nullY);
            return true;
        }
        else if(col+1 < 3 && grid[row][col+1]== null)
        {
            nullX= row;
            nullY= col+1;
            Log.d(TAG, "null position: " + nullX + ", " + nullY);
            return true;
        }
        else if(col - 1 >= 0 && grid[row][col-1]== null)
        {
            nullX= row;
            nullY= col-1;
            Log.d(TAG, "null position: " + nullX + ", " + nullY);
            return true;
        }

        return false;

    }

    private void updateGridView() {
        int i=-1;
        gridLayout.removeAllViews();
        gridLayout.setColumnCount(3);
        gridLayout.setRowCount(3);
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                if(grid[row][col] != null)
                {

                    gridLayout.addView(grid[row][col], i);

                }
                i++;
            }
        }
    }



}
