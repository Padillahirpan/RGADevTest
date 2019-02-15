package id.padillah.rgtest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import id.padillah.rgtest.R;
import id.padillah.rgtest.adapter.GiftListAdapter;
import id.padillah.rgtest.model.Gifts;
import id.padillah.rgtest.model.ResponseGift;
import id.padillah.rgtest.rest.ApiClient;
import id.padillah.rgtest.rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    RecyclerView mRecycleView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = (RecyclerView)findViewById(R.id.recycleviewGift);
        mProgressBar = findViewById(R.id.progressGiftList);

        mLayoutManager = new GridLayoutManager(this,2);
        mRecycleView.setLayoutManager(mLayoutManager);


        // Retrofit to get love list
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseGift> responseDataCall = mApiInterface.getGift();
        responseDataCall.enqueue(new Callback<ResponseGift>() {
            @Override
            public void onResponse(Call<ResponseGift> call, Response<ResponseGift> response) {
                mProgressBar.setVisibility(View.GONE);

                if (response.isSuccessful()) {

                    mRecycleView.setVisibility(View.VISIBLE);
                    List<Gifts> listItem = response.body().getDataGift().getGiftList();
                    mAdapter = new GiftListAdapter(getApplicationContext(), listItem);
                    mRecycleView.setAdapter(mAdapter);

                }else{
                    Log.d("RESPONSE false", new Gson().toJson(response.body()));

                }
            }

            @Override
            public void onFailure(Call<ResponseGift> call, Throwable t) {
                mProgressBar.setVisibility(View.GONE);
                Log.d("On failure","arrrgh "+t);
            }
        });
    }
}
