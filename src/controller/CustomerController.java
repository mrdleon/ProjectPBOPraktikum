package controller;

import dao.CustomerDAO;
import model.Customer;
import java.util.List;

public class CustomerController {

    private CustomerDAO dao;

    public CustomerController() {
        dao = new CustomerDAO();
    }

    public void simpanCustomer(
            String nama,
            String alamat,
            String noHp
    ) throws Exception {

        Customer customer = new Customer();

        customer.setNamaCustomer(nama);
        customer.setAlamat(alamat);
        customer.setNoHp(noHp);

        dao.insert(customer);
    }

    public void updateCustomer(
            int id,
            String nama,
            String alamat,
            String noHp
    ) throws Exception {

        Customer customer = new Customer();

        customer.setIdCustomer(id);
        customer.setNamaCustomer(nama);
        customer.setAlamat(alamat);
        customer.setNoHp(noHp);

        dao.update(customer);
    }

    public void hapusCustomer(int id) throws Exception {

        dao.delete(id);

    }
    
    public List<Customer> getAllCustomer()
        throws Exception {

        return dao.getAll();

    }

}