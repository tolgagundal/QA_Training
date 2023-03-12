import java.sql.*;

public class JDBC01_Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1 - İlgili driver'i yuklemeliyiz. MySQL kullandigimizi bildiriyoruz.

        Class.forName("com.mysql.jdbc.Driver to com.mysql.cj.jdbc.Driver.");

        // 2- Baglantiyi olusturmak icin username ve password girmeliyiz.
        // username ve password'un yanlis olma ihtimaline karsi SQL exception firlatmamizi istiyor.

        DriverManager Manager = null;
        Connection con = DriverManager.getConnection(   "jdbc:mysql://localhost:3306/sys?serverTimezone=UTC");

        // 3- SQL query'ler icin bir Statement objesi olsuturup JAVA'da SQL sorgulari icin bir alan acacagiz.

        Statement st = con.createStatement();

        // 4- SQL query'leri yazip calistirabiliriz.

       ResultSet veri =  st.executeQuery("SELECT * FROM personel");

        // Sonuclari gormek icin iteration ile Set icindeki elemanlari
        // while dongusu ile yazdiriyoruz.

        while (veri.next()){
            System.out.println(veri.getString(1+ " " + veri.getString(2) + " "
                    + veri.getString(3) + " " + veri.getString(4) + " "
                    + veri.getString(5)));

        }

        // Olusturulan baglantilari kapatiyoruz.

        con.close();
        st.close();
        veri.close();

    }


}
