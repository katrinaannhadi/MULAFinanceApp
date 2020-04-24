package org.mula.finance.Fragments;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.EntryXComparator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.mula.finance.Adapters.CalculatorCategoryAdapter;
import org.mula.finance.Models.Company;
import org.mula.finance.Models.DailyPrice;
import org.mula.finance.Models.IntentLink;

import org.mula.finance.R;
import org.mula.finance.Models.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculatorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculatorFragment extends Fragment {
    private View view;
    private Button refreshButton;
    private CandleStickChart candleStickChart;
    private String TAG = "HomeFragment";
    private ArrayList<CandleEntry> yValsCandleStick;
    private RecyclerView rv;
    private ArrayList<IntentLink> calc;
    private Context context;
    private LinearLayoutManager layoutManager;
    private CandleDataSet set1;
    private XAxis xAxis;
    private DateTimeFormatter toDate;
    private DateTimeFormatter toString;


    ViewPager viewPager;
    CalculatorCategoryAdapter mCalculatorCategoryAdapter;
    List<Model> mCalculator;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    public CalculatorFragment() {
        // Required empty public constructor
    }

    public static CalculatorFragment newInstance(String param1, String param2) {
        CalculatorFragment fragment = new CalculatorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_calculator, container, false);
        Log.d(TAG, "HomeFragment: SUCCESS");

        context = view.getContext();

        mCalculator = new ArrayList<>();
        mCalculator.add(new Model(R.drawable.ic_tax, "Tax Calculator", "Calculate your taxes.", 1));
        mCalculator.add(new Model(R.drawable.ic_investment, "Investment Calculator", "Use the calculator to predict future investments", 2));
        mCalculatorCategoryAdapter = new CalculatorCategoryAdapter(mCalculator, this);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(mCalculatorCategoryAdapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.mula_turqoise_400),
                getResources().getColor(R.color.mula_turqoise_400)


        };

        colors = colors_temp;


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (mCalculatorCategoryAdapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        candleStickChart = view.findViewById(R.id.candle_stick_chart);
        refreshButton = view.findViewById(R.id.button_refresh);
        refreshButton.setText("Refresh");

        toDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        toString = DateTimeFormatter.ofPattern("MM-dd HH");

        yValsCandleStick = new ArrayList<CandleEntry>();

        candleStickChart.setHighlightPerDragEnabled(true);
        candleStickChart.setDrawBorders(true);

        candleStickChart.setBorderColor(getResources().getColor(android.R.color.holo_blue_dark));
        YAxis yAxis = candleStickChart.getAxisLeft();
        YAxis rightAxis = candleStickChart.getAxisRight();
        yAxis.setDrawGridLines(false);
        rightAxis.setDrawGridLines(false);
        candleStickChart.requestDisallowInterceptTouchEvent(true);

        XAxis xAxis = candleStickChart.getXAxis();

        xAxis.setDrawGridLines(false);// disable x axis grid lines
        xAxis.setDrawLabels(true);
        xAxis.setTextColor(Color.BLACK);
        rightAxis.setTextColor(Color.BLACK);
        yAxis.setDrawLabels(true);
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setAvoidFirstLastClipping(true);

        Legend l = candleStickChart.getLegend();
        l.setEnabled(false);
        System.out.println("does this work");

        getStockPricesOnline();





        refreshButton.setOnClickListener(v -> getStockPricesOnline());

//        rv = view.findViewById(R.id.rv_calculator);
//        layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
//        rv.setLayoutManager(layoutManager);
//        context = view.getContext();
//
//        calc = new ArrayList<>();
//        List<Category> blank = new ArrayList<>();
//
//        calc.add(new IntentLink("Investment",
//                new Intent(context, InvestmentCalculatorActivity.class),
//                R.drawable.image_investment, R.color.light_blue_300, blank));
//
//        calc.add(new IntentLink("Tax",
//                new Intent(context, TaxCalculatorActivity.class),
//                R.drawable.ic_investment, R.color.amber_50, blank));

        //calc.add(new IntentLink("Goals",
        //     new Intent(context, ListHabitsActivity.class),
        //      R.drawable.image_investment, Color.parseColor("#B233FF")));



//        CalculatorAdapter calcAdapter = new CalculatorAdapter(calc);
//        rv.setAdapter(calcAdapter);



        return view;

    }

    private void getStockPricesOnline(){
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&outputsize=compact&symbol=DJIA&interval=60min&apikey=FD82S5VDRDGNB16U";


        Response.Listener<String> responseListener = // set data
                this::onResponse;

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("The request failed.");
                Activity activity = getActivity();
                if(activity != null && isAdded())

                    if (error instanceof NoConnectionError) {
                        String errormsg = "No Internet";
                        Toast.makeText(activity, errormsg, Toast.LENGTH_LONG).show();
                    }

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
        StringRequest stringRequest =
                new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void onResponse(String response) {
        Activity activity = getActivity();
        if (isAdded() && activity != null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            String jsonString = response;


            Company company = gson.fromJson(jsonString, Company.class);

            try {
                Collection<DailyPrice> values = company.getCompanyStockPrices().values();
                ArrayList<DailyPrice> dailyPrices = new ArrayList<DailyPrice>(values);
                Collection<String> xAxisValues = company.getCompanyStockPrices().keySet();
                ArrayList<String> xValues = new ArrayList<>(xAxisValues);

                for(int i = 0; i < xValues.size(); i++){
                    LocalDateTime date = LocalDateTime.parse(xValues.get(i), toDate);
                    xValues.set(i, date.format(toString));
                }

                xAxis = candleStickChart.getXAxis();
                xAxis.setValueFormatter(new IndexAxisValueFormatter(xValues));


                int size = dailyPrices.size();
                for (int i = 0; i < size; i++) {
                    DailyPrice dailyPrice = dailyPrices.get(i);
                    float j = (float) i;
                    CandleEntry candleEntry = new CandleEntry(j,
                            Float.parseFloat(dailyPrice.getDailyHigh()),
                            Float.parseFloat(dailyPrice.getDailyLow()),
                            Float.parseFloat(dailyPrice.getDailyOpen()),
                            Float.parseFloat(dailyPrice.getDailyClose()));
                    yValsCandleStick.add(candleEntry);
                }
                Collections.sort(yValsCandleStick, new EntryXComparator());
                if (set1 != null) {
                    set1 = new CandleDataSet(yValsCandleStick, "DataSet 1");
                    set1.setColor(Color.rgb(80, 80, 80));
                    set1.setShadowColor(getResources().getColor(android.R.color.darker_gray));
                    set1.setDecreasingColor(getResources().getColor(android.R.color.holo_red_light));
                    set1.setDecreasingPaintStyle(Paint.Style.FILL);
                    set1.setIncreasingColor(getResources().getColor(android.R.color.background_light));
                    set1.setIncreasingPaintStyle(Paint.Style.FILL);
                    set1.setNeutralColor(Color.LTGRAY);
                    set1.setDrawValues(false);

                    candleStickChart.notifyDataSetChanged();
                    CandleData candleData = new CandleData(set1);
                    candleStickChart.setData(candleData);
                    candleStickChart.invalidate();
                    candleStickChart.setVisibleXRangeMaximum(5);
                    candleStickChart.moveViewToX(yValsCandleStick.size());

                } else if (set1 == null) {
                    set1 = new CandleDataSet(yValsCandleStick, "DataSet 1");
                    set1.setColor(Color.rgb(80, 80, 80));
                    set1.setShadowColor(getResources().getColor(android.R.color.darker_gray));
                    set1.setDecreasingColor(getResources().getColor(android.R.color.holo_red_light));
                    set1.setDecreasingPaintStyle(Paint.Style.FILL);
                    set1.setIncreasingColor(getResources().getColor(android.R.color.background_light));
                    set1.setIncreasingPaintStyle(Paint.Style.FILL);
                    set1.setNeutralColor(Color.LTGRAY);
                    set1.setDrawValues(false);
                    System.out.println("Is this where it fails");

                    CandleData data = new CandleData(set1);


                    // set data
                    candleStickChart.setData(data);
                    candleStickChart.invalidate();
                    candleStickChart.setVisibleXRangeMaximum(5);
                    candleStickChart.moveViewToX(yValsCandleStick.size());
                }

            } catch (NullPointerException e){

            }

        }

    }
}

