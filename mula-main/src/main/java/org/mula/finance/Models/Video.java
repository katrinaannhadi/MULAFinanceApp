package org.mula.finance.Models;


import android.content.Intent;

//class to place stuff for video
public class Video {

    private int id;
    private String channelName;
    private String playlistName;
    private int image;
    private Intent intent;

    public Video(int id, String channelName, String playlistName, int image, Intent intent) {
        this.id = id;
        this.channelName = channelName;
        this.playlistName = playlistName;
        this.image = image;
        this.intent = intent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
