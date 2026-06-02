package model;

public abstract class Kendaraan {

    // Encapsulation
    private int idKendaraan;
    private String namaKendaraan;
    private String platNomor;
    private double hargaSewa;
    private String statusKendaraan;

    // Constructor
    public Kendaraan() {
    }

    public Kendaraan(
            int idKendaraan,
            String namaKendaraan,
            String platNomor,
            double hargaSewa,
            String statusKendaraan
    ) {

        this.idKendaraan = idKendaraan;
        this.namaKendaraan = namaKendaraan;
        this.platNomor = platNomor;
        this.hargaSewa = hargaSewa;
        this.statusKendaraan = statusKendaraan;
    }

    // Getter Setter
    public int getIdKendaraan() {
        return idKendaraan;
    }

    public void setIdKendaraan(int idKendaraan) {
        this.idKendaraan = idKendaraan;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(double hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public String getStatusKendaraan() {
        return statusKendaraan;
    }

    public void setStatusKendaraan(String statusKendaraan) {
        this.statusKendaraan = statusKendaraan;
    }

    // Abstract Method
    public abstract double hitungBiayaSewa(int hari);

}