//TODO TAKE THIS OUT

//    private View view;
//    private Context context;
//
//
//    ViewPager viewPager;
//    InformationAdapter mInformationAdapter;
//    List<Model> mInformation;
//    Integer[] colors = null;
//    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
//    private static final String TAG = " 2 ARTICLE SELECTION ";
//
//
//    public InformationFragment() {
//        // Required empty public constructor
//    }
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//
//        }
//    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        view = inflater.inflate(R.layout.fragment_article_selection_viewpager, container, false);
//        context = view.getContext();
//
//        mInformation = new ArrayList<>();
//        mInformation.add(new Model(R.drawable.ic_learn1, "Educate Yourself", "Finance shouldn't be hard! Read on for hot tips and trendy articles.", 1));
//        mInformation.add(new Model(R.drawable.ic_learn2, "Need a Challenge", "Have some fun and test yourself with our quiz!", 2));
//        mInformation.add(new Model(R.drawable.ic_learn3, "Visual Learner", "We got your back. Sit back and watch informational videos on finance curated by the team!", 2));
//        mInformationAdapter = new InformationAdapter(mInformation, this);
//
//        viewPager = view.findViewById(R.id.viewPager);
//        viewPager.setAdapter(mInformationAdapter);
//        viewPager.setPadding(130, 0, 130, 0);
//
//        Integer[] colors_temp = {
//                getResources().getColor(R.color.mula_purple_200),
//                getResources().getColor(R.color.mula_purple_500),
//                getResources().getColor(R.color.mula_purple_600)
//
//        };
//
//        colors = colors_temp;
//
//
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//                if (position < (mInformationAdapter.getCount() - 1) && position < (colors.length - 1)) {
//                    viewPager.setBackgroundColor(
//
//                            (Integer) argbEvaluator.evaluate(
//                                    positionOffset,
//                                    colors[position],
//                                    colors[position + 1]
//                            )
//                    );
//                } else {
//                    viewPager.setBackgroundColor(colors[colors.length - 1]);
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//        return view;
//    }
//}

