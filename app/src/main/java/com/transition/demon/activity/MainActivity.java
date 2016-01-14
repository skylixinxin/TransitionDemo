package com.transition.demon.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.transition.demon.R;
import com.transition.demon.adapter.AnimationApisAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_animation_apis);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] apiArray = getResources().getStringArray(R.array.animation_apis);
        AnimationApisAdapter animationApisAdapter =
                new AnimationApisAdapter(apiArray, onRecyclerItemClick);
        recyclerView.setAdapter(animationApisAdapter);
    }

    private AnimationApisAdapter.OnRecyclerItemClick onRecyclerItemClick = new AnimationApisAdapter.OnRecyclerItemClick() {
        @Override
        public void onItemClick(int position) {
            Intent intent = null;
            switch (position){
                case 0:
                    intent = new Intent(
                            MainActivity.this, WindowTransitionsActivityExplode.class);
                    break;
                case 1:
                    break;
                default:
                    break;
            }
            if (intent != null) startActivity(intent);
        }
    };

}
