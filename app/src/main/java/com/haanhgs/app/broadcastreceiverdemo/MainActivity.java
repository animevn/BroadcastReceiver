package com.haanhgs.app.broadcastreceiverdemo;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
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
    private Observer<String> data;
    private Model model;
    private IntentFilter filter;
    private boolean toggleStatus = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bnToggle, R.id.bnSend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnToggle:
                break;
            case R.id.bnSend:
                break;
        }
    }
}
