package com.example.android.newsappstage1;

public class OneNews {

    //member of the rubric in this class
    private String mRubric;

    //member of the title in this class
    private String mTitle;

    //member for DateandTime in this class
    private String mDateandTime;

    //member for the url of the News in this class
    private String murlNews;

    //member for the author in this class
    private String mauthor;

    // creates a object OneNews with the params
    //@param String rubric
    //@param String title
    //@param String dateAndTime
    //@param String rubric urlNews
    //@param String author

    public OneNews(String rubric, String title, String dateAndTime, String urlNews, String author) {
        mRubric = rubric;
        mTitle = title;
        mDateandTime = dateAndTime;
        murlNews = urlNews;
        mauthor = author;
    }

    //creates the method getRubric that returns the String mRubric
    public String getRubric() {
        return mRubric;
    }

    //creates the method getTitle that returns the String mTitle
    public String getTitle() {
        return mTitle;
    }

    //creates the method getDateAndTime that returns the String mDateandTime
    public String getDateAndTime() {
        return mDateandTime;
    }

    //creates the method geturlNewse that returns the String murlNews
    public String geturlNews() {
        return murlNews;
    }

    //creates the method getauthor that returns the String mauthor
    public String getauthor() {
        return mauthor;
    }
}
