package models.old;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zein
 */
public class Penduduk implements Model {
    private long id;
    private long rutaId;
    private int noUrut;
    private String NIK;
    private String nama;
    private boolean jenisKelamin;
    private boolean kepalaKeluarga;
    private String posisi;
    private int usia;
    private Kesulitan kesulitan;
    private String pendidikanTertinggi;
    private Pekerjaan pekerjaan;
    private Usaha usaha;

    public Penduduk() {}
    public Penduduk(long id) {
        this.id = id;
    }

    @Override
    public String getInsertStatement() {
        return "INSERT INTO penduduk (ruta_id, no_urut, nik, nama,"
                + "jenis_kelamin, kepala_keluarga, posisi,"
                + "usia, kesulitan, pendidikan, lapangan_usaha,"
                + "status_kerja, jumlah_usaha, usaha_utama)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public void prepareInsertStatement(PreparedStatement pstmt) throws SQLException {
        pstmt.setLong(1, rutaId);
        pstmt.setInt(2, noUrut);
        pstmt.setString(3, NIK);
        pstmt.setString(4, nama);
        pstmt.setBoolean(5, jenisKelamin);
        pstmt.setBoolean(6, kepalaKeluarga);
        pstmt.setString(7, posisi);
        pstmt.setInt(8, usia);

        if (kesulitan != null) {
            pstmt.setString(9, kesulitan.getKesulitan());
        } else {
            pstmt.setNull(9, Types.VARCHAR);
        }

        if (pendidikanTertinggi != null) {
            pstmt.setString(10, pendidikanTertinggi);
        } else {
            pstmt.setNull(10, Types.VARCHAR);
        }

        if (pekerjaan != null) {
            pstmt.setString(11, pekerjaan.getLapanganUsaha());
            pstmt.setString(12, pekerjaan.getStatusKependudukan());
        } else {
            pstmt.setNull(11, Types.VARCHAR);
            pstmt.setNull(12, Types.VARCHAR);
        }

        if (usaha != null) {
            pstmt.setInt(13, usaha.getJumlahUsaha());
            pstmt.setString(14, String.valueOf(usaha.getLapanganUsaha()));
        } else {
            pstmt.setInt(13, 0);
            pstmt.setNull(14, Types.VARCHAR);
        }
    }

    @Override
    public void save() throws SQLException {
        Database.getInstance().save(this);
    }

