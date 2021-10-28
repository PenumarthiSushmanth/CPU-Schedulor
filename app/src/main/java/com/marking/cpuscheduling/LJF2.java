package com.marking.cpuscheduling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LJF2 extends AppCompatActivity {

    private EditText mPid;
    private EditText mBurstTime;
    private EditText mArrTime;

    public ArrayList<Integer> pids = new ArrayList<>();
    public ArrayList<Integer> bur_times = new ArrayList<>();
    public ArrayList<Integer> arr_times = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ljf);

        mPid = findViewById(R.id.pid);
        mBurstTime = findViewById(R.id.burst_time);
        mArrTime = findViewById(R.id.arrival_time);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_processes:
                if (!TextUtils.isEmpty(mPid.getText()) && !TextUtils.isEmpty(mBurstTime.getText()) &&
                        !TextUtils.isEmpty(mArrTime.getText())) {
                    int p = Integer.parseInt(mPid.getText().toString());
                    int b = Integer.parseInt(mBurstTime.getText().toString());
                    int a = Integer.parseInt(mArrTime.getText().toString());

                    pids.add(p);
                    bur_times.add(b);
                    arr_times.add(a);

                    mPid.setText("");
                    mBurstTime.setText("");
                    mArrTime.setText("");


                } else {
                    Toast.makeText(getApplicationContext(), "Please Enter Complete Details", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.submit:

//

                int[] pid_arr = new int[pids.size()];
                int[] bur_arr = new int[bur_times.size()];
                int[] arrv_arr = new int[arr_times.size()];

                for (int i = 0; i < pids.size(); i++) {
                    pid_arr[i] = pids.get(i);
                }

                for (int i = 0; i < bur_times.size(); i++) {
                    bur_arr[i] = bur_times.get(i);
                }

                for (int i = 0; i < arr_times.size(); i++) {
                    arrv_arr[i] = arr_times.get(i);
                }

                LJFC2 ljf = new LJFC2();
                ljf.cal(bur_times.size(), arrv_arr, bur_arr, pid_arr);
                int[] ljf_wt = ljf.waitingtime(bur_times.size(), arrv_arr, bur_arr);
                int[] ljf_turn = ljf.turnaroundtime(bur_times.size(), arrv_arr, bur_arr);
                int[] ljf_pid = ljf.processor();
                Intent resultIntent = new Intent(LJF2.this, Result.class);
                resultIntent.putExtra("pid", ljf_pid);
                resultIntent.putExtra("waiting time", ljf_wt);
                resultIntent.putExtra("turn_around_time", ljf_turn);
                resultIntent.putExtra("burst time", bur_arr);
                resultIntent.putExtra("algo", "Longest Job First (LJF)");
                startActivity(resultIntent);

        }
    }
}