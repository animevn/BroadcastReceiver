package com.haanhgs.app.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bnToggle)
    ToggleButton bnToggle;
    @BindView(R.id.tvMessage)
    TextView tvMessage;
    @BindView(R.id.bnSend)
    Button bnSend;

    public static final String BROADCAST = "Custom Broadcast";
    private CustomReceiver receiver;
    private Observer<String> observer;
    private Model model;
    private IntentFilter filter;
    private boolean toggleStatus = false;

    private void init(){
        model = new ViewModelProvider(this).get(Model.class);
        observer = string -> tvMessage.setText(string);
        receiver = new CustomReceiver();
        receiver.setModel(model);
    }

    private void createFilter(){
        filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(BROADCAST);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        createFilter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }

    private void handleToggle(){
        if (toggleStatus){
            model.getData().removeObserver(observer);
            tvMessage.setText(getResources().getString(R.string.tvMessage));
            toggleStatus = !toggleStatus;
        }else {
            model.getData().observe(this, observer);
            toggleStatus = !toggleStatus;
        }
    }

    private void handleSendBroadcast(){
        sendBroadcast(new Intent(BROADCAST));
    }

    @OnClick({R.id.bnToggle, R.id.bnSend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnToggle:
                handleToggle();
                break;
            case R.id.bnSend:
                handleSendBroadcast();
                break;
        }
    }
}
