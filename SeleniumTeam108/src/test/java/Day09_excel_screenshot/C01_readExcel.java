package Day09_excel_screenshot;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_readExcel {

    @Test
    public  void test01() throws IOException {

        // 1- Excel dosyasinin kopyasini olustur.
        String dosyaYolu = "src/test/java/Day09_excel_screenshot/ulkeler.xlsx";

        // 2- Dosya yolunu olusturdugumuz excel'den bilgileri almak icin
        // FileInputStream objesi olusturmaliyiz.

        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 3- Bilgilerini aldigimiz excelde calisma yapabilmek icin kopya workbook olustur

        Workbook workbook = WorkbookFactory.create(fis);

        // PC^deki exceldeki tum bilgiler artik woorkbook obj kayitli
        // excel'in yapisi geregi, sirayla;
        // 1-istenen sayfa,
        // 2-istenen satir
        // 3-istenen hucre olusuturulmalidir.

        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        Row row = sayfa1.getRow(11);
        Cell cell = row.getCell(2);

        System.out.println(cell);

        String expectedData = "Azerbaycan";
        String actualData = cell.toString();

        Assert.assertEquals(expectedData,actualData);

    }


}
