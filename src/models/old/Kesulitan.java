package models.old;

/**
 *
 * @author zein
 */
public class Kesulitan {
    private String kesulitan;

    public Kesulitan(String kesulitan) {
        this.kesulitan = kesulitan;
    }

    /**
     * @param jenisKesulitan
     * @return the kesulitan
     * @throws java.lang.Exception
     */
    
    //INI BELOM ADA SETTER BUAT JENIS KESULITAN AKHIRE TAK BUAT//
    
   //(zein ini hasil kodingan astri dan ninis) 
    public void setJenisKesulitan(int jenisKesulitan) throws Exception {
        try {
            if (jenisKesulitan<01||jenisKesulitan>10){
                throw new Exception("Harap isi Jenis Kesulitan dengan angka 01 sampai 10");
            }
            
            this.kesulitan = String.valueOf(jenisKesulitan);
            } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * @return the kesulitan
     */
    public String getKesulitan() {
        return kesulitan;
    }
}
