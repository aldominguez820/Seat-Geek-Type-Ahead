
package com.example.myapplication.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatsCounter implements Parcelable {

    @SerializedName("event_count")
    @Expose
    private Integer eventCount;

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }


    protected StatsCounter(Parcel in) {
        eventCount = in.readByte() == 0x00 ? null : in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (eventCount == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(eventCount);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<StatsCounter> CREATOR = new Parcelable.Creator<StatsCounter>() {
        @Override
        public StatsCounter createFromParcel(Parcel in) {
            return new StatsCounter(in);
        }

        @Override
        public StatsCounter[] newArray(int size) {
            return new StatsCounter[size];
        }
    };
}
