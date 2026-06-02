package model;

import java.util.Date;

public class Rental {

    private int idRental;

    private Customer customer;

    private Kendaraan kendaraan;

    private Date tanggalRental;
    private Date tanggalKembali;

    private double totalBiaya;

    public Rental() {
    }

    public Rental(
            int idRental,
            Customer customer,
            Kendaraan kendaraan,
            Date tanggalRental,
            Date tanggalKembali,
            double totalBiaya
    ) {

        this.idRental = idRental;
        this.customer = customer;
        this.kendaraan = kendaraan;
        this.tanggalRental = tanggalRental;
        this.tanggalKembali = tanggalKembali;
        this.totalBiaya = totalBiaya;
    }

    public int getIdRental() {
        return idRental;
    }

    public void setIdRental(int idRental) {
        this.idRental = idRental;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public Date getTanggalRental() {
        return tanggalRental;
    }

    public void setTanggalRental(Date tanggalRental) {
        this.tanggalRental = tanggalRental;
    }

    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(Date tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(double totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

}