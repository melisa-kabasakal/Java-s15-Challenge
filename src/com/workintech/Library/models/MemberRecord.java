package com.workintech.Library.models;

import java.util.Date;

public class MemberRecord {
    private Long memberId;
    private String type;
    private Date dateOfMembership;
    private int noBooksIssued;
    private  final int maxBookLimit = 5;
    private String name;
    private String phoneNo;
    private String address;

    public MemberRecord(Long memberId, String type, Date dateOfMembership, int noBooksIssued, String name, String phoneNo, String address) {
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssued = 0;
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    //Üye bilgileri
    public String getMember(){
        return memberId + name + type + phoneNo + address;
    }

    //Alınan kitap
    public boolean incBookIssued(){
        if(noBooksIssued < maxBookLimit){
            noBooksIssued++;
            return true;
        }
        return false;
    }

    //İade edilen kitap:
    public void decBookIssued(){
        if(noBooksIssued > 0){
            noBooksIssued--;
        }
    }

    //Üye ödemesi:
    public void payBill(){
        System.out.println(name + " has been paid.");
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public void whoyouare() {
        System.out.println("Member Name: " + name);
    }
}
