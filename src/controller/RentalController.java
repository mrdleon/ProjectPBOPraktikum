package controller;

import dao.RentalDAO;
import model.Customer;
import model.Kendaraan;
import model.Mobil;
import model.Rental;

import java.util.Date;
import java.util.List;

public class RentalController {

    private RentalDAO dao;

    public RentalController() {

        dao = new RentalDAO();

    }

    public void simpanRental(
            String namaCustomer,
            String namaKendaraan,
            Date tanggalRental,
            Date tanggalKembali,
            int lamaHari,
            double totalBiaya
    ) throws Exception {

        Rental rental =
                new Rental();

        Customer customer =
                new Customer();

        customer.setNamaCustomer(
                namaCustomer
        );

        Mobil kendaraan =
                new Mobil();

        kendaraan.setNamaKendaraan(
                namaKendaraan
        );

        rental.setCustomer(customer);

        rental.setKendaraan(kendaraan);

        rental.setTanggalRental(
                tanggalRental
        );

        rental.setTanggalKembali(
                tanggalKembali
        );

        rental.setTotalBiaya(
                totalBiaya
        );

        dao.insertRental(
                rental,
                lamaHari
        );

    }

    public void updateStatus(
            int idRental,
            String status
    ) throws Exception {

        dao.updateStatus(
                idRental,
                status
        );

    }

    public List<Rental> getAllRental() {

        return dao.getAll();

    }

    public List<String> getAllCustomer() {

        return dao.getAllCustomer();

    }

    public List<String> getKendaraanTersedia() {

        return dao.getKendaraanTersedia();

    }

    public double getHargaKendaraan(
            String namaKendaraan
    ) {

        return dao.getHargaKendaraan(
                namaKendaraan
        );

    }

    // Overloading 1 (tanpa diskon)
    public double hitungTotalBiaya(
            String namaKendaraan,
            int lamaHari
    ) {

        Kendaraan kendaraan =
                dao.getKendaraanByNama(
                        namaKendaraan
                );

        if(kendaraan == null) {

            return 0;

        }

        return kendaraan.hitungBiayaSewa(
                lamaHari
        );

    }

    // Overloading 2 (dengan diskon)
    public double hitungTotalBiaya(
            String namaKendaraan,
            int lamaHari,
            double diskon
    ) {

        Kendaraan kendaraan =
                dao.getKendaraanByNama(
                        namaKendaraan
                );

        if(kendaraan == null) {

            return 0;

        }

        return kendaraan.hitungBiayaSewa(
                lamaHari,
                diskon
        );

    }

    // Method untuk menentukan promo otomatis
    public double hitungTotalBiayaPromo(
            String namaKendaraan,
            int lamaHari
    ) {

        if(lamaHari >= 3) {

            return hitungTotalBiaya(
                    namaKendaraan,
                    lamaHari,
                    10
            );

        }

        return hitungTotalBiaya(
                namaKendaraan,
                lamaHari
        );

    }

}