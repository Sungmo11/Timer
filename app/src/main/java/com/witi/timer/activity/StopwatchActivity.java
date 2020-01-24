package com.witi.timer.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.witi.timer.R;

public class StopwatchActivity extends AppCompatActivity {

    RelativeLayout layout_stopwatch;

    String str;
    TextView tv_timer, tv_testscrollBtn;
    Button btn_start, btn_pause, btn_reset;
    private long MillisecondTime, StartTime, TimeBuff, UpdateTime;
    Handler handler;
    int Hours, Seconds, Minutes, MilliSeconds;
//    ListView listView;
//    String[] ListElements = new String[]{};
//    List<String> ListElementsArrayList;
//    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        tv_timer = findViewById(R.id.tv_timer);
        btn_start = findViewById(R.id.btn_start);
        btn_pause = findViewById(R.id.btn_pause);
        btn_reset = findViewById(R.id.btn_reset);
//      listView = findViewById(R.id.listView);
        layout_stopwatch = findViewById(R.id.layout_stopwatch);

        // ScrollButton Test
        tv_testscrollBtn = findViewById(R.id.tv_testscrollBtn);

        MillisecondTime = StartTime = TimeBuff = UpdateTime = 0L;
        Hours = Seconds = Minutes = MilliSeconds = 0;

        handler = new Handler();
//      ListElementsArrayList = new ArrayList<>(Arrays.asList(ListElements));
//      adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListElementsArrayList);
//      listView.setAdapter(adapter);

    }

    public void clickBtn(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                StartTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
                btn_reset.setEnabled(false);
                btn_start.setVisibility(View.GONE);
                btn_pause.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_pause:
                TimeBuff += MillisecondTime;
                handler.removeCallbacks(runnable);
                btn_reset.setEnabled(true);
                btn_start.setVisibility(View.VISIBLE);
                btn_pause.setVisibility(View.GONE);
                break;
            case R.id.btn_reset:
                MillisecondTime = 0L;
                StartTime = 0L;
                TimeBuff = 0L;
                UpdateTime = 0L;
                Hours = 0;
                Seconds = 0;
                Minutes = 0;
                MilliSeconds = 0;

                tv_timer.setText("00:00:00");
//                ListElementsArrayList.clear();
//                adapter.notifyDataSetChanged();
                break;
            case R.id.btn_done:
                Intent intent = new Intent(getApplicationContext(), StudyTraceActivity.class);
                intent.putExtra("Hours", Hours);
                intent.putExtra("Minutes", Minutes);
                intent.putExtra("Seconds", Seconds);
                Log.e("Watch : ", str);
                startActivity(intent);
                handler.removeCallbacks(runnable);
                break;
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            MillisecondTime = SystemClock.uptimeMillis() - StartTime;
//            UpdateTime = ((TimeBuff + MillisecondTime) * 1000) ;
            UpdateTime = TimeBuff + MillisecondTime;
//            Seconds = (int) (UpdateTime / 1000);
//            Minutes = (int) (UpdateTime / 60000);
            Hours = (int) ((UpdateTime / 1000) / 3600);
            Minutes = (int) ((UpdateTime / 60000) % 60);
            Seconds = (int) ((UpdateTime / 1000) % 60);
//            MilliSeconds = (int) (UpdateTime % 1000);

//            Log.e("UpdateTime : ", String.valueOf(UpdateTime));
//            Log.e("TimeBuff : ", String.valueOf(TimeBuff));
            str = "Hours : " + Hours + ", Minutes : " + Minutes + ", Seconds : " + Seconds;
//            Log.e("Watch : ", str);
            tv_timer.setText("" + String.format("%02d", Hours) + ":" + String.format("%02d", Minutes) + ":" + String.format("%02d", Seconds)); /* String.format("%03d", MilliSeconds) */
            handler.postDelayed(this,0);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause : ", "돌입!!");
//        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop : ", "돌입!!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy : ", "돌입!!");
    }

    // scrollBtn Test
    public void testscroll(View view) {
        switch (view.getId()){
            case R.id.btn_scrolltest1:
                tv_testscrollBtn.setText("테스트1");
                layout_stopwatch.setBackgroundColor(Color.RED);
                break;
            case R.id.btn_scrolltest2:
                tv_testscrollBtn.setText("테스트2");
                layout_stopwatch.setBackgroundColor(Color.BLUE);
                break;
            case R.id.btn_scrolltest3:
                tv_testscrollBtn.setText("테스트3");
                layout_stopwatch.setBackgroundColor(Color.GREEN);
                break;
            case R.id.btn_scrolltest4:
                tv_testscrollBtn.setText("테스트4");
                layout_stopwatch.setBackgroundColor(Color.DKGRAY);
                break;
            case R.id.btn_scrolltest5:
                tv_testscrollBtn.setText("테스트5");
                layout_stopwatch.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.btn_scrolltest6:
                tv_testscrollBtn.setText("테스트6");
                layout_stopwatch.setBackgroundColor(Color.WHITE);
                break;
            case R.id.btn_scrolltest7:
                tv_testscrollBtn.setText("테스트7");
                layout_stopwatch.setBackgroundColor(Color.MAGENTA);
                break;

        }
    }
}
