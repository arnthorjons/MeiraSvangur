package project.dao;

import project.model.Customer;

public interface CustomerDAO {
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
}
