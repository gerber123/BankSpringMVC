package com.gerberjava.ownSpring.domain;

import java.time.LocalDateTime;

public class Locate
{
    private int lenghtInSeconds;
    private int reward;
    private String description;
    private int id;
    private boolean started=false;
    private boolean completed = false;
    public LocalDateTime startDate;

    public Locate(int lenghtInSeconds, int reward) {
        this.lenghtInSeconds = lenghtInSeconds;
        this.reward = reward;
    }

    public Locate(int id, String description) {
        this.id=id;
        this.description = description;
    }

    public int getLenghtInSeconds()
    {
        return lenghtInSeconds;
    }


    public void setLenghtInSeconds(int lenghtInSeconds) {
        this.lenghtInSeconds = lenghtInSeconds;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if(started)
        {
            this.startDate=LocalDateTime.now();
        }
        this.started=started;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
