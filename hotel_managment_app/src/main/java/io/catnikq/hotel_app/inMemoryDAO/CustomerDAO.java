package io.catnikq.hotel_app.inMemoryDAO;

import io.catnikq.hotel_app.model.Customer;
import java.util.List;

public interface CustomerDAO {

    void save(Customer customer);

    Customer getById(int customerId);

    void update(Customer customer);

    void delete(int customerId);

    List<Customer> getAll();
}
