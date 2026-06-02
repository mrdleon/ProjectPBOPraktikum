package model;

public class Customer {

    private int idCustomer;
    private String namaCustomer;
    private String alamat;
    private String noHp;

    public Customer() {
    }

    public Customer(
            int idCustomer,
            String namaCustomer,
            String alamat,
            String noHp
    ) {

        this.idCustomer = idCustomer;
        this.namaCustomer = namaCustomer;
        this.alamat = alamat;
        this.noHp = noHp;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

}