    public static List<Penduduk> getAll(long ruta_id) throws SQLException {
        List<Penduduk> art = new ArrayList<>();
        try (Connection con = Database.getInstance().getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM penduduk WHERE ruta_id=?");
            pstmt.setLong(1, ruta_id);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Penduduk penduduk = new Penduduk(rs.getLong("id"));
                    
                    penduduk.setRutaId(ruta_id);
                    penduduk.setNoUrut(rs.getString("no_urut"));
                    penduduk.setNIK(rs.getString("nik"));
                    penduduk.setNama(rs.getString("nama"));
                    penduduk.setJenisKelamin(rs.getBoolean("jenis_kelamin"));
                    penduduk.setKepalaKeluarga(rs.getBoolean("kepala_keluarga"));
                    penduduk.setPosisi(rs.getString("posisi"));
                    penduduk.setUsia(rs.getInt("usia"));

                    art.add(penduduk);
                }
            } catch(Exception err) {
                System.out.println("Error: " + err);
            }
        }

        return art;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @return the rutaId
     */
    public long getRutaId() {
        return rutaId;
    }

    /**
     * @return the noUrut
     */
    public int getNoUrut() {
        return noUrut;
    }

 /**
     * @param noUrut the noUrut to set
     * @throws java.lang.Exception
     */
    
    public void setNoUrut(String noUrut) throws Exception {
         try {
                if (noUrut.length() != 3) {
                    throw new Exception("Harap isi Nomor Urut Anggota Keluarga dengan 3 digit angka");
                   }
            this.noUrut = Integer.parseInt(noUrut);
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the NIK
     */
    public String getNIK() {
        return NIK;
    }

/**
     * @param NIK the NIK to set
     * @throws java.lang.Exception
     */
    
    public void setNIK(String NIK) throws Exception {
        try {
                if (NIK.length() != 16) {
                    throw new Exception("Harap isi NIK dengan 16 digit angka");
                }
            this.NIK = NIK;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the jenisKelamin
     */
    public boolean isJenisKelamin() {
        return jenisKelamin;
    }

 /**
     * @param jenisKelamin the jenisKelamin to set
     * @throws java.lang.Exception
     */
    
    public void setJenisKelamin(boolean jenisKelamin) throws Exception {
        this.jenisKelamin = jenisKelamin;
    }

    /**
     * @return the posisi
     */
    public String getPosisi() {
        return posisi;
    }

    /**
     * @param posisi the posisi to set
     * @throws java.lang.Exception
     */
    
    public void setPosisi(String posisi) throws Exception {
        this.posisi = String.valueOf(posisi);
    }

    /**
     * @return the usia
     */
    public int getUsia() {
        return usia;
    }

/**
     * @param usia the usia to set
     * @throws java.lang.Exception
     */
    
    public void setUsia(int usia) throws Exception {
        try {
                if (usia<01 || usia>99) {
                    throw new Exception("Harap isi Usia dengan 2 digit angka");
                }
            this.usia = usia;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the kesulitan
     */
    public Kesulitan getKesulitan() {
        return kesulitan;
    }

/**
     * @param kesulitan the kesulitan to set
     * @throws java.lang.Exception
     */
    
    public void setKesulitan(Kesulitan kesulitan) throws Exception {
        try {
             if (usia< 5) {
                throw new Exception("Usia harus lebih dari 5 tahun");
            } 
            this.kesulitan = kesulitan;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       
    }

    /**
     * @return the pendidikanTertinggi
     */
    public String getPendidikanTertinggi() {
        return pendidikanTertinggi;
    }

 /**
     * @param pendidikanTertinggi the pendidikanTertinggi to set
     * @throws java.lang.Exception
     */
    
    public void setPendidikanTertinggi(int pendidikanTertinggi) throws Exception{
        try {
             if (usia< 5) {
                throw new Exception("Usia harus lebih dari 5 tahun");
             }
             if (pendidikanTertinggi>5||pendidikanTertinggi<1){
                    throw new Exception("Harap isi Pendidikan Tertinggi dengan angka 1 sampai 5");
                    }
             
            this.pendidikanTertinggi = String.valueOf(pendidikanTertinggi);
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the pekerjaan
     */
    public Pekerjaan getPekerjaan() {
        return pekerjaan;
    }

 /**
     * @param pekerjaan the pekerjaan to set
     * @throws java.lang.Exception
     */
    
    public void setPekerjaan(Pekerjaan pekerjaan) throws Exception {
      try {
             if (usia< 5) {
                throw new Exception("Usia harus lebih dari 5 tahun");
            }
            this.pekerjaan = pekerjaan;
             
            } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }

    /**
     * @return the usaha
     */
    public Usaha getUsaha() {
        return usaha;
    }

  /**
     * @param usaha the usaha to set
     * @throws java.lang.Exception
     */
    
    public void setUsaha(Usaha usaha) throws Exception {
        try {
             if (usia< 5) {
                throw new Exception("Usia harus lebih dari 5 tahun");
             }
            this.usaha = usaha;
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }  
    }

    /**
     * @return the kepalaKeluarga
     */
    public boolean isKepalaKeluarga() {
        return kepalaKeluarga;
    }

    /**
     * @param kepalaKeluarga the kepalaKeluarga to set
     */
    public void setKepalaKeluarga(boolean kepalaKeluarga) {
        this.kepalaKeluarga = kepalaKeluarga;
    }

    /**
     * @param rutaId the rutaId to set
     */
    public void setRutaId(long rutaId) {
        this.rutaId = rutaId;
    }

}
