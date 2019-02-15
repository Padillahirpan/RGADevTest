package id.padillah.rgtest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseGift {

    @SerializedName("status")
    private String status ;

    @SerializedName("message")
    private String message ;

    @SerializedName("data")
    private DataGift dataGift;

    @SerializedName("last_update")
    private String last_update;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataGift getDataGift() {
        return dataGift;
    }

    public void setDataGift(DataGift dataGift) {
        this.dataGift = dataGift;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
