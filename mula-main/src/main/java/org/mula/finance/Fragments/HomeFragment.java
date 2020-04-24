package org.mula.finance.Fragments;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.mula.finance.R;
import org.mula.finance.Adapters.GoalAdapter;
import org.mula.finance.Models.Model;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private View view;
    private Button goalsButton;
    private Button expenseButton;

    private Context context;
    private MediaPlayer mp;
    ViewPager viewPager;
    GoalAdapter mGoalAdapter;
    List<Model> mGoals;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private static final String TAG = " 2 ARTICLE SELECTION ";



    public HomeFragment() {
        // Required empty public constructor
    }


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_article_selection_viewpager, container, false);
        context = view.getContext();

        mGoals = new ArrayList<>();
        mGoals.add(new Model(R.drawable.ic_goal1, "Smash your Goals", "Use our goal tracker to keep track of smart financial habits, get reminders and more!",1));
        mGoals.add(new Model(R.drawable.ic_goal2, "Track your Expenses", "Use our expense tracker to help you achieve your financial goals!",2));
        mGoalAdapter = new GoalAdapter(mGoals, this);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(mGoalAdapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.mula_yellow_500),
                getResources().getColor(R.color.mula_yellow_600),

        };

        colors = colors_temp;



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (mGoalAdapter.getCount() -1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                }

                else {
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



        return view;
    }

}


