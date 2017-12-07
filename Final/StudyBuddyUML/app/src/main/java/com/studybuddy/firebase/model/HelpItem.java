package com.studybuddy.firebase.model;

import java.sql.Timestamp;

/**
 * Created by srangan on 12/2/2017.
 */

public class HelpItem {

    private User user;
    private String className;
    private String additionalInformation;
    private Long postTime;

    public HelpItem() {
        this.user = new User();
        this.postTime = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public HelpItem(final String className, final String additionalInformation) {
        this.user = new User();
        this.postTime = new Timestamp(System.currentTimeMillis()).getTime();
        this.className = className;
        this.additionalInformation = additionalInformation;
    }

    public User getUser() {
        return user;
    }

    public HelpItem setUser(final User user) {
        this.user = user;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public HelpItem setClassName(final String className) {
        this.className = className;
        return this;
   }

    public String getAdditionalInformation() {
        return additionalInformation;
   }

    public HelpItem setAdditionalInformation(final String additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
   }

    public Long getPostTime() {
        return postTime;
    }

    public HelpItem setPostTime(final Long postTime) {
        this.postTime = postTime;
        return this;
    }
}
