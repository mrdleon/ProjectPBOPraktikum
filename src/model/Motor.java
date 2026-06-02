package model;

public class Motor extends Kendaraan
        implements Serviceable {

    private String jenisHelm;

    public Motor() {
    }

    public Motor(
            int idKendaraan,
            String namaKendaraan,
            String platNomor,
            double hargaSewa,
            String statusKendaraan,
            String jenisHelm
    ) {

        super(
                idKendaraan,
                namaKendaraan,
                platNomor,
                hargaSewa,
                statusKendaraan
        );

        this.jenisHelm = jenisHelm;
    }

    public String getJenisHelm() {
        return jenisHelm;
    }

    public void setJenisHelm(String jenisHelm) {
        this.jenisHelm = jenisHelm;
    }

    // Polymorphism
    @Override
    public double hitungBiayaSewa(int hari) {

        return getHargaSewa() * hari + 10000;

    }

    // Interface
    @Override
    public void service() {

        System.out.println("Motor sedang diservice.");

    }

}