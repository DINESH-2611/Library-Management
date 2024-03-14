package com.zsgs.librarymanagement.model;

public class Admin {
    private String name;
    private String userId;
    private String emailId;
    private long address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getAddress() {
        return address;
    }

    public void setAddress(long address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", emailId='" + emailId + '\'' +
                ", address=" + address +
                '}';
    }
}
