package com.lpaina.musicians;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Musician> musicians = getMusicians();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(musicians);
        recyclerView.setAdapter(adapter);
    }

    public List<Musician> getMusicians() {
        ArrayList<Musician> musicians = new ArrayList<>();
        musicians.add(new Musician(
                "Example1", Arrays.asList("Style1", "Style2"), 1, 10,
                "I am an example1", ContextCompat.getDrawable(this, R.drawable.default_photo)));
        musicians.add(new Musician(
                "Example2", Arrays.asList("Style1"), 2, 20,
                "I am an example2", ContextCompat.getDrawable(this, R.drawable.default_photo)));
        return musicians;

    }
}
