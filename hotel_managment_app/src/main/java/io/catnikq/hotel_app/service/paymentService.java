package io.catnikq.hotel_app.service;

import io.catnikq.hotel_app.model.Booking;
import io.catnikq.hotel_app.model.Payment;
import io.catnikq.hotel_app.mockData.inMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class paymentService {
     private final roomService roomService = new roomService();

    public void addPayment(Payment payment) {
        int paymentId = inMemoryDatabase.getNextPaymentId();
        payment.setPaymentID(paymentId);

        Booking booking = inMemoryDatabase.bookings.get(payment.getBookingID());
        if (booking != null) {
            roomService.releaseRoom(booking.getRoom().getRoomNumber());
            inMemoryDatabase.payments.put(paymentId, payment);
        }
    }

    public Payment getPaymentById(int paymentId) {
        return inMemoryDatabase.payments.get(paymentId);
    }

    public void updatePayment(Payment payment) {
        if (inMemoryDatabase.payments.containsKey(payment.getPaymentID())) {
            inMemoryDatabase.payments.put(payment.getPaymentID(), payment);
        }
    }

    public void deletePayment(int paymentId) {
        inMemoryDatabase.payments.remove(paymentId);
    }

    public List<Payment> getAllPayments() {
        return new ArrayList<>(inMemoryDatabase.payments.values());
    }
}
