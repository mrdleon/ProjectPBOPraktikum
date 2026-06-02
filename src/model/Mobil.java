package model;

public class Mobil extends Kendaraan
        implements Serviceable {

    private int jumlahKursi;

    public Mobil() {
    }

    public Mobil(
            int idKendaraan,
            String namaKendaraan,
            String platNomor,
            double hargaSewa,
            String statusKendaraan,
            int jumlahKursi
    ) {

        super(
                idKendaraan,
                namaKendaraan,
                platNomor,
                hargaSewa,
                statusKendaraan
        );

        this.jumlahKursi = jumlahKursi;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    // Polymorphism
    @Override
    public double hitungBiayaSewa(int hari) {

        return getHargaSewa() * hari + 50000;

    }

    // Interface
    @Override
    public void service() {

        System.out.println("Mobil sedang diservice.");

    }

}