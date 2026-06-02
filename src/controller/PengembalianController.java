package controller;

import dao.PengembalianDAO;
import model.Rental;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PengembalianController {

    private PengembalianDAO dao;

    public PengembalianController() {

        dao = new PengembalianDAO();

    }

    public double hitungDenda(
            Date tanggalAsli,
            Date tanggalAktual
    ) {

        long selisih =
                tanggalAktual.getTime()
                - tanggalAsli.getTime();

        long hari =
                TimeUnit.DAYS.convert(
                        selisih,
                        TimeUnit.MILLISECONDS
                );

        if(hari < 0) {

            hari = 0;

        }

        return hari * 50000;

    }

    public void simpanPengembalian(
            int idRental,
            Date tanggalAsli,
            Date tanggalAktual,
            double denda,
            String namaKendaraan
    ) throws Exception {

        dao.simpanPengembalian(
                idRental,
                tanggalAsli,
                tanggalAktual,
                denda,
                namaKendaraan
        );

    }

    public List<Integer> getRentalAktif() {

        return dao.getRentalAktif();

    }

    public Rental getDetailRental(
            int idRental
    ) {

        return dao.getDetailRental(
                idRental
        );

    }

    public List<Object[]> getAllPengembalian() {

        return dao.getAllPengembalian();

    }

}