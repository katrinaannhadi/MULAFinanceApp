package org.mula.finance.Models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LineChartViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<String> mText;

    public LineChartViewModel(){
        mText = new MutableLiveData<>();
        mText.setValue("This is a Line Chart Fragment");
    }

    public LiveData<String> getText(){
        return mText;
    }
}
