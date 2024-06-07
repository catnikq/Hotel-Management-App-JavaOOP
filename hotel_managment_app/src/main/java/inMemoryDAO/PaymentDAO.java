package inMemoryDAO;

import io.catnikq.hotel_app.model.Payment;
import java.util.List;

public interface PaymentDAO {

    void save(Payment payment);

    Payment getById(int paymentId);

    void update(Payment payment);

    void delete(int paymentId);

    List<Payment> getAll();
}
