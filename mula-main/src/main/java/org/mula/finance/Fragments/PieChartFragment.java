package org.mula.finance.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import org.mula.finance.Models.PieChartViewModel;
import org.mula.finance.R;
import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.callback.OnPieSelectListener;
import com.razerdp.widget.animatedpieview.data.IPieInfo;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

public class PieChartFragment extends Fragment {

    private PieChartViewModel mPieChartViewModel;

//    public static PieChartFragment newInstance() {
//        return new PieChartFragment();
//    }
    //empty constructor

    public PieChartFragment(){

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mPieChartViewModel =
                ViewModelProviders.of(this).get(PieChartViewModel.class);

        final View root = inflater.inflate(R.layout.fragment_pie_chart, container, false);

        final TextView textView = root.findViewById(R.id.text_pieChart);
        AnimatedPieView animatedPieView = root.findViewById(R.id.pieView);

        double futureValue = getArguments().getDouble("Future Value", 0);
        double interestPrinciple = getArguments().getDouble("Interest Principle", 0);
        double interestContribution = getArguments().getDouble("Interest Contributions", 0);

        float futureValueFloat = (float)futureValue;
        float interestPrincipleFloat = (float)interestPrinciple;
        float interestContributionFloat = (float)interestContribution;


        AnimatedPieViewConfig config = new AnimatedPieViewConfig();
        config.addData(new SimplePieInfo(futureValueFloat, Color.parseColor("#AA85C8F2"), "Future Value"));
        config.addData(new SimplePieInfo(interestPrincipleFloat,Color.parseColor("#AAF2811D"), "Interest Principle"));
        config.addData(new SimplePieInfo(interestContributionFloat,Color.parseColor("#AAF26666"), "Interest Contribution"));
        config.drawText(true);
        config.strokeMode(false);
        config.textSize(24);
        config.selectListener(new OnPieSelectListener<IPieInfo>() {
            @Override
            public void onSelectPie(@NonNull IPieInfo pieInfo, boolean isFloatUp) {
                Toast.makeText(PieChartFragment.this.getActivity(),pieInfo.getDesc() + " : " + pieInfo.getValue(), Toast.LENGTH_SHORT).show();
            }
        });


        animatedPieView.applyConfig(config);
        animatedPieView.start();

        mPieChartViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

}
