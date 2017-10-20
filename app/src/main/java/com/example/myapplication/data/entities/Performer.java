
package com.example.myapplication.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Performer implements Parcelable {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("primary")
    @Expose
    private Boolean primary;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("home_venue_id")
    @Expose
    private Object homeVenueId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("has_upcoming_events")
    @Expose
    private Boolean hasUpcomingEvents;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("num_upcoming_events")
    @Expose
    private Integer numUpcomingEvents;
    @SerializedName("taxonomies")
    @Expose
    private List<Taxonomy> taxonomies = null;
    @SerializedName("divisions")
    @Expose
    private Object divisions;
    @SerializedName("image_license")
    @Expose
    private Object imageLicense;
    @SerializedName("stats")
    @Expose
    private StatsCounter stats;
    @SerializedName("colors")
    @Expose
    private Object colors;
    @SerializedName("image_attribution")
    @Expose
    private String imageAttribution;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getHomeVenueId() {
        return homeVenueId;
    }

    public void setHomeVenueId(Object homeVenueId) {
        this.homeVenueId = homeVenueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Boolean getHasUpcomingEvents() {
        return hasUpcomingEvents;
    }

    public void setHasUpcomingEvents(Boolean hasUpcomingEvents) {
        this.hasUpcomingEvents = hasUpcomingEvents;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getNumUpcomingEvents() {
        return numUpcomingEvents;
    }

    public void setNumUpcomingEvents(Integer numUpcomingEvents) {
        this.numUpcomingEvents = numUpcomingEvents;
    }

    public List<Taxonomy> getTaxonomies() {
        return taxonomies;
    }

    public void setTaxonomies(List<Taxonomy> taxonomies) {
        this.taxonomies = taxonomies;
    }

    public Object getDivisions() {
        return divisions;
    }

    public void setDivisions(Object divisions) {
        this.divisions = divisions;
    }

    public Object getImageLicense() {
        return imageLicense;
    }

    public void setImageLicense(Object imageLicense) {
        this.imageLicense = imageLicense;
    }

    public StatsCounter getStats() {
        return stats;
    }

    public void setStats(StatsCounter stats) {
        this.stats = stats;
    }

    public Object getColors() {
        return colors;
    }

    public void setColors(Object colors) {
        this.colors = colors;
    }

    public String getImageAttribution() {
        return imageAttribution;
    }

    public void setImageAttribution(String imageAttribution) {
        this.imageAttribution = imageAttribution;
    }


    protected Performer(Parcel in) {
        url = in.readString();
        shortName = in.readString();
        byte primaryVal = in.readByte();
        primary = primaryVal == 0x02 ? null : primaryVal != 0x00;
        images = (Images) in.readValue(Images.class.getClassLoader());
        image = in.readString();
        homeVenueId = (Object) in.readValue(Object.class.getClassLoader());
        name = in.readString();
        popularity = in.readByte() == 0x00 ? null : in.readDouble();
        byte hasUpcomingEventsVal = in.readByte();
        hasUpcomingEvents = hasUpcomingEventsVal == 0x02 ? null : hasUpcomingEventsVal != 0x00;
        slug = in.readString();
        type = in.readString();
        id = in.readByte() == 0x00 ? null : in.readInt();
        score = in.readByte() == 0x00 ? null : in.readDouble();
        numUpcomingEvents = in.readByte() == 0x00 ? null : in.readInt();
        if (in.readByte() == 0x01) {
            taxonomies = new ArrayList<Taxonomy>();
            in.readList(taxonomies, Taxonomy.class.getClassLoader());
        } else {
            taxonomies = null;
        }
        divisions = (Object) in.readValue(Object.class.getClassLoader());
        imageLicense = (Object) in.readValue(Object.class.getClassLoader());
        stats = (StatsCounter) in.readValue(StatsCounter.class.getClassLoader());
        colors = (Object) in.readValue(Object.class.getClassLoader());
        imageAttribution = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(shortName);
        if (primary == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (primary ? 0x01 : 0x00));
        }
        dest.writeValue(images);
        dest.writeString(image);
        dest.writeValue(homeVenueId);
        dest.writeString(name);
        if (popularity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(popularity);
        }
        if (hasUpcomingEvents == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (hasUpcomingEvents ? 0x01 : 0x00));
        }
        dest.writeString(slug);
        dest.writeString(type);
        if (id == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(id);
        }
        if (score == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(score);
        }
        if (numUpcomingEvents == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(numUpcomingEvents);
        }
        if (taxonomies == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(taxonomies);
        }
        dest.writeValue(divisions);
        dest.writeValue(imageLicense);
        dest.writeValue(stats);
        dest.writeValue(colors);
        dest.writeString(imageAttribution);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Performer> CREATOR = new Parcelable.Creator<Performer>() {
        @Override
        public Performer createFromParcel(Parcel in) {
            return new Performer(in);
        }

        @Override
        public Performer[] newArray(int size) {
            return new Performer[size];
        }
    };
}
