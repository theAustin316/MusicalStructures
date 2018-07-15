package com.example.vivek.musicalstructures;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        TabLayout tabLayout = findViewById(R.id.tabs);

        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        tabLayout.setupWithViewPager(viewPager);

    }

    // fancy gif dialog box will be displayed when physical back button is pressed
    public void onBackPressed() {
        new FancyGifDialog.Builder(this)
                .setTitle(getString(R.string.quit))
                .setMessage(getString(R.string.quitmsg))
                .setNegativeBtnText(getString(R.string.neg))
                .setPositiveBtnBackground("#FF4081")
                .setPositiveBtnText(getString(R.string.yep))
                .setNegativeBtnBackground("#FFA9A7A8")
                .setGifResource(R.drawable.exit)   //Pass your Gif here
                .isCancellable(true)
                .OnPositiveClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {
                        Toast.makeText(MainActivity.this, R.string.affirm, Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })
                .OnNegativeClicked(new FancyGifDialogListener() {
                    @Override
                    public void OnClick() {
                        Toast.makeText(MainActivity.this, R.string.negate, Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
    }
}