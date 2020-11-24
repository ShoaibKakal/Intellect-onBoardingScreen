package com.shoaib.intellectonboardingscreens;

public class ModelClass {
    private int image;
    private String heading;
    private String secondaryHeading;

    public ModelClass(int image, String heading, String secondaryHeading) {
        this.image = image;
        this.heading = heading;
        this.secondaryHeading = secondaryHeading;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSecondaryHeading() {
        return secondaryHeading;
    }

    public void setSecondaryHeading(String secondaryHeading) {
        this.secondaryHeading = secondaryHeading;
    }
}
