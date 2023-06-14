package com.example.openinapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import com.example.openinapp.data_package.AllMethod_Variable;
import com.example.openinapp.data_package.DashboardResponse;
import com.example.openinapp.data_package.TabAdapter;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.tabs.TabLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    LineChart lineChart;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabAdapter tabAdapter;

    DashboardResponse dashboardResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChart = findViewById(R.id.linechart);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        get_data();

    }

    void get_data() {
        retrofit = Retrofit_Instance.getRetrofit_Instance();
        Api_Interface api_interface = retrofit.create(Api_Interface.class);
        Call<DashboardResponse> call = api_interface.getDashboardData();
        call.enqueue(new Callback<DashboardResponse>() {
            @Override
            public void onResponse(Call<DashboardResponse> call, Response<DashboardResponse> response) {
                if (response.isSuccessful()) {
                    dashboardResponse = response.body();
                      AllMethod_Variable.dashboardResponse_for_ALLdata=dashboardResponse;
                    show_linechat();
                    tab_call_for_tiplinks_recentliks();
                    Toast.makeText(MainActivity.this, "data" + dashboardResponse, Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<DashboardResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    void show_linechat() {
        Map<String, Integer> overall_url_chart = dashboardResponse.getData().getOverall_url_chart();
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setGranularity(10f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        YAxis yAxisLeft = lineChart.getAxisLeft();
        yAxisLeft.setAxisMinimum(0f);

        YAxis yAxisRight = lineChart.getAxisRight();
        yAxisRight.setEnabled(false);

        // Prepare the data for the line chart
        List<String> labels = new ArrayList<>();
        List<Integer> values = new ArrayList<>();


        for (Map.Entry<String, Integer> entry : overall_url_chart.entrySet()) {
            labels.add(entry.getKey());
            values.add(entry.getValue());
        }

        int totalDataPoints = labels.size();

        ArrayList<Entry> entries = new ArrayList<>();
        for (int i = 0; i < labels.size(); i++) {
            entries.add(new Entry(i, values.get(i)));
        }

        // Create a custom ValueFormatter for the x-axis labels
        IAxisValueFormatter xAxisFormatter = new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                int index = (int) value;
                if (index >= 0 && index < labels.size()) {
                    return labels.get(index);
                }
                return "";
            }
        };

        xAxis.setValueFormatter((ValueFormatter) xAxisFormatter);

        LineDataSet lineDataSet = new LineDataSet(entries, "Data Set");
        lineDataSet.setLineWidth(2f);
        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setCircleRadius(1f);
        lineDataSet.setCircleColor(Color.BLUE);
        lineDataSet.setDrawValues(true);
        lineDataSet.setValueTextSize(8f);
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setPinchZoom(true);
        lineChart.setElevation(5f);

        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();

        lineChart.setVisibleXRangeMinimum(totalDataPoints);
        lineChart.setVisibleXRangeMaximum(totalDataPoints);
        lineChart.setOnChartGestureListener(new OnChartGestureListener() {
            @Override
            public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {

            }

            @Override
            public void onChartLongPressed(MotionEvent me) {

            }

            @Override
            public void onChartDoubleTapped(MotionEvent me) {

            }

            @Override
            public void onChartSingleTapped(MotionEvent me) {

            }

            @Override
            public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
//                if (Math.abs(velocityX) > Math.abs(velocityY)) {
//                    // Calculate the number of data points to shift
//                    float deltaX = me2.getX() - me1.getX();
//                    float scaleX = lineChart.getScaleX();
//                    float visibleRange = lineChart.getVisibleXRange();
//                    float shift = deltaX / scaleX / visibleRange;
//
//                    // Adjust the visible range of the x-axis
//                    float visibleXRange = lineChart.getVisibleXRange();
//                    float newVisibleXRange = visibleXRange + shift;
//
//                    // Set the new visible range of the x-axis
//                    lineChart.setVisibleXRange(newVisibleXRange, newVisibleXRange);
//                }


                if (Math.abs(velocityX) > Math.abs(velocityY)) {
                    // Calculate the number of data points to shift
                    float deltaX = me2.getX() - me1.getX();
                    float scaleX = lineChart.getScaleX();
                    float visibleRange = lineChart.getVisibleXRange();
                    float shift = deltaX / scaleX / visibleRange;

                    // Get the total number of data points
                    int totalDataPoints = labels.size(); // Assuming labels is the list of x-axis labels

                    // Calculate the maximum visible range based on the total number of data points
                    float maxVisibleRange = totalDataPoints - visibleRange;

                    // Calculate the new visible range of the x-axis
                    float newVisibleRange = Math.min(Math.max(0, lineChart.getLowestVisibleX() + shift), maxVisibleRange);

                    // Set the new visible range of the x-axis
                    lineChart.setVisibleXRange(newVisibleRange, newVisibleRange + visibleRange);
                }





            }

            @Override
            public void onChartScale(MotionEvent me, float scaleX, float scaleY) {

            }

            @Override
            public void onChartTranslate(MotionEvent me, float dX, float dY) {

            }
        });





    }


     void tab_call_for_tiplinks_recentliks(){
         tabAdapter = new TabAdapter(getSupportFragmentManager());
         viewPager.setAdapter(tabAdapter);
         tabLayout.setupWithViewPager(viewPager);

     }


}



