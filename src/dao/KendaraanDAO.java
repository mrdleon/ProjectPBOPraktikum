package dao;

import database.Koneksi;
import model.Kendaraan;
import model.Mobil;
import model.Motor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KendaraanDAO {

    private Connection conn;

    public KendaraanDAO() {

        conn = Koneksi.getKoneksi();

    }

    public void insert(
        Kendaraan kendaraan
    ) throws Exception {

        String sql =
                "INSERT INTO kendaraan "
                + "(nama_kendaraan, jenis, plat_nomor, harga_sewa, status_kendaraan) "
                + "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        ps.setString(
                1,
                kendaraan.getNamaKendaraan()
        );

        ps.setString(
                2,
                kendaraan.getClass().getSimpleName()
        );

        ps.setString(
                3,
                kendaraan.getPlatNomor()
        );

        ps.setDouble(
                4,
                kendaraan.getHargaSewa()
        );

        ps.setString(
                5,
                kendaraan.getStatusKendaraan()
        );

        ps.executeUpdate();

    }

    public void update(
        Kendaraan kendaraan
    ) throws Exception {

        String sql =
                "UPDATE kendaraan "
                + "SET nama_kendaraan=?, "
                + "jenis=?, "
                + "plat_nomor=?, "
                + "harga_sewa=?, "
                + "status_kendaraan=? "
                + "WHERE id_kendaraan=?";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        ps.setString(
                1,
                kendaraan.getNamaKendaraan()
        );

        ps.setString(
                2,
                kendaraan.getClass().getSimpleName()
        );

        ps.setString(
                3,
                kendaraan.getPlatNomor()
        );

        ps.setDouble(
                4,
                kendaraan.getHargaSewa()
        );

        ps.setString(
                5,
                kendaraan.getStatusKendaraan()
        );

        ps.setInt(
                6,
                kendaraan.getIdKendaraan()
        );

        ps.executeUpdate();

    }

    public List<Kendaraan> getAll()
        throws Exception {

        List<Kendaraan> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM kendaraan";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        ResultSet rs =
                ps.executeQuery();

        while(rs.next()) {

            Kendaraan kendaraan;

            String jenis =
                    rs.getString("jenis");

            if(jenis.equalsIgnoreCase("Mobil")) {

                kendaraan = new Mobil();

            } else {

                kendaraan = new Motor();

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

            list.add(kendaraan);

        }

        return list;

    }

    public void delete(
        int id
    ) throws Exception {

        String sql =
                "DELETE FROM kendaraan "
                + "WHERE id_kendaraan=?";

        PreparedStatement ps =
                conn.prepareStatement(sql);

        ps.setInt(
                1,
                id
        );

        ps.executeUpdate();

    }

}