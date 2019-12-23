package com.haanhgs.app.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class CustomReceiver extends BroadcastReceiver {

    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String intentString = intent.getAction();
        String data = "";
        if (intentString != null){
            switch (intentString){
                case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                    data = "Airplane mode changed";
                    break;
                case Intent.ACTION_POWER_CONNECTED:
                    data = "Power Connected";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    data = "Power Disconnected";
                    break;
                case MainActivity.BROADCAST:
                    data = MainActivity.BROADCAST;
                    break;
            }
        }
        model.setData(data);
    }

}
