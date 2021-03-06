package com.uoit.calvin.mytodo;
import android.util.Log;

import java.util.Date;

public class Task implements Comparable<Task> {

    private long id;
    private String title;
    private boolean selected = false;
    private String timestamp;
    private double latitude;
    private double longitude;
    private Weather weather;
    private boolean hidden;
    private boolean completed;
    private String dueTimestamp;
    private Date endDate;
    private String details;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tag) {
        this.title = tag;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return title;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDueTimestamp() {
        return dueTimestamp;
    }

    public void setDueTimestamp(String dueTimestamp) {
        this.dueTimestamp = dueTimestamp;
        if (dueTimestamp.length() > 0) {
            this.endDate = new Helper().convertDate(dueTimestamp);
            Log.i("MYDATE", endDate.toString());
        } else {
            this.endDate = null;
        }
    }

    private Date getEndDate() {
        return this.endDate;
    }

    @Override
    public int compareTo(Task t) {
        if (getEndDate() == null || t.getEndDate() == null) {
            return 0;
        }
        return getEndDate().compareTo(t.getEndDate());
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
