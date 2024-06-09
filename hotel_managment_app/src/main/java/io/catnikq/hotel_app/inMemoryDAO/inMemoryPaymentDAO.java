package io.catnikq.hotel_app.inMemoryDAO;

import io.catnikq.hotel_app.mockData.inMemoryDatabase;
import io.catnikq.hotel_app.model.Payment;
import java.util.ArrayList;
import java.util.List;

public class inMemoryPaymentDAO implements PaymentDAO {

    @Override
    public void save(Payment payment) {
        int paymentId = inMemoryDatabase.getNextPaymentId();
        payment.setPaymentID(paymentId);
        inMemoryDatabase.payments.put(paymentId, payment);
    }

    @Override
    public Payment getById(int paymentId) {
        return inMemoryDatabase.payments.get(paymentId);
    }

    @Override
    public void update(Payment payment) {
        if (inMemoryDatabase.payments.containsKey(payment.getPaymentID())) {
            inMemoryDatabase.payments.put(payment.getPaymentID(), payment);
        }
    }

    @Override
    public void delete(int paymentId) {
        inMemoryDatabase.payments.remove(paymentId);
    }

    @Override
    public List<Payment> getAll() {
        return new ArrayList<>(inMemoryDatabase.payments.values());
    }

}
