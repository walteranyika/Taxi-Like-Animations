package io.walter.taxilikeanims;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout mLinearLayoutRequest;
    LinearLayout mLinearLayoutDriver;
    LinearLayout mLinearLayoutEstimates;

    Animation mSlideUp, mSlideDown;

    int flowValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayoutDriver = findViewById(R.id.linearLayoutDriver);
        mLinearLayoutRequest = findViewById(R.id.linearLayoutRequest);
        mLinearLayoutEstimates = findViewById(R.id.linearLayoutEstimates);

        mSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        mSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        updateLayoutChanges();
    }

    public void updateLayoutChanges() {
        if (mLinearLayoutRequest.getVisibility() == View.VISIBLE) {
            mLinearLayoutRequest.setAnimation(mSlideDown);
        } else if (mLinearLayoutDriver.getVisibility() == View.VISIBLE) {
            mLinearLayoutDriver.setAnimation(mSlideDown);
        } else if (mLinearLayoutEstimates.getVisibility() == View.VISIBLE) {
            mLinearLayoutEstimates.setAnimation(mSlideDown);
        }

        mLinearLayoutRequest.setVisibility(View.GONE);
        mLinearLayoutDriver.setVisibility(View.GONE);
        mLinearLayoutEstimates.setVisibility(View.GONE);
        if (flowValue == 0) {
            mLinearLayoutRequest.startAnimation(mSlideUp);
            mLinearLayoutRequest.setVisibility(View.VISIBLE);
        } else if (flowValue == 1) {
            mLinearLayoutEstimates.startAnimation(mSlideUp);
            mLinearLayoutEstimates.setVisibility(View.VISIBLE);
        } else if (flowValue == 2) {
            mLinearLayoutDriver.startAnimation(mSlideUp);
            mLinearLayoutDriver.setVisibility(View.VISIBLE);
        } else {
            flowValue = 0;
            mLinearLayoutRequest.startAnimation(mSlideUp);
            mLinearLayoutRequest.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add) {
            flowValue++;
            updateLayoutChanges();
        }
        return super.onOptionsItemSelected(item);
    }


}
