package model;

public class Motor extends Kendaraan
        implements Serviceable {

    public Motor() {
    }

    public Motor(
            int idKendaraan,
            String namaKendaraan,
            String platNomor,
            double hargaSewa,
            String statusKendaraan
    ) {

        super(
                idKendaraan,
                namaKendaraan,
                platNomor,
                hargaSewa,
                statusKendaraan
        );

    }

    @Override
    public double hitungBiayaSewa(int hari) {

        return getHargaSewa() * hari + 10000;

    }
    
    @Override
    public double hitungBiayaSewa(
            int hari,
            double diskon
    ) {

        double total =
                hitungBiayaSewa(hari);

        return total -
                (total * diskon / 100);

    }

    @Override
    public String service() {

        return "Motor sedang diservice.";

    }

}