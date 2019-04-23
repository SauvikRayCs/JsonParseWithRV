package com.ray.sauvik.jsonparsewithrv;

public class ExampleItem {
    private String mUserName;
    private String mUserAddress;
    private int  mUserPin;

    public ExampleItem(String userName, String userAddress, int userPin){
        mUserName = userName;
        mUserAddress = userAddress;
        mUserPin = userPin;
    }

    public String getmUserName(){
        return mUserName;
    }
    public String getmUserAddress(){
        return mUserAddress;
    }
    public int getmUserPin(){
        return mUserPin;
    }
}
