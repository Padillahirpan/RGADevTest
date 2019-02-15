package id.padillah.rgtest.model;

import com.google.gson.annotations.SerializedName;

public class Gift {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("info")
    private String info;

    @SerializedName("description")
    private String description;

    @SerializedName("points")
    private String points;

    @SerializedName("stock")
    private String stock;

    @SerializedName("images")
    private String image[];

    @SerializedName("isNew")
    private int isNew;

    @SerializedName("slug")
    private String slug;

    @SerializedName("rating")
    private float rating;

    @SerializedName("num_reviews")
    private String num_reviews;

    @SerializedName("lastUpdate")
    private String lastUpdate;

    @SerializedName("isDeleted")
    private String isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String[] getImage() {
        return image;
    }

    public void setImage(String[] image) {
        this.image = image;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getNum_reviews() {
        return num_reviews;
    }

    public void setNum_reviews(String num_reviews) {
        this.num_reviews = num_reviews;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}
