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
import android.widget.ImageView;

import com.example.cole.BLOC.FragmentExplore;
import com.example.cole.BLOC.R;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by Cole on 12/4/17.
 */

public class FragmentSliding extends Fragment implements View.OnClickListener {
    private ImageView back, two, three, four, five, six, seven, eight, nine;
    private Fragment currentFragment;
    private ImageView[][] grid;
    private Button scramble;
    private int nullRow, nullCol;
    private ArrayList<ImageView> images;
    public static final int MOVE_DIST = 315;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.sliding_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        wireWidgets(rootView);


        //get any other initial set up done
        setOnClickListeners();

        grid = new ImageView[3][3];
        images = new ArrayList<ImageView>();

        grid[0][0] = null;
        grid[0][1] = two;
        grid[0][2] = three;
        grid[1][0] = four;
        grid[1][1] = five;
        grid[1][2] = six;
        grid[2][0] = seven;
        grid[2][1] = eight;
        grid[2][2] = nine;

        scramblePuzzle();

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
                if(checkIfCanMoveBloc(two))
                {
                    two.setX(two.getX() + (nullCol - getCol(two))*MOVE_DIST);
                    two.setY(two.getY() + (nullRow - getRow(two))*MOVE_DIST);

                    grid[getRow(two)][getCol(two)] = null;
                    grid[nullRow][nullCol] = two;

                }
                break;
            case R.id.imageView3:
                if(checkIfCanMoveBloc(three))
                {
                    three.setX(three.getX() + (nullCol - getCol(three))*MOVE_DIST);
                    three.setY(three.getY() + (nullRow - getRow(three))*MOVE_DIST);

                    grid[getRow(three)][getCol(three)] = null;
                    grid[nullRow][nullCol] = three;
                }
                break;
            case R.id.imageView4:
                if(checkIfCanMoveBloc(four))
                {
                    four.setX(four.getX() + (nullCol - getCol(four))*MOVE_DIST);
                    four.setY(four.getY() + (nullRow - getRow(four))*MOVE_DIST);

                    grid[getRow(four)][getCol(four)] = null;
                    grid[nullRow][nullCol] = four;
                }
                break;
            case R.id.imageView5:
                if(checkIfCanMoveBloc(five))
                {
                    five.setX(five.getX() + (nullCol - getCol(five))*MOVE_DIST);
                    five.setY(five.getY() + (nullRow - getRow(five))*MOVE_DIST);

                    grid[getRow(five)][getCol(five)] = null;
                    grid[nullRow][nullCol] = five;
                }
                break;
            case R.id.imageView6:
                if(checkIfCanMoveBloc(six))
                {
                    six.setX(six.getX() + (nullCol - getCol(six))*MOVE_DIST);
                    six.setY(six.getY() + (nullRow - getRow(six))*MOVE_DIST);

                    grid[getRow(six)][getCol(six)] = null;
                    grid[nullRow][nullCol] = six;
                }
                break;
            case R.id.imageView7:
                if(checkIfCanMoveBloc(seven))
                {
                    seven.setX(seven.getX() + (nullCol - getCol(seven))*MOVE_DIST);
                    seven.setY(seven.getY() + (nullRow - getRow(seven))*MOVE_DIST);

                    grid[getRow(seven)][getCol(seven)] = null;
                    grid[nullRow][nullCol] = seven;
                }
                break;
            case R.id.imageView8:
                if(checkIfCanMoveBloc(eight))
                {
                    eight.setX(eight.getX() + (nullCol - getCol(eight))*MOVE_DIST);
                    eight.setY(eight.getY() + (nullRow - getRow(eight))*MOVE_DIST);

                    grid[getRow(eight)][getCol(eight)] = null;
                    grid[nullRow][nullCol] = eight;
                }
                break;
            case R.id.imageView9:
                if(checkIfCanMoveBloc(nine))
                {
                    nine.setX(nine.getX() + (nullCol - getCol(nine))*MOVE_DIST);
                    nine.setY(nine.getY() + (nullRow - getRow(nine))*MOVE_DIST);

                    grid[getRow(nine)][getCol(nine)] = null;
                    grid[nullRow][nullCol] = nine;
                }
                break;
            case R.id.button_scramble:
                scramblePuzzle();
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

    private int getRow(ImageView image)
    {
        for(int row=0; row<3; row++)
        {
            for(int col=0; col<3; col++) {
                if (grid[row][col] == image)
                {
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
                    return col;
                }
            }
        }
        return 0;
    }

    private boolean checkIfCanMoveBloc(ImageView image)
    {

        int row = getRow(image);
        int col = getCol(image);
        if(row + 1 < 3 && grid[row+1][col] == null)
        {
            nullRow = row+1;
            nullCol = col;
            return true;
        }
        else if(row -1 >= 0 && grid[row-1][col] == null)
        {
            nullRow = row-1;
            nullCol = col;
            return true;
        }
        else if(col+1 < 3 && grid[row][col+1] == null)
        {
            nullRow = row;
            nullCol = col+1;
            return true;
        }
        else if(col - 1 >= 0 && grid[row][col-1] == null)
        {
            nullRow = row;
            nullCol = col-1;
            return true;
        }

        return false;

    }


    private void scramblePuzzle()
    {
        images.add(null);
        images.add(two);
        images.add(three);
        images.add(four);
        images.add(five);
        images.add(six);
        images.add(seven);
        images.add(eight);
        images.add(nine);

        ImageView[][] tempGrid = new ImageView[3][3];
        for(int i = 0; i < 9 ; i++)
        {
            int num = (int) (Math.random()*images.size());
            ImageView image = images.get(num);
            Log.d(TAG, "random number: " + num);

            if(image != null){
                image.setX(image.getX() + ((i%3) - getCol(image))*MOVE_DIST);
                image.setY(image.getY() + ((i/3) - getRow(image))*MOVE_DIST);
                Log.d(TAG, "X, Y: " + ((i%3) - getCol(image)) + ", " + ((i/3) - getRow(image)));
            }

            tempGrid[i/3][i%3] = image;
            images.remove(num);
        }

        for(int i = 0; i < 9 ; i++){
            grid[i/3][i%3] = tempGrid[i/3][i%3];
        }
    }
}
