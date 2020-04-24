package org.mula.finance.Models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PieChartViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PieChartViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Tap the pie chart for values");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
