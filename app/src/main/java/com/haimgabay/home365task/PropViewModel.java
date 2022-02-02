package com.haimgabay.home365task;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import androidx.lifecycle.LiveData;

public class PropViewModel extends ViewModel {

    private Repository repository;
    private LiveData<ArrayList<SinglePropDetails>> props;

    public void init(){
        if (props != null){
            return;
        }
        repository = Repository.getInstance();
        props = repository.getAllProps();
    }

    public LiveData<ArrayList<SinglePropDetails>> getAllProps() {
        return props;
    }
}