package org.mula.finance.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Expense {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "date")
    public Long date;

    @ColumnInfo(name = "category")
    public String category;

    @ColumnInfo(name = "value")
    public String value;

    @ColumnInfo(name = "description")
    public String description;

}
