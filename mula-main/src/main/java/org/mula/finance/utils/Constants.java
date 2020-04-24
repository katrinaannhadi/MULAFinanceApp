package org.mula.finance.utils;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final String[] categories = { "Groceries", "Utilities", "Rent/Mortgage",
            "Insurance", "Food", "Transport", "Entertainment", "Misc"};

    public static final Map<String, String> colorMap = new HashMap<>();

    static {
        colorMap.put(categories[0], "#023fa5");
        colorMap.put(categories[1], "#b63fa5");
        colorMap.put(categories[2], "#ffb0a5");
        colorMap.put(categories[3], "#50b0a5");
        colorMap.put(categories[4], "#30f6a5");
        colorMap.put(categories[5], "#30f605");
        colorMap.put(categories[6], "#fef605");
        colorMap.put(categories[7], "#fe0305");
    }
}
