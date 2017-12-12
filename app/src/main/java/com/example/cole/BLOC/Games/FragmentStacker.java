package com.example.cole.BLOC.Games;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cole.BLOC.FragmentExplore;
import com.example.cole.BLOC.R;

/**
 * Created by Cole on 12/4/17.
 */

public class FragmentStacker extends Fragment implements View.OnClickListener{
    private ImageView back;
    private ImageView block[];
    private Fragment currentFragment;
    private Button place;
    private int[] size;
    private int[][] grid;
    private int currentRow, currentColumn, score;
    private boolean forward;
    private TextView scoreText;
    private CountDownTimer moveTimer;
    private int timerTime;
    public static final int ROWS = 9;
    public static final int COLUMNS = 7;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.stacker_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        wireWidgets(rootView);

        //get any other initial set up done
        setOnClickListeners();
        currentRow = 0;
        currentColumn = 0;
        size = new int[ROWS];
        setUpSizes();
        grid = new int[COLUMNS][ROWS];
        forward = false;
        score = 0;
        scoreText.setText("Score: " + score);
        timerTime = 800;
        startGame(timerTime);

        //return the view that we inflated
        return rootView;
    }

    private void setUpSizes() {
        size[0] = 2;
        size[1] = 2;
        size[2] = 2;
        size[3] = 2;
        size[4] = 2;
        size[5] = 2;
        size[6] = 2;
        size[7] = 2;
        size[8] = 2;
    }

    private void startGame(int time) {
        moveTimer = new CountDownTimer(3000, time) {
            @Override
            public void onTick(long l) {
                moveBlock();
            }

            @Override
            public void onFinish() {
                moveTimer.start();
            }
        };
        moveTimer.start();
    }

    private void wireWidgets(View rootView) {
        back = (ImageView) rootView.findViewById(R.id.imageView_stacker_back);
        place = (Button) rootView.findViewById(R.id.button_place);
        block = new ImageView[ROWS];
        block[0] = (ImageView) rootView.findViewById(R.id.imageView_block0);
        block[1] = (ImageView) rootView.findViewById(R.id.imageView_block1);
        block[2] = (ImageView) rootView.findViewById(R.id.imageView_block2);
        block[3] = (ImageView) rootView.findViewById(R.id.imageView_block3);
        block[4] = (ImageView) rootView.findViewById(R.id.imageView_block4);
        block[5] = (ImageView) rootView.findViewById(R.id.imageView_block5);
        block[6] = (ImageView) rootView.findViewById(R.id.imageView_block6);
        block[7] = (ImageView) rootView.findViewById(R.id.imageView_block7);
        block[8] = (ImageView) rootView.findViewById(R.id.imageView_block8);
        scoreText = (TextView) rootView.findViewById(R.id.textView_stacker_score);
    }

    private void setOnClickListeners() {
        back.setOnClickListener(this);
        place.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.imageView_stacker_back:
                currentFragment = new FragmentExplore();
                switchToNewScreen(currentFragment);
                break;
            case R.id.button_place:
                if(currentRow < ROWS){
                    placeBlock();
                }
                else{
                    resetGame();
                }
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

    private void moveBlock(){
        if(currentColumn == 0 || currentColumn == COLUMNS-size[currentRow]){
            forward = !forward;
            moveOneSpace(block[currentRow]);
        }
        else{
            moveOneSpace(block[currentRow]);
        }
    }

    private void moveOneSpace(ImageView block) {
        if(forward){
            block.setX(block.getX() + 160);
            currentColumn++;
        }
        else{
            block.setX(block.getX() - 160);
            currentColumn--;
        }
    }

    private void placeBlock(){
        updateGrid();
        boolean gameOver;
        if(currentRow == 0){
            moveToNextRow();
            block[currentRow].setVisibility(View.VISIBLE);
            timerTime--;
            startGame(timerTime);
        }
        else if(currentRow >= ROWS-1){
            gameOver = checkIfGameOver();
            if(gameOver){
                score = 0;
                resetGame();
            }
            else{
                moveTimer.cancel();
                Toast.makeText(getActivity(), "You Win!", Toast.LENGTH_SHORT).show();
                currentRow++;
                score++;
            }
            moveTimer.cancel();
            timerTime = 800;
        }
        else {
            gameOver = checkIfGameOver();
            if(!gameOver){
                moveToNextRow();
                block[currentRow].setVisibility(View.VISIBLE);
            }
            else{
                score = 0;
                resetGame();
            }
            timerTime--;
            startGame(timerTime);
        }
        scoreText.setText("Score: " + score);
    }

    private void moveToNextRow() {
        currentRow++;
        currentColumn = 0;
        forward = false;
        score++;
    }

    private void updateGrid() {
        grid[currentColumn][currentRow] = 1;
        if(size[currentRow] == 2){
            grid[currentColumn+1][currentRow] = 1;
        }
    }

    private boolean checkIfGameOver() {
        if((size[currentRow] == 2
                && (grid[currentColumn][currentRow-1] == 0 && grid[currentColumn+1][currentRow-1] == 0))
                || (size[currentRow] == 1
                && grid[currentColumn][currentRow-1] == 0)){
            Toast.makeText(getActivity(), "Game Over", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    private void resetGame() {
        moveTimer.cancel();
        block[0].setVisibility(View.VISIBLE);
        for(int i = 1; i<ROWS;i++){
            block[i].setVisibility(View.INVISIBLE);
        }

        int[] numBack = new int[ROWS];
        for(int i=COLUMNS-1;i>=0;i--){
            for(int j=0;j<ROWS;j++){
                if(grid[i][j] == 1){
                    numBack[j] = i;
                }
                grid[i][j] = 0;
            }
        }

        for(int i = 0; i<ROWS;i++){
            block[i].setX(block[i].getX() - 160 * numBack[i]);
        }

        currentRow = 0;
        currentColumn = 0;
        forward = false;
        timerTime = 800;
        startGame(timerTime);
    }
}
