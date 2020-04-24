package org.mula.finance.activities.article;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.googlejavaformat.Indent;

import org.mula.finance.Models.Article;
import org.mula.finance.R;

public class ArticleFragment extends Fragment {
    private String TAG = "ArticleDetailFragment";

    private Article mArticle;

    public ArticleFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_article, container, false);
        int position = 0;
        int category = 0;
        String categoryMethod;

        Log.d(TAG, "4 THIS IS ARTICLE FRAGMENT");


        //Initialising views
        TextView articleTitle = v.findViewById(R.id.article_title);
        TextView articleCategory = v.findViewById(R.id.article_category);
        TextView articleFull = v.findViewById(R.id.article_full);
        TextView articleSnippet = v.findViewById(R.id.hot_snippet);
        ImageView image = v.findViewById(R.id.imageView);
        ImageView search = v.findViewById(R.id.ivSearch);
        ConstraintLayout layout = v.findViewById(R.id.featured_item);

        Intent intent = getActivity().getIntent();
        position = intent.getIntExtra(ArticleActivity.EXTRA_MESSAGE,0);
        category = intent.getIntExtra("Category", 1);

        Log.d(TAG, "Category is : " + category);

        if(category == 1){
            mArticle = Article.getArticleList1().get(position);
            layout.setBackgroundColor(Color.parseColor("#6663A4"));
        }
        //TODO TURN BACK ON
        if(category == 2){
            mArticle = Article.getArticleList2().get(position);
            layout.setBackgroundColor(Color.parseColor("#03BAB9"));
        }
        if(category == 3){
            mArticle = Article.getArticleList3().get(position);
            layout.setBackgroundColor(Color.parseColor("#F48FB1"));
        }
        if(category == 4){
            mArticle = Article.getArticleList4().get(position);
            layout.setBackgroundColor(Color.parseColor("#FFC000"));
        }


        articleTitle.setText(mArticle.getArticleTitle());
        articleCategory.setText(mArticle.getArticleCategory());
        articleFull.setText(String.valueOf(mArticle.getArticleFull()));
        articleSnippet.setText(mArticle.getArticleSnippet());

        Glide.with(image)
                .load(mArticle.getImageURL())
                .placeholder(R.drawable.image_investment)
                .centerCrop()
                .into(image);
        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                searchRestaurant(mArticle.getArticleTitle(), mArticle.getArticleSnippet());

            }

        });
        return v;
    }
    private void searchRestaurant(String name, String location){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name ));
        startActivity(intent);

    }
    private void setImage(String url, final View view){

    }
}
