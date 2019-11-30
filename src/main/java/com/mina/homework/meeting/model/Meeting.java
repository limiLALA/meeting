package com.mina.homework.meeting.model;

public class Meeting {
    int id;
    int room_id;
    int booker_id;
    String theme;
    int scale;
    String book_time;
    String start_time;
    String end_time;

    public Meeting(int room_id, int booker_id, String theme, int scale, String book_time, String start_time, String end_time) {
        this.room_id = room_id;
        this.booker_id = booker_id;
        this.theme = theme;
        this.scale = scale;
        this.book_time = book_time;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public Meeting() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getBooker_id() {
        return booker_id;
    }

    public void setBooker_id(int booker_id) {
        this.booker_id = booker_id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getBook_time() {
        return book_time;
    }

    public void setBook_time(String book_time) {
        this.book_time = book_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
