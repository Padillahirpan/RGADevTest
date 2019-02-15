package id.padillah.rgtest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataGift {

    @SerializedName("gifts")
    private List<Gifts> giftList;

    @SerializedName("gift")
    private Gift gift;

    public List<Gifts> getGiftList() {
        return giftList;
    }

    public void setGiftList(List<Gifts> giftList) {
        this.giftList = giftList;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }
}
