package dao;

import database.Koneksi;
import model.Customer;
import model.Kendaraan;
import model.Mobil;
import model.Rental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class RentalDAO {

    private Connection conn;

    public RentalDAO() {

        conn = Koneksi.getKoneksi();

    }

    public void insertRental(
            Rental rental,
            int lamaHari
    ) throws Exception {

        String sql =
                "INSERT INTO rental "
                + "(nama_customer,nama_kendaraan,"
                + "tanggal_rental,tanggal_kembali,"
                + "lama_hari,total_biaya,status)"
                + " VALUES(?,?,?,?,?,?,?)";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        ps.setString(
                1,
                rental.getCustomer()
                        .getNamaCustomer()
        );

        ps.setString(
                2,
                rental.getKendaraan()
                        .getNamaKendaraan()
        );

        ps.setDate(
                3,
                new java.sql.Date(
                        rental.getTanggalRental()
                                .getTime()
                )
        );

        ps.setDate(
                4,
                new java.sql.Date(
                        rental.getTanggalKembali()
                                .getTime()
                )
        );

        ps.setInt(
                5,
                lamaHari
        );

        ps.setDouble(
                6,
                rental.getTotalBiaya()
        );

        ps.setString(
                7,
                "Aktif"
        );

        ps.executeUpdate();

        String updateKendaraan =
                "UPDATE kendaraan "
                + "SET status_kendaraan='Disewa' "
                + "WHERE nama_kendaraan=?";

        PreparedStatement ps2 =
                conn.prepareStatement(
                        updateKendaraan
                );

        ps2.setString(
                1,
                rental.getKendaraan()
                        .getNamaKendaraan()
        );

        ps2.executeUpdate();

    }

    public void updateStatus(
            int idRental,
            String status
    ) throws Exception {

        String sql =
                "UPDATE rental "
                + "SET status=? "
                + "WHERE id_rental=?";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        ps.setString(
                1,
                status
        );

        ps.setInt(
                2,
                idRental
        );

        ps.executeUpdate();

    }

    public List<Rental> getAll() {

        List<Rental> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM rental";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Rental rental =
                        new Rental();

                Customer customer =
                        new Customer();

                customer.setNamaCustomer(
                        rs.getString("nama_customer")
                );

                Kendaraan kendaraan =
                        new Mobil();

                kendaraan.setNamaKendaraan(
                        rs.getString("nama_kendaraan")
                );

                rental.setIdRental(
                        rs.getInt("id_rental")
                );

                rental.setCustomer(
                        customer
                );

                rental.setKendaraan(
                        kendaraan
                );

                rental.setTanggalRental(
                        rs.getDate("tanggal_rental")
                );

                rental.setTanggalKembali(
                        rs.getDate("tanggal_kembali")
                );

                rental.setTotalBiaya(
                        rs.getDouble("total_biaya")
                );

                list.add(rental);

            }

        } catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );

        }

        return list;

    }

    public List<String> getAllCustomer() {

        List<String> list =
                new ArrayList<>();

        String sql =
                "SELECT nama_customer "
                + "FROM customer";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                list.add(
                        rs.getString(
                                "nama_customer"
                        )
                );

            }

        } catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );

        }

        return list;

    }

    public List<String> getKendaraanTersedia() {

        List<String> list =
                new ArrayList<>();

        String sql =
                "SELECT nama_kendaraan "
                + "FROM kendaraan "
                + "WHERE status_kendaraan='Tersedia'";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                list.add(
                        rs.getString(
                                "nama_kendaraan"
                        )
                );

            }

        } catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );

        }

        return list;

    }

    public double getHargaKendaraan(
            String namaKendaraan
    ) {

        String sql =
                "SELECT harga_sewa "
                + "FROM kendaraan "
                + "WHERE nama_kendaraan=?";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(
                    1,
                    namaKendaraan
            );

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                return rs.getDouble(
                        "harga_sewa"
                );

            }

        } catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );

        }

        return 0;

    }
    
    public Kendaraan getKendaraanByNama(
        String namaKendaraan
    ) {

        String sql =
                "SELECT * FROM kendaraan "
                + "WHERE nama_kendaraan=?";

        try {

            PreparedStatement ps =
                    conn.prepareStatement(sql);

            ps.setString(
                    1,
                    namaKendaraan
            );

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                Kendaraan kendaraan;

                String jenis =
                        rs.getString("jenis");

                if(jenis.equalsIgnoreCase("Mobil")) {

                    kendaraan =
                            new Mobil();

                } else {

                    kendaraan =
                            new model.Motor();

                }

                kendaraan.setIdKendaraan(
                        rs.getInt("id_kendaraan")
                );

                kendaraan.setNamaKendaraan(
                        rs.getString("nama_kendaraan")
                );

                kendaraan.setPlatNomor(
                        rs.getString("plat_nomor")
                );

                kendaraan.setHargaSewa(
                        rs.getDouble("harga_sewa")
                );

                kendaraan.setStatusKendaraan(
                        rs.getString("status_kendaraan")
                );

                return kendaraan;

            }

        } catch(Exception e) {

            System.out.println(
                    e.getMessage()
            );

        }

        return null;

    }

}