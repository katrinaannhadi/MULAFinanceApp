/* Mula */

package org.mula.finance.activities.habits.edit.views;

import android.content.*;
import android.text.*;
import android.util.*;
import android.view.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import org.mula.finance.*;
import org.mula.androidbase.utils.StyledResources;

import static org.mula.finance.utils.AttributeSetUtils.*;

/**
 * An EditText that shows an example usage when there is no text
 * currently set. The example disappears when the widget gains focus.
 */
public class ExampleEditText extends AppCompatEditText
    implements View.OnFocusChangeListener
{

    private String example;

    private String realText;

    private int color;

    private int exampleColor;

    private int inputType;

    public ExampleEditText(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);

        if (attrs != null)
            example = getAttribute(context, attrs, "example", "");

        inputType = getInputType();
        realText = getText().toString();
        color = getCurrentTextColor();
        init();
    }

    public String getRealText()
    {
        if(hasFocus()) return getText().toString();
        else return realText;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus)
    {
        if (!hasFocus) realText = getText().toString();
        updateText();
    }

    public void setExample(String example)
    {
        this.example = example;
        updateText();
    }

    public void setRealText(@NonNull String realText)
    {
        this.realText = realText;
        updateText();
    }

    private void init()
    {
        StyledResources sr = new StyledResources(getContext());
        exampleColor = sr.getColor(R.attr.mediumContrastTextColor);
        setOnFocusChangeListener(this);
        updateText();
    }

    private void updateText()
    {
        if (realText.isEmpty() && !isFocused())
        {
            setTextColor(exampleColor);
            setText(example);
            setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        }
        else
        {
            setText(realText);
            setTextColor(color);
            setInputType(inputType);
        }

    }
}
