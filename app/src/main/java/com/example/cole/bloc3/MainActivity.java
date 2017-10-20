package com.example.cole.bloc3;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.example.cole.bloc3.R.id.about;
import static com.example.cole.bloc3.R.id.contact;
import static com.example.cole.bloc3.R.id.explore;
import static com.example.cole.bloc3.R.id.products;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton[] icon;
    private int screen;
    private Fragment currentFragment;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wireWidgets();
        setOnClickListeners();
        setUpHomeScreen();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            layout.setBackgroundColor(getColor(R.color.colorBackground));
        } else { //ECEFF1
            layout.setBackgroundColor(Color.rgb(236, 239, 241));
        }

    }

    private void setUpHomeScreen() {
        screen = 0;
        currentFragment = new FragmentHome();
        switchToNewScreen();
    }

    private void wireWidgets() {
        icon = new ImageButton[5];
        icon[0] = (ImageButton) findViewById(R.id.home);
        icon[1] = (ImageButton) findViewById(about);
        icon[2] = (ImageButton) findViewById(products);
        icon[3] = (ImageButton) findViewById(contact);
        icon[4] = (ImageButton) findViewById(explore);

        layout = (ConstraintLayout) findViewById(R.id.layout_main_background);
    }

    private void setOnClickListeners() {
        icon[0].setOnClickListener(this);
        icon[1].setOnClickListener(this);
        icon[2].setOnClickListener(this);
        icon[3].setOnClickListener(this);
        icon[4].setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.home:
                currentFragment = new FragmentHome();
                switchToNewScreen();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    icon[screen].setColorFilter(getColor(R.color.colorNotClicked));
                    screen = 0;
                    icon[screen].setColorFilter(getColor(R.color.colorAccent));
                } else { //F57C00
                    icon[screen].setColorFilter(Color.rgb(96, 125, 139));
                    screen = 0;
                    icon[screen].setColorFilter(Color.rgb(245, 124, 0));
                }
                Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
                break;
            case about:
                currentFragment = new FragmentAbout();
                switchToNewScreen();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    icon[screen].setColorFilter(getColor(R.color.colorNotClicked));
                    screen = 1;
                    icon[screen].setColorFilter(getColor(R.color.colorAccent));
                } else {
                    icon[screen].setColorFilter(Color.rgb(96, 125, 139));
                    screen = 1;
                    icon[screen].setColorFilter(Color.rgb(255, 109, 0));
                }
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
                break;
            case products:
                currentFragment = new FragmentProducts();
                switchToNewScreen();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    icon[screen].setColorFilter(getColor(R.color.colorNotClicked));
                    screen = 2;
                    icon[screen].setColorFilter(getColor(R.color.colorAccent));
                } else {
                    icon[screen].setColorFilter(Color.rgb(96, 125, 139));
                    screen = 2;
                    icon[screen].setColorFilter(Color.rgb(245, 124, 0));
                }
                Toast.makeText(this, "products", Toast.LENGTH_SHORT).show();
                break;
            case contact:
                currentFragment = new FragmentContact();
                switchToNewScreen();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    icon[screen].setColorFilter(getColor(R.color.colorNotClicked));
                    screen = 3;
                    icon[screen].setColorFilter(getColor(R.color.colorAccent));
                } else {
                    icon[screen].setColorFilter(Color.rgb(96, 125, 139));
                    screen = 3;
                    icon[screen].setColorFilter(Color.rgb(245, 124, 0));
                }
                Toast.makeText(this, "contact", Toast.LENGTH_SHORT).show();
                break;
            case explore:
                currentFragment = new FragmentExplore();
                switchToNewScreen();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    icon[screen].setColorFilter(getColor(R.color.colorNotClicked));
                    screen = 4;
                    icon[screen].setColorFilter(getColor(R.color.colorAccent));
                } else {
                    icon[screen].setColorFilter(Color.rgb(96, 125, 139));
                    screen = 4;
                    icon[screen].setColorFilter(Color.rgb(245, 124, 0));
                }
                Toast.makeText(this, "explore", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void switchToNewScreen() {
        //tell the fragment manager that if our current fragment isn't null, to replace whatever is there with it
        FragmentManager fm = getSupportFragmentManager();
        if (currentFragment != null) {
            fm.beginTransaction()
                    .replace(R.id.fragment_container, currentFragment)
                    .commit();
        }
    }
}