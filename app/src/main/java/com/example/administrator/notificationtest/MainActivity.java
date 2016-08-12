package com.example.administrator.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button sendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button) findViewById(R.id.but1);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but1:
                NotificationManager manager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);
                Notification noti = new Notification.Builder(MainActivity.this)
                     //   .setAutoCancel(true)//打开程序后图标消失
                        .setContentTitle("This is title")//设置标题
                        .setContentText("This is content")//设置内容
//                        .setContentIntent(pendingIntent) //设置点击启动
                        .setSmallIcon(R.drawable.duihao)//设置图标
                        .setWhen(System.currentTimeMillis())//设置时间戳
                        .setDefaults(Notification.DEFAULT_ALL) //设置默认的提示音，振动方式，灯光
                        .setTicker("This is ticker")
                        .build();
                manager.notify(1, noti);//首先没有创建通知管理对象，之后忘记调用Notification的notify()方法
                break;
            default:
                break;
        }
    }
}
