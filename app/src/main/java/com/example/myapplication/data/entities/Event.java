
package com.example.myapplication.data.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Event implements Parcelable {

    @SerializedName("time_tbd")
    @Expose
    private Boolean timeTbd;
    @SerializedName("date_tbd")
    @Expose
    private Boolean dateTbd;
    @SerializedName("visible_until_utc")
    @Expose
    private String visibleUntilUtc;
    @SerializedName("taxonomies")
    @Expose
    private List<Taxonomy> taxonomies = null;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("links")
    @Expose
    private List<Object> links = null;
    @SerializedName("short_title")
    @Expose
    private String shortTitle;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("datetime_local")
    @Expose
    private String datetimeLocal;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("datetime_utc")
    @Expose
    private String datetimeUtc;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("is_open")
    @Expose
    private Boolean isOpen;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("performers")
    @Expose
    private List<Performer> performers = null;
    @SerializedName("datetime_tbd")
    @Expose
    private Boolean datetimeTbd;
    @SerializedName("announce_date")
    @Expose
    private String announceDate;
    @SerializedName("title")
    @Expose
    private String title;

    public Boolean getTimeTbd() {
        return timeTbd;
    }

    public void setTimeTbd(Boolean timeTbd) {
        this.timeTbd = timeTbd;
    }

    public Boolean getDateTbd() {
        return dateTbd;
    }

    public void setDateTbd(Boolean dateTbd) {
        this.dateTbd = dateTbd;
    }

    public String getVisibleUntilUtc() {
        return visibleUntilUtc;
    }

    public void setVisibleUntilUtc(String visibleUntilUtc) {
        this.visibleUntilUtc = visibleUntilUtc;
    }

    public List<Taxonomy> getTaxonomies() {
        return taxonomies;
    }

    public void setTaxonomies(List<Taxonomy> taxonomies) {
        this.taxonomies = taxonomies;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Object> getLinks() {
        return links;
    }

    public void setLinks(List<Object> links) {
        this.links = links;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatetimeLocal() {
        return datetimeLocal;
    }

    public void setDatetimeLocal(String datetimeLocal) {
        this.datetimeLocal = datetimeLocal;
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

    public String getDatetimeUtc() {
        return datetimeUtc;
    }

    public void setDatetimeUtc(String datetimeUtc) {
        this.datetimeUtc = datetimeUtc;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<Performer> getPerformers() {
        return performers;
    }

    public void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    public Boolean getDatetimeTbd() {
        return datetimeTbd;
    }

    public void setDatetimeTbd(Boolean datetimeTbd) {
        this.datetimeTbd = datetimeTbd;
    }

    public String getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(String announceDate) {
        this.announceDate = announceDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    protected Event(Parcel in) {
        byte timeTbdVal = in.readByte();
        timeTbd = timeTbdVal == 0x02 ? null : timeTbdVal != 0x00;
        byte dateTbdVal = in.readByte();
        dateTbd = dateTbdVal == 0x02 ? null : dateTbdVal != 0x00;
        visibleUntilUtc = in.readString();
        if (in.readByte() == 0x01) {
            taxonomies = new ArrayList<Taxonomy>();
            in.readList(taxonomies, Taxonomy.class.getClassLoader());
        } else {
            taxonomies = null;
        }
        url = in.readString();
        if (in.readByte() == 0x01) {
            links = new ArrayList<Object>();
            in.readList(links, Object.class.getClassLoader());
        } else {
            links = null;
        }
        shortTitle = in.readString();
        type = in.readString();
        datetimeLocal = in.readString();
        id = in.readByte() == 0x00 ? null : in.readInt();
        score = in.readByte() == 0x00 ? null : in.readDouble();
        datetimeUtc = in.readString();
        createdAt = in.readString();
        venue = (Venue) in.readValue(Venue.class.getClassLoader());
        popularity = in.readByte() == 0x00 ? null : in.readDouble();
        byte isOpenVal = in.readByte();
        isOpen = isOpenVal == 0x02 ? null : isOpenVal != 0x00;
        stats = (Stats) in.readValue(Stats.class.getClassLoader());
        if (in.readByte() == 0x01) {
            performers = new ArrayList<Performer>();
            in.readList(performers, Performer.class.getClassLoader());
        } else {
            performers = null;
        }
        byte datetimeTbdVal = in.readByte();
        datetimeTbd = datetimeTbdVal == 0x02 ? null : datetimeTbdVal != 0x00;
        announceDate = in.readString();
        title = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (timeTbd == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (timeTbd ? 0x01 : 0x00));
        }
        if (dateTbd == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (dateTbd ? 0x01 : 0x00));
        }
        dest.writeString(visibleUntilUtc);
        if (taxonomies == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(taxonomies);
        }
        dest.writeString(url);
        if (links == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(links);
        }
        dest.writeString(shortTitle);
        dest.writeString(type);
        dest.writeString(datetimeLocal);
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
        dest.writeString(datetimeUtc);
        dest.writeString(createdAt);
        dest.writeValue(venue);
        if (popularity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(popularity);
        }
        if (isOpen == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (isOpen ? 0x01 : 0x00));
        }
        dest.writeValue(stats);
        if (performers == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(performers);
        }
        if (datetimeTbd == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (datetimeTbd ? 0x01 : 0x00));
        }
        dest.writeString(announceDate);
        dest.writeString(title);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", datetimeUtc='" + datetimeUtc + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
