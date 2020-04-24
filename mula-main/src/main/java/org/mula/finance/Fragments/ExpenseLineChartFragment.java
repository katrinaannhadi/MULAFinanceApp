package org.mula.finance.Fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import org.mula.finance.R;

import java.util.ArrayList;
import java.util.HashMap;


public class ExpenseLineChartFragment extends Fragment {

    private static final String TAG = "LineChartFragment";


    public ExpenseLineChartFragment() {

    }

    @SuppressLint("DefaultLocale")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        final View root = inflater.inflate(R.layout.fragment_line_chart, container, false);


        LineChart mLineChart = root.findViewById(R.id.lineView);

        HashMap<Integer, Double> dataPoints = (HashMap<Integer, Double>) getArguments().getSerializable("keyValues");

        mLineChart.setDragEnabled(true);
        mLineChart.setScaleEnabled(false);

        ArrayList<Entry> entries = new ArrayList();

        double currentSum = 0;
        for (int t = -30; t <= 0; t++) {
            currentSum += dataPoints.containsKey(t) ? dataPoints.get(t) : 0.0;
            Entry e = new Entry(new Float(t), new Float(currentSum));
            entries.add(e);
        }

        LineDataSet set1 = new LineDataSet(entries, "Expenses");
        set1.setFillAlpha(110);
        set1.setLineWidth(3f);
        set1.setDrawValues(false);
        set1.setCircleRadius(4f);
        set1.setCircleColors(Color.parseColor("#AA85C8F2"));
        set1.setColor(Color.parseColor("#AA85C8F2"));
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);

        YAxis leftAxis = mLineChart.getAxisLeft();
        leftAxis.setDrawAxisLine(false);
        mLineChart.getAxisRight().setEnabled(false);
        leftAxis.setAxisMinimum(0f);

        Legend leg1 = mLineChart.getLegend();
        leg1.setEnabled(true);

        Description des1 = mLineChart.getDescription();
        des1.setTextSize(20f);
        des1.setEnabled(false);

        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);


        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);


        LineData data = new LineData(dataSets);
        mLineChart.setData(data);
        return root;
    }
}
