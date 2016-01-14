package com.transition.demon.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.View;
import android.view.Window;

import com.transition.demon.R;
import com.transition.demon.adapter.LinearAdapter;

import demon.example.com.mylibrary.ActivityCompatICS;
import demon.example.com.mylibrary.ActivityOptionsCompatICS;

public class WindowTransitionsActivityExplode extends AppCompatActivity {

    private RecyclerView mTeamRecycler;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_transitions_explode);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mTeamRecycler = (RecyclerView)findViewById(R.id.recycler_view_team);
        setupToolbar();
        setupRecyclerView();
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setupRecyclerView() {
        mTeamRecycler.setLayoutManager(new LinearLayoutManager(this));
        String[] items = getResources().getStringArray(R.array.items);
        mTeamRecycler.setAdapter(new LinearAdapter(items, onRecyclerItemClick));
    }

    private LinearAdapter.OnRecyclerItemClick onRecyclerItemClick = new LinearAdapter.OnRecyclerItemClick() {
        @Override
        public void onItemClick(View view) {
            Intent intent = new Intent(
                    WindowTransitionsActivityExplode.this, SharedTransitionsInActionbarActivity.class);
            if (Build.VERSION.SDK_INT >= 21){
                Pair squareParticipant = new Pair<>(view, ViewCompat.getTransitionName(view));
                ActivityOptionsCompat transitionActivityOptions =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                                WindowTransitionsActivityExplode.this, squareParticipant);
                startActivity(intent, transitionActivityOptions.toBundle());
            }else {
                screenTransitAnimByPair(intent, Pair.create(view, R.id.text_shared_transition));
            }
        }
    };

    public void screenTransitAnimByPair(Intent intent, Pair<View, Integer>... views) {
        ActivityOptionsCompatICS options = ActivityOptionsCompatICS.makeSceneTransitionAnimation(
                WindowTransitionsActivityExplode.this, views);
        ActivityCompatICS.startActivity(WindowTransitionsActivityExplode.this, intent, options.toBundle());
    }

}
