package io.catnikq.hotel_app.service;

import io.catnikq.hotel_app.inMemoryDAO.BookingDAO;
import io.catnikq.hotel_app.inMemoryDAO.PaymentDAO;
import io.catnikq.hotel_app.inMemoryDAO.RoomDAO;
import io.catnikq.hotel_app.model.Booking;
import io.catnikq.hotel_app.model.Payment;

import java.util.List;

public class paymentService {

    private PaymentDAO paymentDAO;
    private BookingDAO bookingDAO;
    private RoomDAO roomDAO;

    public paymentService(PaymentDAO paymentDAO, BookingDAO bookingDAO, RoomDAO roomDAO) {
        this.paymentDAO = paymentDAO;
        this.bookingDAO = bookingDAO;
        this.roomDAO = roomDAO;
    }

    public void addPayment(Payment payment) {
        Booking booking = bookingDAO.getById(payment.getBookingID());
        if (booking != null) {
            roomDAO.getByNumber(booking.getRoom().getRoomNumber()).setStatus("Available");
            roomDAO.update(booking.getRoom());
            paymentDAO.save(payment);
        }
    }

    public Payment getPaymentById(int paymentId) {
        return paymentDAO.getById(paymentId);
    }

    public void updatePayment(Payment payment) {
        paymentDAO.update(payment);
    }

    public void deletePayment(int paymentId) {
        paymentDAO.delete(paymentId);
    }

    public List<Payment> getAllPayments() {
        return paymentDAO.getAll();
    }
}
