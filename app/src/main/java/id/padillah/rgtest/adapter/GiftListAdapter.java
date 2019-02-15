package id.padillah.rgtest.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.padillah.rgtest.R;
import id.padillah.rgtest.activity.GiftActivity;
import id.padillah.rgtest.model.Gifts;

public class GiftListAdapter extends RecyclerView.Adapter<GiftListAdapter.GiftListHolder> {

    List<Gifts> gifts;
    public Context context;

    public GiftListAdapter(Context context, List<Gifts> gifts) {
        this.gifts = gifts;
        this.context = context;
    }

    @NonNull
    @Override
    public GiftListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_gift_view,parent, false);
        GiftListAdapter.GiftListHolder mLoveListHolder = new GiftListAdapter.GiftListHolder(mView);

        return mLoveListHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GiftListHolder holder, final int position) {
        holder.giftName.setText(gifts.get(position).getName());

        holder.giftPoint.setText(gifts.get(position).getPoints()+" points");
        holder.giftReview.setText(gifts.get(position).getNum_reviews()+ " reviews");
        holder.giftRatingBar.setRating(gifts.get(position).getRating());
        Glide.with(context).load(gifts.get(position).getImage()).into(holder.giftImage);
//        holder.itemPrice.setText("Rp "+gifts.get(position).getPrice().toString());
        if (gifts.get(position).getIsNew() == 1) {
            holder.giftStatus.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GiftActivity.class);
                Log.d("slug list ada", gifts.get(position).getSlug());
                intent.putExtra("slug", gifts.get(position).getSlug());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return gifts.size();
    }

    public class GiftListHolder extends RecyclerView.ViewHolder {
        public TextView  giftName, giftReview, giftPoint;
        public ImageView giftLove, giftImage, giftStatus;
        public RatingBar giftRatingBar;


        Typeface customTypeface = Typeface.createFromAsset(itemView.getContext().getAssets(),"fonts/Raleway-SemiBold.ttf");

        public GiftListHolder(View itemView) {
            super(itemView);

            giftName = (TextView)itemView.findViewById(R.id.giftName);
            giftName.setTypeface(customTypeface);
            giftReview = (TextView)itemView.findViewById(R.id.giftReview);
            giftPoint = (TextView)itemView.findViewById(R.id.giftPoint);
//            giftLove = (ImageView)itemView.findViewById(R.id.giftLove);
            giftImage = (ImageView)itemView.findViewById(R.id.giftImage);
            giftRatingBar = (RatingBar)itemView.findViewById(R.id.giftRating);
            giftStatus = (ImageView)itemView.findViewById(R.id.giftStatus);
        }
    }
}
