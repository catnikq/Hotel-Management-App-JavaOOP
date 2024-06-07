package io.catnikq.hotel_app.controller;

import io.catnikq.hotel_app.model.Payment;
import io.catnikq.hotel_app.service.paymentService;
import java.util.List;

public class PaymentControllerImpl implements PaymentController {

    private paymentService paymentService;

    public PaymentControllerImpl(paymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void addPayment(Payment payment) {
        paymentService.addPayment(payment);
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @Override
    public void updatePayment(Payment payment) {
        paymentService.updatePayment(payment);
    }

    @Override
    public void deletePayment(int paymentId) {
        paymentService.deletePayment(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

}
