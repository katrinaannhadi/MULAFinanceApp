package org.mula.finance.Fragments;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import org.mula.finance.Adapters.InformationAdapter;
import org.mula.finance.R;
import org.mula.finance.Models.Model;

import java.util.ArrayList;
import java.util.List;

//Information Fragment
public class InformationFragment extends Fragment  {

    private View view;
    private Context context;


    ViewPager viewPager;
    InformationAdapter mInformationAdapter;
    List<Model> mInformation;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private static final String TAG = " 2 ARTICLE SELECTION ";


    public InformationFragment() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_article_selection_viewpager, container, false);
        context = view.getContext();

        mInformation = new ArrayList<>();
        mInformation.add(new Model(R.drawable.ic_learn1, "Educate Yourself", "Finance shouldn't be hard! Read on for hot tips and trendy articles.", 1));
        mInformation.add(new Model(R.drawable.ic_learn2, "Need a Challenge", "Have some fun and test yourself with our quiz!", 2));
        mInformation.add(new Model(R.drawable.ic_learn3, "Visual Learner", "We got your back. Sit back and watch informational videos on finance curated by the team!", 2));
        mInformationAdapter = new InformationAdapter(mInformation, this);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(mInformationAdapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.purple_50),
                getResources().getColor(R.color.mula_purple_500),
                getResources().getColor(R.color.mula_purple_600)

        };

        colors = colors_temp;


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (mInformationAdapter.getCount() - 1) && position < (colors.length - 1)) {
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

        return view;
    }
}



