package com.example.carex;

public class ItemModel {
    private String donorName;
    private String phoneNo;
    private String itemName;
    private String itemDescription;
    private String pickupAddress;
    private String category;
    private boolean isAvailable;

    public ItemModel(String donorName, String phoneNo, String itemName, String itemDescription, String pickupAddress, String category, boolean isAvailable) {
        this.donorName = donorName;
        this.phoneNo = phoneNo;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.pickupAddress = pickupAddress;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
