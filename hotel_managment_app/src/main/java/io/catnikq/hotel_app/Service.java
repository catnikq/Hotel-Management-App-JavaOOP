package io.catnikq.hotel_app;

import java.time.LocalDate;

public class Service {
    private String serviceID;
    private String serviceName;
    private String description;
    private Float servicePrice;
    private Boolean serviceStatus;
    private String serviceType;
    private LocalDate requestedDate;
    
    //Getters
    public String getServiceID() {
        return serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getDescription() {
        return description;
    }

    public Float getServicePrice() {
        return servicePrice;
    }

    public Boolean getServiceStatus() {
        return serviceStatus;
    }

    public String getServiceType() {
        return serviceType;
    }

    public LocalDate getRequestedDate() {
        return requestedDate;
    }
   
    //Setters
    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setServicePrice(Float servicePrice) {
        this.servicePrice = servicePrice;
    }

    public void setServiceStatus(Boolean serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setRequestedDate(LocalDate requestedDate) {
        this.requestedDate = requestedDate;
    }
    
}
