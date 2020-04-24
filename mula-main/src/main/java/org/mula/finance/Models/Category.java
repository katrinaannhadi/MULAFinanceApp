package org.mula.finance.Models;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class Category implements Parcelable {
    public final String name;
    private int category;
    private Intent intent;

    public Category(String name, int category, Intent intent) {
        this.name = name;
        this.category = category;
        this.intent = intent;
    }

    protected Category(Parcel in) {
        name = in.readString();
        category = in.readInt();
        intent = in.readParcelable(Intent.class.getClassLoader());
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(name);
    }

    public int getCategory() {
        return category;
    }

    public void setIntent(Intent intent){
        this.intent = intent;
    }

    public Intent getCategoryIntent(){
        return this.intent;
    }

}
