package com.example.scheduleit;

public class EventModel {

    private int id;
    private String schDate;
    private String schTime;
    private Boolean repeat;
    private String email;

    public EventModel(int id, Boolean repeat, String email, String note) {
        this.id = id;
        this.repeat = repeat;
        this.email = email;
        this.note = note;
    }

    private String note;

    @Override
    public String toString() {
        return "EventModel{" +
                "id=" + id +
                ", schDate='" + schDate + '\'' +
                ", schTime='" + schTime + '\'' +
                ", repeat=" + repeat +
                ", email='" + email + '\'' +
                ", note='" + note + '\'' +
                '}';
    }



    public EventModel() {
    }

    public EventModel(int id, String schDate, String schTime, Boolean repeat, String email, String note) {
        this.id = id;
        this.schDate = schDate;
        this.schTime = schTime;
        this.repeat = repeat;
        this.email = email;
        this.note = note;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSchDate(String schDate) {
        this.schDate = schDate;
    }

    public void setSchTime(String schTime) {
        this.schTime = schTime;
    }

    public void setRepeat(Boolean repeat) {
        this.repeat = repeat;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getSchDate() {
        return schDate;
    }

    public String getSchTime() {
        return schTime;
    }

    public Boolean getRepeat() {
        return repeat;
    }

    public String getEmail() {
        return email;
    }

    public String getNote() {
        return note;
    }
}
