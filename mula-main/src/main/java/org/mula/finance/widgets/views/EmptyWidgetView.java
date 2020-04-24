/* Mula */

package org.mula.finance.widgets.views;

import android.content.Context;
import androidx.annotation.NonNull;
import android.widget.TextView;

import org.mula.finance.R;

public class EmptyWidgetView extends HabitWidgetView
{

    private TextView title;

    public EmptyWidgetView(Context context)
    {
        super(context);
        init();
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
        title = (TextView) findViewById(R.id.title);
        title.setVisibility(VISIBLE);
    }
}
