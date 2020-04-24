package org.mula.finance.Adapters;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import org.mula.finance.Models.Category;
import org.mula.finance.R;

public class CategoryViewHolder extends ChildViewHolder {

    public View view;

    private TextView mTextView;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        view = itemView;
        mTextView = itemView.findViewById(R.id.text_category);
    }

    public void bind(Category category){
        mTextView.setText(category.name);

    }
}
