package com.example.suman_pc.tourism_app.Activity;

/**
 * Created by suman-PC on 4/8/2018.
 */
public class cards {
    private String imgURL;
    private String title;

    public  cards(String imgURL,String title){
        this.imgURL=imgURL;
        this.title=title;

    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
