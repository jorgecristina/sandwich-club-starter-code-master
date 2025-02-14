package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    private Sandwich sandwich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        sandwich = JsonUtils.parseSandwichJson(json);
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI();
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void placeUI(int r1,int r2,String s) {

        TextView tv1 = (TextView) findViewById(r1);
        TextView tv2 = (TextView) findViewById(r2);
        if(s!=null && s.length()> 0)
        {
            tv1.setVisibility(View.VISIBLE);
            tv2.setVisibility(View.VISIBLE);
            tv2.setText(s);
        }
        else
        {
            tv1.setVisibility(View.GONE);
            tv2.setVisibility(View.GONE);
        }
    }
    private void populateUI() {

        placeUI(R.id._also_known_as_tv,R.id.also_known_tv,sandwich.getAlsoKnownAs().toString());
        placeUI(R.id._ingredients_tv,R.id.ingredients_tv,sandwich.getIngredients().toString());
        placeUI(R.id._origin_tv,R.id.origin_tv,sandwich.getPlaceOfOrigin());
        placeUI(R.id._description_tv,R.id.description_tv,sandwich.getDescription());

    }
}
