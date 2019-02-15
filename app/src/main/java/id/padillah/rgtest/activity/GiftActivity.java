package id.padillah.rgtest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import id.padillah.rgtest.R;
import id.padillah.rgtest.model.Gift;
import id.padillah.rgtest.model.Gifts;
import id.padillah.rgtest.model.ResponseGift;
import id.padillah.rgtest.rest.ApiClient;
import id.padillah.rgtest.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GiftActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    String slug;
    int stock;
    Gift dataGift;

    TextView giftName, giftInfo, giftReview, giftPoints, giftDescription, giftSubName, textStock;
    ImageView giftImage, giftStatus, giftAddToChart;
    RatingBar ratingBar;
    Button btnMinus, btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift);

        giftName = (TextView)findViewById(R.id.giftNameDetail);
        giftDescription = (TextView)findViewById(R.id.giftDescriptionDetail);
        giftPoints = (TextView)findViewById(R.id.jmlPoint);
        giftReview = (TextView)findViewById(R.id.giftReviewDetail);
        giftSubName = (TextView)findViewById(R.id.giftSubName);
        giftImage = (ImageView)findViewById(R.id.giftImageDetail);
        giftStatus = (ImageView)findViewById(R.id.giftStatus);
        ratingBar = (RatingBar)findViewById(R.id.giftRating);
        btnMinus = (Button)findViewById(R.id.btnMinus);
        btnPlus = (Button)findViewById(R.id.btnPlus);
        textStock = (TextView)findViewById(R.id.valueStock);

        Intent intent = getIntent();
        slug = intent.getStringExtra("slug");

        textStock.setText(Integer.toString(stock));

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStock(1);

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStock(0);
            }
        });


        if (slug != null) {
            // Retrofit to get gift list
            mApiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<ResponseGift> responseDataCall = mApiInterface.getGiftBySlug(slug);
            responseDataCall.enqueue(new Callback<ResponseGift>() {
                @Override
                public void onResponse(Call<ResponseGift> call, Response<ResponseGift> response) {
                    Log.d("url","gift "+response.raw().request().url());
                    if (response.isSuccessful()) {

                        dataGift = response.body().getDataGift().getGift();

                        giftName.setText(dataGift.getName());
                        giftDescription.setText(Html.fromHtml(dataGift.getDescription()).toString());
                        giftReview.setText(dataGift.getNum_reviews()+" reviews");
                        giftPoints.setText(dataGift.getPoints());
                        giftSubName.setText(Html.fromHtml(dataGift.getInfo()));
                        ratingBar.setRating(dataGift.getRating());
                        Glide.with(getApplication()).load(dataGift.getImage()[0]).into(giftImage);

                        if (dataGift.getIsNew() == 1) {
                            giftStatus.setVisibility(View.VISIBLE);
                        }

                    }else{
                        Log.d("RESPONSE false", new Gson().toJson(response.body()));

                    }
                }

                @Override
                public void onFailure(Call<ResponseGift> call, Throwable t) {
                    Log.d("On failure","arrrgh "+t);
                }
            });

        } else {
            Log.d("Params null","true");
        }

    }

    public void buttonStock(int typeBtn){

        if (typeBtn == 0) {
            if (stock != 0) {
                stock = stock - 1;
            }
        } else {
            stock = stock + 1;
        }

        textStock.setText(Integer.toString(stock));
    }

}
