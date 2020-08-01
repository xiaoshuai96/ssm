package com.xiaoshuai885.domain;

import java.io.Serializable;
import java.util.Date;

public class userCserviceReplay implements Serializable {
    private Long id;
    private Long nsuserId;
    private String text;
    private Date replayTime;
    private Long lastId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNsuserId() {
        return nsuserId;
    }

    public void setNsuserId(Long nsuserId) {
        this.nsuserId = nsuserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getReplayTime() {
        return replayTime;
    }

    public void setReplayTime(Date replayTime) {
        this.replayTime = replayTime;
    }

    public Long getLastId() {
        return lastId;
    }

    public void setLastId(Long lastId) {
        this.lastId = lastId;
    }

    @Override
    public String toString() {
        return "userCserviceReplay{" +
                "id=" + id +
                ", nsuserId=" + nsuserId +
                ", text='" + text + '\'' +
                ", replayTime=" + replayTime +
                ", lastId=" + lastId +
                '}';
    }
}
