package org.mula.finance.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.mula.finance.Models.Article;
import org.mula.finance.R;

import java.util.ArrayList;


public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private ArrayList<Article> mArticles;
    private RecyclerViewClickListener mListener;
    private static final String TAG = " 3 ARTICLE ADAPTER ";
    public static final int PERMISSION_WRITE = 0;
    Context context;


    public ArticleAdapter(ArrayList<Article> articles, RecyclerViewClickListener listener) {
        mArticles = articles;
        mListener = listener;
        this.context = context;

    }


    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView articleTitle, articleSnippet;
        public ImageView articleImage, download;
        private RecyclerViewClickListener mListener;


        public ArticleViewHolder(View v, RecyclerViewClickListener listener) {
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            articleTitle = v.findViewById(R.id.article_title);
//            articleSnippet = v.findViewById(R.id.article_snippet);
            articleImage = v.findViewById(R.id.article_image);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_list_row, parent, false);
        return new ArticleViewHolder(v, mListener);
    }


    //Replace the contents of a view (invoked by the layout manager
    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position){

        Article article = mArticles.get(position);
        Glide.with(holder.articleImage)
                .load(article.getImageURL())
                .placeholder(R.drawable.image_investment)
                .centerCrop()
                .into(holder.articleImage);

        holder.articleTitle.setText(article.getArticleTitle());


    }
    //Return the size of our dataset
    @Override
    public int getItemCount() {
        return mArticles.size();
    }
}


