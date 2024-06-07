package io.catnikq.hotel_app.controller;

import io.catnikq.hotel_app.model.Payment;
import java.util.List;

public interface PaymentController {

    void addPayment(Payment payment);

    Payment getPaymentById(int paymentId);

    void updatePayment(Payment payment);

    void deletePayment(int paymentId);

    List<Payment> getAllPayments();
}
