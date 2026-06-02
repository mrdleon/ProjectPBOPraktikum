package controller;

import dao.KendaraanDAO;
import model.Kendaraan;
import model.Mobil;
import model.Motor;

import java.util.List;

public class KendaraanController {

    private KendaraanDAO dao;

    public KendaraanController() {

        dao = new KendaraanDAO();

    }

    public void simpanKendaraan(
            String nama,
            String jenis,
            String plat,
            double harga,
            String status
    ) throws Exception {

        Kendaraan kendaraan;

        if(jenis.equalsIgnoreCase("Mobil")) {

            kendaraan = new Mobil();

        } else {

            kendaraan = new Motor();

        }

        kendaraan.setNamaKendaraan(nama);
        kendaraan.setPlatNomor(plat);
        kendaraan.setHargaSewa(harga);
        kendaraan.setStatusKendaraan(status);

        dao.insert(kendaraan);

    }

    public void updateKendaraan(
            int id,
            String nama,
            String jenis,
            String plat,
            double harga,
            String status
    ) throws Exception {

        Kendaraan kendaraan;

        if(jenis.equalsIgnoreCase("Mobil")) {

            kendaraan = new Mobil();

        } else {

            kendaraan = new Motor();

        }

        kendaraan.setIdKendaraan(id);
        kendaraan.setNamaKendaraan(nama);
        kendaraan.setPlatNomor(plat);
        kendaraan.setHargaSewa(harga);
        kendaraan.setStatusKendaraan(status);

        dao.update(kendaraan);

    }

    public void hapusKendaraan(
            int id
    ) throws Exception {

        dao.delete(id);

    }

    public List<Kendaraan> getAllKendaraan()
            throws Exception {

        return dao.getAll();

    }

}