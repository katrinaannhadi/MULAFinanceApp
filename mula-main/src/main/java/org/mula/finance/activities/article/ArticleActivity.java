package org.mula.finance.activities.article;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.mula.finance.Adapters.ArticleAdapter;
import org.mula.finance.Models.Article;
import org.mula.finance.R;

import java.util.ArrayList;

public class ArticleActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.mula.finance.MESSAGE";
    private static final String TAG = " 3 ARTICLE ACTIVITY ";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private int articleCategory = 0;
    private int articleArrayListSize = 0;
    private TextView categoryHeader;

    // Set the ArrayLists
    ArrayList<Integer> articleCategoryList = new ArrayList<Integer>();
    private ArrayList<Article> mArticles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        mRecyclerView = findViewById(R.id.rvList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        categoryHeader = findViewById(R.id.category_header);

        Intent intent = getIntent();
        articleCategory = intent.getIntExtra("Category", 1);
        Log.d(TAG, "Category is: " + articleCategory);
        categoryHeader = findViewById(R.id.category_header);
        ConstraintLayout layout = findViewById(R.id.root);


        // Setting up what the intent number is and setting the appropriate flashcard deck
        if (articleCategory == 1) {
            articleArrayListSize = Article.getArticleList1().size();
            categoryHeader.setText("Savings");
            layout.setBackgroundColor(Color.parseColor("#6663A4"));
            ArticleAdapter.RecyclerViewClickListener listener = new ArticleAdapter.RecyclerViewClickListener() {
                @Override
                public void onClick(View view, int position) {
                    launchDetailActivity(position, articleCategory);
                }
            };
            mArticles = Article.getArticleList1();
            mAdapter = new ArticleAdapter(mArticles, listener);
            mRecyclerView.setAdapter(mAdapter);
        }
        else if (articleCategory == 2) {
            articleArrayListSize = Article.getArticleList2().size();
            categoryHeader.setText("Super");
            layout.setBackgroundColor(Color.parseColor("#03BAB9"));
            ArticleAdapter.RecyclerViewClickListener listener = new ArticleAdapter.RecyclerViewClickListener() {
                @Override
                public void onClick(View view, int position) {
                    launchDetailActivity(position, articleCategory);
                }
            };
            mArticles = Article.getArticleList2();
            mAdapter = new ArticleAdapter(mArticles, listener);
            mRecyclerView.setAdapter(mAdapter);

        } else if (articleCategory == 3) {
            articleArrayListSize = Article.getArticleList3().size();
            categoryHeader.setText("Investment");
            layout.setBackgroundColor(Color.parseColor("#F48FB1"));
            ArticleAdapter.RecyclerViewClickListener listener = new ArticleAdapter.RecyclerViewClickListener() {
                @Override
                public void onClick(View view, int position) {
                    launchDetailActivity(position, articleCategory);
                }
            };
            mArticles = Article.getArticleList3();
            mAdapter = new ArticleAdapter(mArticles, listener);
            mRecyclerView.setAdapter(mAdapter);

        } else if (articleCategory == 4) {
            articleArrayListSize = Article.getArticleList4().size();
            categoryHeader.setText("Credit Card");
            layout.setBackgroundColor(Color.parseColor("#FFC000"));
            ArticleAdapter.RecyclerViewClickListener listener = new ArticleAdapter.RecyclerViewClickListener() {
                @Override
                public void onClick(View view, int position) {
                    launchDetailActivity(position, articleCategory);
                }
            };
            mArticles = Article.getArticleList4();
            mAdapter = new ArticleAdapter(mArticles, listener);
            mRecyclerView.setAdapter(mAdapter);


        }

    }


    private void launchDetailActivity ( int position, int ArticleCategory){
        Intent intent = new Intent(this, ArticleDetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        intent.putExtra("Category", ArticleCategory);
        startActivity(intent);
    }





}

