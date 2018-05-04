package com.example.suman_pc.tourism_app.Trekkingpage;

/**
 * Created by suman-PC on 4/8/2018.
 */
public class cards_trek {
    private String imgURL;
    private String title;

    public cards_trek(String imgURL, String title){
        this.imgURL=imgURL;
        this.title=title;

    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgurl(String imgurl) {
        this.imgURL = imgurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
