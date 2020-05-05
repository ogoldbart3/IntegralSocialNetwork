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

    public List<User> getFollowing() {
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

        if (yellText != null && !yellText.isEmpty()) {
            yells.add(new Yell(name, yellText));
        }
    }

    public List<Yell> getPersonalTimeline() {
        List<Yell> timeline = getYells();
        if (timeline != null) {
            Collections.sort(timeline);
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

        for (User followed : following) {
            collectedTimeline.addAll(followed.getPersonalTimeline());
        }

        Collections.sort(collectedTimeline);

        return collectedTimeline;
    }
}
