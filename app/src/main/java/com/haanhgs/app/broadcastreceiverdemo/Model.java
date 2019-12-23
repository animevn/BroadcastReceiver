package com.haanhgs.app.broadcastreceiverdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Model extends ViewModel {

    private final MutableLiveData<String> data = new MutableLiveData<>();

    public MutableLiveData<String> getData() {
        return data;
    }

    public void setData(String data) {
        this.data.setValue(data);
    }
}
