package io.catnikq.hotel_app.service;

import io.catnikq.hotel_app.model.Service;
import io.catnikq.hotel_app.model.Booking;
import io.catnikq.hotel_app.mockData.inMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class serviceService {

    public void addService(Service service) {
        int serviceId = inMemoryDatabase.getNextServiceId();
        service.setServiceID(serviceId);
        inMemoryDatabase.services.put(serviceId, service);
    }

    public Service getServiceById(int serviceId) {
        return inMemoryDatabase.services.get(serviceId);
    }

    public void updateService(Service service) {
        if (inMemoryDatabase.services.containsKey(service.getServiceID())) {
            inMemoryDatabase.services.put(service.getServiceID(), service);
        }
    }

    public void deleteService(int serviceId) {
        inMemoryDatabase.services.remove(serviceId);
    }

    public List<Service> getAllServices() {
        return new ArrayList<>(inMemoryDatabase.services.values());
    }

    public void addServiceToBooking(int bookingId, Service service) {
        Booking booking = inMemoryDatabase.bookings.get(bookingId);
        if (booking != null) {
            addService(service);
            booking.getServices().add(service);
            booking.setTotalPrice(booking.getTotalPrice() + service.getServicePrice());
        }
    }
}
