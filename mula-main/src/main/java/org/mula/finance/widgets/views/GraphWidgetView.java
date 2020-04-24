/* Mula */

package org.mula.finance.widgets.views;

import android.content.*;
import android.view.*;
import android.widget.*;

import androidx.annotation.NonNull;

import org.mula.finance.*;

public class GraphWidgetView extends HabitWidgetView
{

    private final View dataView;

    private TextView title;

    public GraphWidgetView(Context context, View dataView)
    {
        super(context);
        this.dataView = dataView;
        init();
    }

    public View getDataView()
    {
        return dataView;
    }

    public void setTitle(String text)
    {
        title.setText(text);
    }

    @Override
    @NonNull
    protected Integer getInnerLayoutId()
    {
        return R.layout.widget_graph;
    }

    private void init()
    {
        ViewGroup.LayoutParams params =
            new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        dataView.setLayoutParams(params);

        ViewGroup innerFrame = (ViewGroup) findViewById(R.id.innerFrame);
        innerFrame.addView(dataView);

        title = (TextView) findViewById(R.id.title);
        title.setVisibility(VISIBLE);
    }
}
