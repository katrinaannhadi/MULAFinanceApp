package org.mula.finance.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.mula.finance.Fragments.HomeFragment;
import org.mula.finance.R;
import org.mula.finance.activities.ExpenseTrackerActivity;
import org.mula.finance.Models.Model;
import org.mula.finance.activities.habits.list.ListHabitsActivity;

import java.util.List;

public class GoalAdapter extends PagerAdapter {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private HomeFragment context;

    public GoalAdapter(List<Model> models, HomeFragment context) {
        this.models = models;
        this.context = context;
    }


    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context.getContext());
        View view = layoutInflater.inflate(R.layout.item_article, container, false);

        ImageView imageView;
        TextView title, desc;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.title);
        desc = view.findViewById(R.id.desc);

        imageView.setImageResource(models.get(position).getImage());
        title.setText(models.get(position).getTitle());
        desc.setText(models.get(position).getDesc());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO TURN THIS BACK ON
                if(position == 0){
                    Intent intent = new Intent(context.getContext(), ListHabitsActivity.class);
                    context.startActivity(intent);
                } else if (position == 1){
                    Intent intent = new Intent(context.getContext(), ExpenseTrackerActivity.class);
                    context.startActivity(intent);
                }
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}

