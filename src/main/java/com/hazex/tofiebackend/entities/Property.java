package com.hazex.tofiebackend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "properties")
public class Property {
    @Id
    private String id;

    private String title;
    private String description;
    private int propertyType;
    private int adType;
    private List<String> propertyPictures;
    private String rentDuration;
    private String rentRate;
    private String saleRate;
    private String address;
    private String locality;
    private String bedrooms;
    private String bathrooms;
    private String amenities;
    private String agentId;
    private int furnished;
    private float squareArea;
    private boolean negotiable;
    private LocalDateTime dateAdded;

    public Property()
    {

    }

    public Property(String id, String title, String description, int propertyType, int adType, List<String> propertyPictures, String rentDuration, String rentRate, String saleRate, String address, String locality, String bedrooms, String bathrooms, String amenities, String agentId, int furnished, float squareArea, boolean negotiable, LocalDateTime dateAdded) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.propertyType = propertyType;
        this.adType = adType;
        this.propertyPictures = propertyPictures;
        this.rentDuration = rentDuration;
        this.rentRate = rentRate;
        this.saleRate = saleRate;
        this.address = address;
        this.locality = locality;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.amenities = amenities;
        this.agentId = agentId;
        this.furnished = furnished;
        this.squareArea = squareArea;
        this.negotiable = negotiable;
        this.dateAdded = dateAdded;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(int propertyType) {
        this.propertyType = propertyType;
    }

    public int getAdType() {
        return adType;
    }

    public void setAdType(int adType) {
        this.adType = adType;
    }

    public List<String> getPropertyPictures() {
        return propertyPictures;
    }

    public void setPropertyPictures(List<String> propertyPictures) {
        this.propertyPictures = propertyPictures;
    }

    public String getRentDuration() {
        return rentDuration;
    }

    public void setRentDuration(String rentDuration) {
        this.rentDuration = rentDuration;
    }

    public String getRentRate() {
        return rentRate;
    }

    public void setRentRate(String rentRate) {
        this.rentRate = rentRate;
    }

    public String getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(String saleRate) {
        this.saleRate = saleRate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public int getFurnished() {
        return furnished;
    }

    public void setFurnished(int furnished) {
        this.furnished = furnished;
    }

    public float getSquareArea() {
        return squareArea;
    }

    public void setSquareArea(float squareArea) {
        this.squareArea = squareArea;
    }

    public boolean isNegotiable() {
        return negotiable;
    }

    public void setNegotiable(boolean negotiable) {
        this.negotiable = negotiable;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", propertyType=" + propertyType +
                ", adType=" + adType +
                ", propertyPictures=" + propertyPictures +
                ", rentDuration='" + rentDuration + '\'' +
                ", rentRate='" + rentRate + '\'' +
                ", saleRate='" + saleRate + '\'' +
                ", address='" + address + '\'' +
                ", locality='" + locality + '\'' +
                ", bedrooms='" + bedrooms + '\'' +
                ", bathrooms='" + bathrooms + '\'' +
                ", amenities='" + amenities + '\'' +
                ", agentId='" + agentId + '\'' +
                ", furnished=" + furnished +
                ", squareArea=" + squareArea +
                ", negotiable=" + negotiable +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
