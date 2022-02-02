package com.haimgabay.home365task;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PropRecyclerAdapter.OnPropClickedListener {

    PropViewModel viewModel;
    RecyclerView recyclerView;
    PropRecyclerAdapter propsRecyclerAdapter;
    private int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication())).get(PropViewModel.class);

        viewModel.init();
        viewModel.getAllProps().observe(this, new Observer<ArrayList<SinglePropDetails>>() {
            @Override
            public void onChanged(ArrayList<SinglePropDetails> props) {
                if (propsRecyclerAdapter == null){
                    initRecyclerView();
                }
                propsRecyclerAdapter.propsArrayList.clear();
                propsRecyclerAdapter.propsArrayList = props;
                propsRecyclerAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }
    private void initRecyclerView(){
        propsRecyclerAdapter = new PropRecyclerAdapter(viewModel.getAllProps().getValue(),
                this,  this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(propsRecyclerAdapter);
    }

    @Override
    public void OnPropClicked(int position, View itemView) {
        pos = position;
        Toast.makeText(this, "prop clicked" + pos, Toast.LENGTH_SHORT).show();
    }
}
