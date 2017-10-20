
package com.example.myapplication.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Venue implements Parcelable {

    @SerializedName("extended_address")
    @Expose
    private String extendedAddress;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("has_upcoming_events")
    @Expose
    private Boolean hasUpcomingEvents;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name_v2")
    @Expose
    private String nameV2;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("num_upcoming_events")
    @Expose
    private Integer numUpcomingEvents;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("display_location")
    @Expose
    private String displayLocation;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;

    public String getExtendedAddress() {
        return extendedAddress;
    }

    public void setExtendedAddress(String extendedAddress) {
        this.extendedAddress = extendedAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getHasUpcomingEvents() {
        return hasUpcomingEvents;
    }

    public void setHasUpcomingEvents(Boolean hasUpcomingEvents) {
        this.hasUpcomingEvents = hasUpcomingEvents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameV2() {
        return nameV2;
    }

    public void setNameV2(String nameV2) {
        this.nameV2 = nameV2;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getNumUpcomingEvents() {
        return numUpcomingEvents;
    }

    public void setNumUpcomingEvents(Integer numUpcomingEvents) {
        this.numUpcomingEvents = numUpcomingEvents;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(String displayLocation) {
        this.displayLocation = displayLocation;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    protected Venue(Parcel in) {
        extendedAddress = in.readString();
        city = in.readString();
        byte hasUpcomingEventsVal = in.readByte();
        hasUpcomingEvents = hasUpcomingEventsVal == 0x02 ? null : hasUpcomingEventsVal != 0x00;
        name = in.readString();
        id = in.readByte() == 0x00 ? null : in.readInt();
        nameV2 = in.readString();
        timezone = in.readString();
        url = in.readString();
        score = in.readByte() == 0x00 ? null : in.readDouble();
        if (in.readByte() == 0x01) {
            links = new ArrayList<Object>();
            in.readList(links, Object.class.getClassLoader());
        } else {
            links = null;
        }
        country = in.readString();
        location = (Location) in.readValue(Location.class.getClassLoader());
        address = in.readString();
        state = in.readString();
        slug = in.readString();
        numUpcomingEvents = in.readByte() == 0x00 ? null : in.readInt();
        popularity = in.readByte() == 0x00 ? null : in.readDouble();
        displayLocation = in.readString();
        postalCode = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(extendedAddress);
        dest.writeString(city);
        if (hasUpcomingEvents == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (hasUpcomingEvents ? 0x01 : 0x00));
        }
        dest.writeString(name);
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id);
        }
        dest.writeString(nameV2);
        dest.writeString(timezone);
        dest.writeString(url);
        if (score == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(score);
        }
        if (links == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(links);
        }
        dest.writeString(country);
        dest.writeValue(location);
        dest.writeString(address);
        dest.writeString(state);
        dest.writeString(slug);
        if (numUpcomingEvents == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(numUpcomingEvents);
        }
        if (popularity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(popularity);
        }
        dest.writeString(displayLocation);
        dest.writeString(postalCode);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Venue> CREATOR = new Parcelable.Creator<Venue>() {
        @Override
        public Venue createFromParcel(Parcel in) {
            return new Venue(in);
        }

        @Override
        public Venue[] newArray(int size) {
            return new Venue[size];
        }
    };
}
