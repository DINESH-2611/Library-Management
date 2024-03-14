package com.zsgs.librarymanagement.model;


import java.util.List;

public class Library {
    private String name;
    private String id;
    private long phoneNo;

    private String emailId;
    private String address;
    private List<Admin> adminUsers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Admin> getAdminUsers() {
        return adminUsers;
    }

    public void setAdminUsers(List<Admin> adminUsers) {
        this.adminUsers = adminUsers;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", phoneNo=" + phoneNo +
                ", emailId='" + emailId + '\'' +
                ", address='" + address + '\'' +
                ", adminUsers=" + adminUsers +
                '}';
    }
}
