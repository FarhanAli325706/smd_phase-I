package com.smsaz.fitnessenthusiast;

public class dataValues {
    public String name;
    public int images;
    public dataValues(String name, int images)
    {
        this.name=name;
        this.images=images;
    }
    public String getName()
    {
        return this.name;
    }
    public int getImages()
    {
        return this.images;
    }
}
