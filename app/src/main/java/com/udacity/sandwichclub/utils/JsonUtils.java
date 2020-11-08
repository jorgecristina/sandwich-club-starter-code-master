package com.udacity.sandwichclub.utils;

import com.google.gson.Gson;
import com.udacity.sandwichclub.model.Sandwich;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Gson gson = new Gson();
        Sandwich sandwich = gson.fromJson(json, Sandwich.class);
        return sandwich;
    }
}
