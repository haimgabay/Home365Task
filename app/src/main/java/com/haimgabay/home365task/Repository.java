package com.haimgabay.home365task;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class Repository {

    MutableLiveData<ArrayList<SinglePropDetails>> props = new MutableLiveData<>();
    ArrayList<SinglePropDetails> currentPropsList = new ArrayList<>();
    private static Repository instance;
    private boolean runDownload = true;
    int currentPage = 1;
    int totalPages = 10;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<SinglePropDetails>> getAllProps() {
        return getPropsFromDb();
    }


    public void stopLoadingProps() {
        runDownload = false;
    }

    public void startLoadingProps() {
        runDownload = true;
    }

    public MutableLiveData<ArrayList<SinglePropDetails>> getPropsFromDb() {
        currentPage = 0;
        startLoadingProps();
        while ((currentPage < totalPages) && runDownload) {
            currentPage++;
            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(JsonString.getJson());
//                Log.d("JSON", jsonObject.toString());
                JSONArray resultsObject = (JSONArray) jsonObject.getJSONArray("properties");
                for (int i = 0; i < resultsObject.length(); i++) {
                    JSONObject object = resultsObject.getJSONObject(i);
                    Log.d("RESPONSE: ", resultsObject.getJSONObject(i).toString());
                    String id = object.getString("propertyId");
                    String created = object.getString("createdOn");
                    String address = object.getString("address");
                    String status = object.getString("occupiedStats");
                    String plan = object.getString("plan");
                    String owner = object.getString("owner");
                    String ownerStatus = object.getString("created");
                    JSONObject tenant = new JSONObject(object.getString("tenant"));
                    String tenantStatus = object.getString("created");
                    currentPropsList.add(new SinglePropDetails(id, created, address, status, plan, owner, ownerStatus, tenant, tenantStatus));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        props.setValue(currentPropsList);
        stopLoadingProps();
        return props;
    }
}