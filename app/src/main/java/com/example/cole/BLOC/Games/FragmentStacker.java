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
    private ImageView back, block0, block1, block2, block3, block4, block5;
    private Fragment currentFragment;
    private Button place;
    private int[] size;
    private int[][] grid;
    private int currentRow, currentColumn, score;
    private boolean forward;
    private TextView scoreText;
    private CountDownTimer moveTimer;

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
        size = new int[6];
        setUpSizes();
        grid = new int[5][6];
        forward = false;
        score = 0;
        scoreText.setText("Score: " + score);
        startGame(1000);

        //return the view that we inflated
        return rootView;
    }

    private void setUpSizes() {
        size[0] = 2;
        size[1] = 2;
        size[2] = 2;
        size[3] = 1;
        size[4] = 1;
        size[5] = 1;
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
        block0 = (ImageView) rootView.findViewById(R.id.imageView_bb);
        block1 = (ImageView) rootView.findViewById(R.id.imageView_bg);
        block2 = (ImageView) rootView.findViewById(R.id.imageView_bo);
        block3 = (ImageView) rootView.findViewById(R.id.imageView_sb);
        block4 = (ImageView) rootView.findViewById(R.id.imageView_sg);
        block5 = (ImageView) rootView.findViewById(R.id.imageView_so);
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
                if(currentRow < 6){
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
        switch (currentRow){
            case 0:
                if(currentColumn == 0 || currentColumn == 3){
                    forward = !forward;
                    moveOneSpace(block0);
                }
                else{
                    moveOneSpace(block0);
                }
                break;
            case 1:
                if(currentColumn == 0 || currentColumn == 3){
                    forward = !forward;
                    moveOneSpace(block1);
                }
                else{
                    moveOneSpace(block1);
                }
                break;
            case 2:
                if(currentColumn == 0 || currentColumn == 3){
                    forward = !forward;
                    moveOneSpace(block2);
                }
                else{
                    moveOneSpace(block2);
                }
                break;
            case 3:
                if(currentColumn == 0 || currentColumn == 4){
                    forward = !forward;
                    moveOneSpace(block3);
                }
                else{
                    moveOneSpace(block3);
                }
                break;
            case 4:
                if(currentColumn == 0 || currentColumn == 4){
                    forward = !forward;
                    moveOneSpace(block4);
                }
                else{
                    moveOneSpace(block4);
                }
                break;
            case 5:
                if(currentColumn == 0 || currentColumn == 4){
                    forward = !forward;
                    moveOneSpace(block5);
                }
                else{
                    moveOneSpace(block5);
                }
                break;
            default:
                resetGame();
                break;
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
        switch(currentRow){
            case 0:
                moveToNextRow();
                block1.setVisibility(View.VISIBLE);
                startGame(900);
                break;
            case 1:
                gameOver = checkIfGameOver();
                if(!gameOver){
                    moveToNextRow();
                    block2.setVisibility(View.VISIBLE);
                }
                else{
                    score = 0;
                    resetGame();
                }
                startGame(800);
                break;
            case 2:
                gameOver = checkIfGameOver();
                if(!gameOver){

                    moveToNextRow();
                    block3.setVisibility(View.VISIBLE);
                }
                else{
                    score = 0;
                    resetGame();
                }
                startGame(700);
                break;
            case 3:
                gameOver = checkIfGameOver();
                if(!gameOver){
                    moveToNextRow();
                    block4.setVisibility(View.VISIBLE);
                }
                else{
                    score = 0;
                    resetGame();
                }
                startGame(700);
                break;
            case 4:
                gameOver = checkIfGameOver();
                if(!gameOver){
                    moveToNextRow();
                    block5.setVisibility(View.VISIBLE);
                }
                else{
                    score = 0;
                    resetGame();
                }
                startGame(700);
                break;
            case 5:
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
                startGame(1000);
                break;
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
        block0.setVisibility(View.VISIBLE);
        block1.setVisibility(View.INVISIBLE);
        block2.setVisibility(View.INVISIBLE);
        block3.setVisibility(View.INVISIBLE);
        block4.setVisibility(View.INVISIBLE);
        block5.setVisibility(View.INVISIBLE);

        int[] numBack = new int[6];
        for(int i=4;i>=0;i--){
            for(int j=0;j<6;j++){
                if(grid[i][j] == 1){
                    numBack[j] = i;
                }
                grid[i][j] = 0;
            }
        }
        block0.setX(block0.getX() - 160 * numBack[0]);
        block1.setX(block1.getX() - 160 * numBack[1]);
        block2.setX(block2.getX() - 160 * numBack[2]);
        block3.setX(block3.getX() - 160 * numBack[3]);
        block4.setX(block4.getX() - 160 * numBack[4]);
        block5.setX(block5.getX() - 160 * numBack[5]);
        currentRow = 0;
        currentColumn = 0;
        forward = false;
        moveTimer.start();
    }
}
