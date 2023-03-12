import java.sql.*;

public class JDBC02_execute_Update {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
    A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
       dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC'de 2 alternatif bulunmaktadir.
        1) execute() metodu - - - Boolean dondurur.
        2) executeUpdate() metodu. - - - Int deger dondurur.

    B) - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
       - execute(), Boolean bir deger dondurur. DDL islemlerinde false dondururken,
         DML islemlerinde true deger dondurur.
       - Ozellikle, hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi
         durumlarda tercih edilmektedir.

    C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
       - bu islemlerde islemden etkilenen satir sayisini dondurur.
       - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
 */

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();

    /*======================================================================
            ORNEK1: ogrenciler tablosunu siliniz.
     ========================================================================*/

        String dropQuery = "DROP TABLE ogrenciler1";

        // System.out.println(st.execute(dropQuery));

      /*  if(st.execute(dropQuery)) {
            System.out.println("Ogrenciler tablosu silindi.");
        } else
            System.out.println("Tablo silinemedi.");


       */

        /*=======================================================================
          ORNEK2: isciler adinda bir tablo olusturunuz id int,
          birim VARCHAR(10), maas int
        ========================================================================*/

        String createTable = "CREATE TABLE isciler" +
                "(id INT, " +
                "birim VARCHAR(10), " +
                "maas INT)";


        if (!st.execute(createTable)) {
            System.out.println("Isciler tablosu olusturuldu.");
        }

        String insertData = "INSERT INTO isciler VALUES (80, 'ARGE', 4000)";

        System.out.println("Islemden etkilenen satir sayisi" + st.executeUpdate(insertData));

/*=======================================================================
          ORNEK4: isciler tablosuna birden fazla yeni kayıt ekleyelim.
            INSERT INTO isciler VALUES(70, 'HR', 5000)
            INSERT INTO isciler VALUES(60, 'LAB', 3000)
            INSERT INTO isciler VALUES(50, 'ARGE', 4000)
         ========================================================================*/

        String [] queries = { "INSERT INTO isciler VALUES(70, 'HR', 5000)",
                                "INSERT INTO isciler VALUES(60, 'LAB', 3000)",
                                 "INSERT INTO isciler VALUES(50, 'ARGE', 4000)"};

            int count =0;
        for (String each : queries) {

            count += st.executeUpdate(each);
        }

        System.out.println(count + " adet satir eklendi.");

        /*=======================================================================
          ORNEK4: isciler tablosuna goruntuleyin.
         ========================================================================*/

        String selectQuery = "SELECT * FROM isciler";

        ResultSet iscilerTablosu = st.executeQuery(selectQuery);

        while(iscilerTablosu.next()) {
            System.out.println(  iscilerTablosu.getInt(1) + " " +
                    iscilerTablosu.getString(2) + " " +
                    iscilerTablosu.getInt(3));

            // Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin
            // yavas yapilmasina yol acar. 10000 tane veri kaydi yapildigi dusunuldugunde
            // bu kotu bir yaklasimdir.


// System.out.println("=============== 2. Yontem ==============");
            // 2.YONTEM (addBatch ve executeBatch() metotlari ile)
            // ----------------------------------------------------
            // addBatch metodu ile SQL ifadeleri gruplandirilabilir ve executeBatch()
            // metodu ile veritabanina bir kere gonderilebilir.
            // executeBatch() metodu bir int [] dizi dondurur. Bu dizi her bir ifade sonucunda
            // etkilenen satir sayisini gosterir.


            String [] queries2 = {"INSERT INTO isciler VALUES(10, 'TEKNIK', 3000)",
                    "INSERT INTO isciler VALUES(20, 'KANTIN', 2000)",
                    "INSERT INTO isciler VALUES(30, 'ARGE', 5000)"};

            //for (String each : queries2) {
              //  count += st.addBatch(each);

        }
            st.executeBatch();

            System.out.println("Satirlar eklendi.");

            /*=======================================================================
            ORNEK6: isciler tablosundaki maasi 5000'den az olan iscilerin maasina
             %10 zam yapiniz
             ========================================================================*/

            String updateQuery = "UPDATE isciler SET maas=maas*1.1 WHERE maas<5000";

            int satir = st.executeUpdate(updateQuery);

            System.out.println(satir + " Satir guncellendi!");

            // guncellenip guncellenmedigini SELECT ile gorebiliriz.

            ResultSet iscilerTablosu2 = st.executeQuery(selectQuery);

            while(iscilerTablosu.next()) {
                System.out.println(iscilerTablosu2.getInt(1) + " " +
                        iscilerTablosu.getString(2) + " " + iscilerTablosu2.getInt(3));
            }

            // İscileri siliniz.

            String deleteQuery = "DELETE FROM isciler WHERE birim='ARGE'";

            int silinenSatirSayisi=st.executeUpdate(deleteQuery);

            System.out.println(silinenSatirSayisi);


            con.close();
            st.close();
            iscilerTablosu.close();
            iscilerTablosu2.close();


        }
    }

