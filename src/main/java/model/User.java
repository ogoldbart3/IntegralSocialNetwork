package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private String name;
    private List<User> following;
    private List<Yell> yells;

    public User(String name) {
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private List<User> getFollowing() {
        return following;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    private List<Yell> getYells() {
        return yells;
    }

    private void setYells(List<Yell> yells) {
        this.yells = yells;
    }

    public void postYell(String yellText) {
        if (yells == null) {
            yells = new ArrayList<>();
        }

//        note: passing around username as id, but in prod, these would be
//         ids and all functional calls would involve DB lookups

        if (yellText != null && !yellText.isEmpty()) {
            yells.add(new Yell(name, yellText));
        }
    }

    public List<Yell> getPersonalTimeline() {
        List<Yell> timeline = getYells();
        if (timeline != null) {
            // default sorting would be ascending, we need descending
            timeline.sort(Collections.reverseOrder());
        }
        return timeline;
    }

    public List<Yell> getTimelineByUser(User user) {
        if (user == null) {
            return null;
        }

        return user.getPersonalTimeline();
    }

    public List<Yell> getTimelineAllFollowing() {
        if (following == null) {
            return null;
        }

        List<Yell> collectedTimeline = new ArrayList<>();

        // adding user's followed's posts
        for (User followed : following) {
            collectedTimeline.addAll(followed.getPersonalTimeline());
        }

        // adding user's personal posts
        if (yells != null) {
            collectedTimeline.addAll(yells);
        }

        // collective final sort
        collectedTimeline.sort(Collections.reverseOrder());

        return collectedTimeline;
    }

    public void follow(User user) {
        if (user == null) {
            return;
        }

        if (following == null) {
            following = new ArrayList<>();
        }

        following.add(user);
    }
}
