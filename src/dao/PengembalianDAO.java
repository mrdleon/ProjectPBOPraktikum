package dao;

import database.Koneksi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import model.Customer;
import model.Kendaraan;
import model.Mobil;
import model.Rental;

public class PengembalianDAO {

    private Connection conn;

    public PengembalianDAO() {

        conn = Koneksi.getKoneksi();

    }

    public void simpanPengembalian(
        int idRental,
        Date tanggalAsli,
        Date tanggalAktual,
        double denda,
        String namaKendaraan
    ) throws Exception {

        try {

            conn.setAutoCommit(false);

            String sql =
                    "INSERT INTO pengembalian "
                    + "(id_rental, "
                    + "tanggal_kembali_asli, "
                    + "tanggal_pengembalian, "
                    + "denda) "
                    + "VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(1, idRental);

            ps.setDate(
                    2,
                    new java.sql.Date(
                            tanggalAsli.getTime()
                    )
            );

            ps.setDate(
                    3,
                    new java.sql.Date(
                            tanggalAktual.getTime()
                    )
            );

            ps.setDouble(4, denda);

            ps.executeUpdate();

            String updateRental =
                    "UPDATE rental "
                    + "SET status='Selesai' "
                    + "WHERE id_rental=?";

            PreparedStatement ps2 =
                    conn.prepareStatement(updateRental);

            ps2.setInt(1, idRental);

            ps2.executeUpdate();

            String updateKendaraan =
                    "UPDATE kendaraan "
                    + "SET status_kendaraan='Tersedia' "
                    + "WHERE nama_kendaraan=?";

            PreparedStatement ps3 =
                    conn.prepareStatement(updateKendaraan);

            ps3.setString(
                    1,
                    namaKendaraan
            );

            ps3.executeUpdate();

            conn.commit();

        } catch(Exception e) {

            conn.rollback();

            throw e;

        } finally {

            conn.setAutoCommit(true);

        }

    }

    public List<Integer> getRentalAktif() {

        List<Integer> list =
                new ArrayList<>();

        String sql =
                "SELECT id_rental "
                + "FROM rental "
                + "WHERE status='Aktif'";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                list.add(
                        rs.getInt("id_rental")
                );

            }

        } catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );

        }

        return list;

    }

    public Rental getDetailRental(
            int idRental
    ) {

        Rental rental = null;

        String sql =
                "SELECT * FROM rental "
                + "WHERE id_rental=?";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setInt(
                    1,
                    idRental
            );

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                rental = new Rental();

                Customer customer =
                        new Customer();

                customer.setNamaCustomer(
                        rs.getString(
                                "nama_customer"
                        )
                );

                Kendaraan kendaraan =
                        new Mobil();

                kendaraan.setNamaKendaraan(
                        rs.getString(
                                "nama_kendaraan"
                        )
                );

                rental.setIdRental(
                        rs.getInt(
                                "id_rental"
                        )
                );

                rental.setCustomer(
                        customer
                );

                rental.setKendaraan(
                        kendaraan
                );

                rental.setTanggalKembali(
                        rs.getDate(
                                "tanggal_kembali"
                        )
                );

            }

        } catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );

        }

        return rental;

    }

    public List<Object[]> getAllPengembalian() {

        List<Object[]> list =
                new ArrayList<>();

        String sql =
                "SELECT p.id_pengembalian, "
                + "r.nama_customer, "
                + "r.nama_kendaraan, "
                + "p.tanggal_pengembalian, "
                + "p.denda "
                + "FROM pengembalian p "
                + "JOIN rental r "
                + "ON p.id_rental = r.id_rental "
                + "ORDER BY p.id_pengembalian DESC";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Object[] row = {

                    rs.getInt(
                            "id_pengembalian"
                    ),

                    rs.getString(
                            "nama_customer"
                    ),

                    rs.getString(
                            "nama_kendaraan"
                    ),

                    rs.getDate(
                            "tanggal_pengembalian"
                    ),

                    rs.getDouble(
                            "denda"
                    )

                };

                list.add(row);

            }

        } catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );

        }

        return list;

    }

}