package com.example.finalproject;

public class forumPosts {
    String Title; //username for the authenticated user
    String PostMsg; //the text of the message being sent

    public forumPosts() {

    }

    public forumPosts(String Title, String PostMsg) {
        this.Title = Title;
        this.PostMsg = PostMsg;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getPostMsg() {
        return PostMsg;
    }

    public void setPostMsg(String PostMsg) {
        this.PostMsg = PostMsg;
    }
}
