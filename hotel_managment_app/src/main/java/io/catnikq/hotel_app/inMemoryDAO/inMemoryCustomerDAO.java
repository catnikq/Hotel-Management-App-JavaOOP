package io.catnikq.hotel_app.inMemoryDAO;

import io.catnikq.hotel_app.mockData.inMemoryDatabase;
import io.catnikq.hotel_app.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class inMemoryCustomerDAO implements CustomerDAO {

    @Override
    public void save(Customer customer) {
        customer.setId(inMemoryDatabase.getNextPersonId());
        customer.setCustomerID(inMemoryDatabase.getNextCustomerId());
        inMemoryDatabase.customers.put(customer.getCustomerID(), customer);
        inMemoryDatabase.persons.put(customer.getId(), customer);
    }

    @Override
    public Customer getById(int customerId) {
        return inMemoryDatabase.customers.get(customerId);
    }

    @Override
    public void update(Customer customer) {
        if (inMemoryDatabase.customers.containsKey(customer.getCustomerID())) {
            inMemoryDatabase.customers.put(customer.getCustomerID(), customer);
            inMemoryDatabase.persons.put(customer.getId(), customer);
        }
    }

    @Override
    public void delete(int customerId) {
        Customer customer = inMemoryDatabase.customers.remove(customerId);
        if (customer != null) {
            inMemoryDatabase.persons.remove(customer.getId());
        }
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(inMemoryDatabase.customers.values());
    }

}
