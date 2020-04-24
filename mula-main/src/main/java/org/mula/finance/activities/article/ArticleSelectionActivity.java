package org.mula.finance.activities.article;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import org.mula.finance.Adapters.CategoryAdapter;
import org.mula.finance.Models.Model;
import org.mula.finance.R;

import java.util.ArrayList;
import java.util.List;

public class ArticleSelectionActivity extends AppCompatActivity {

    ViewPager viewPager;
    CategoryAdapter mCategoryAdapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private static final String TAG = " 2 ARTICLE SELECTION ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_article_selection_viewpager);
        Log.d(TAG,"1 This is the page to scroll through categories");

        models = new ArrayList<>();
        models.add(new Model(R.drawable.ic_piggy_bank, "Savings", "Simplify your personal finance by setting up no-fee accounts, automating savings and bill payments, and investing a little.",1));
        models.add(new Model(R.drawable.ic_super, "Super", "Saving and investing money wisely needn’t be confined to the experts, nor does it need to be a headache. ",2));
        models.add(new Model(R.drawable.ic_investment_pink, "Investment", "Learn to stop stressing about money, sit back and let your funds grow.",3));
        models.add(new Model(R.drawable.ic_credit_card, "Credit Card", "Financial smart tips, how to use credits card wisely and to your advantage",4));
        mCategoryAdapter = new CategoryAdapter(models, this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(mCategoryAdapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.mula_purple_600),
                getResources().getColor(R.color.mula_turqoise_400),
                getResources().getColor(R.color.pink_200),
                getResources().getColor(R.color.mula_yellow_500),
        };

        colors = colors_temp;



        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (mCategoryAdapter.getCount() -1) && position < (colors.length - 1)) {
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

    }
}