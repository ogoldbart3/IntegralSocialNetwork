package model;

import utils.DateUtil;

public class Yell implements Comparable{
    private String createdBy;
    private String statement;
    private String createdAt;

    public Yell(String createdBy, String statement) {
        this(createdBy, statement, DateUtil.getCurrentDateTime());
    }

    public Yell(String createdBy, String statement, String createdAt) {
        this.createdBy = createdBy;
        this.statement = statement;
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Yell) {
            Yell yell = (Yell) o;
            return this.createdAt.compareTo(yell.createdAt);
        }

        return 0;
    }
}
