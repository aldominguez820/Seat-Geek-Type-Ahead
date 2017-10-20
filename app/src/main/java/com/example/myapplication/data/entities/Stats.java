
package com.example.myapplication.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stats implements Parcelable {

    @SerializedName("lowest_price_good_deals")
    @Expose
    private Object lowestPriceGoodDeals;
    @SerializedName("lowest_price")
    @Expose
    private Object lowestPrice;
    @SerializedName("highest_price")
    @Expose
    private Object highestPrice;
    @SerializedName("average_price")
    @Expose
    private Object averagePrice;
    @SerializedName("listing_count")
    @Expose
    private Integer listingCount;

    public Object getLowestPriceGoodDeals() {
        return lowestPriceGoodDeals;
    }

    public void setLowestPriceGoodDeals(Object lowestPriceGoodDeals) {
        this.lowestPriceGoodDeals = lowestPriceGoodDeals;
    }

    public Object getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Object lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public Object getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(Object highestPrice) {
        this.highestPrice = highestPrice;
    }

    public Object getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Object averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Integer getListingCount() {
        return listingCount;
    }

    public void setListingCount(Integer listingCount) {
        this.listingCount = listingCount;
    }


    protected Stats(Parcel in) {
        lowestPriceGoodDeals = (Object) in.readValue(Object.class.getClassLoader());
        lowestPrice = (Object) in.readValue(Object.class.getClassLoader());
        highestPrice = (Object) in.readValue(Object.class.getClassLoader());
        averagePrice = (Object) in.readValue(Object.class.getClassLoader());
        listingCount = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(lowestPriceGoodDeals);
        dest.writeValue(lowestPrice);
        dest.writeValue(highestPrice);
        dest.writeValue(averagePrice);
        if (listingCount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(listingCount);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Stats> CREATOR = new Parcelable.Creator<Stats>() {
        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };
}