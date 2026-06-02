package dao;

import database.Koneksi;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private Connection conn;

    public CustomerDAO() {

        conn = Koneksi.getKoneksi();

    }

    // INSERT
    public void insert(Customer customer) throws Exception {

        String sql =
                "INSERT INTO customer "
                + "(nama_customer, alamat, no_hp) "
                + "VALUES (?, ?, ?)";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        ps.setString(
                1,
                customer.getNamaCustomer()
        );

        ps.setString(
                2,
                customer.getAlamat()
        );

        ps.setString(
                3,
                customer.getNoHp()
        );

        ps.executeUpdate();
    }

    // UPDATE
    public void update(Customer customer) throws Exception {

        String sql =
                "UPDATE customer SET "
                + "nama_customer=?, "
                + "alamat=?, "
                + "no_hp=? "
                + "WHERE id_customer=?";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        ps.setString(
                1,
                customer.getNamaCustomer()
        );

        ps.setString(
                2,
                customer.getAlamat()
        );

        ps.setString(
                3,
                customer.getNoHp()
        );

        ps.setInt(
                4,
                customer.getIdCustomer()
        );

        ps.executeUpdate();
    }

    // DELETE
    public void delete(int id) throws Exception {

        String sql =
                "DELETE FROM customer "
                + "WHERE id_customer=?";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        ps.setInt(
                1,
                id
        );

        ps.executeUpdate();
    }
    
    public List<Customer> getAll() throws Exception {

    List<Customer> list =
            new ArrayList<>();

    String sql =
            "SELECT * FROM customer";

    PreparedStatement ps =
            conn.prepareStatement(sql);

    ResultSet rs =
            ps.executeQuery();

    while(rs.next()) {

        Customer customer =
                new Customer();

        customer.setIdCustomer(
                rs.getInt("id_customer")
        );

        customer.setNamaCustomer(
                rs.getString("nama_customer")
        );

        customer.setAlamat(
                rs.getString("alamat")
        );

        customer.setNoHp(
                rs.getString("no_hp")
        );

        list.add(customer);

    }

    return list;
}

}