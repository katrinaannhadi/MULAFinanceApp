package org.mula.finance.Models;

import android.content.Intent;


import java.util.List;

//class to hold intents to different activities etc
public class IntentLink {



    private String name;
    private Intent intent;
    private int drawable;
    private int colourTint;

    private int quizCategory;

    public IntentLink (String name, Intent intent, int drawable, int colourTint){
        this.name = name;
        this.intent = intent;
        this.drawable = drawable;
        this.colourTint = colourTint;
    }



    public String getLinkName() {
        return name;
    }

    public Intent getLinkIntent() {
        return intent;
    }

    public int getLinkDrawable() {
        return drawable;
    }

    public int getQuizCategory() {
        return quizCategory;
    }

    public void setQuizCategory(int quizCategory) {
        this.quizCategory = quizCategory;
    }

    public int getLinkColourTint() {
        return colourTint;
    }
}
