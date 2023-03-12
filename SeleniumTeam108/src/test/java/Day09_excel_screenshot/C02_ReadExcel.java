package Day09_excel_screenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/test/java/Day09_excel_screenshot/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        // 1.satir 2. hucreye git ve yazdir
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        // Bunu bir degiskene atayalim
        String istenenData = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(istenenData);

        // 2. satir 4. cell'in afganistan'in baskenti oldugunu test edelim.

        String expectedData = "Kabil";
        String actualData = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedData, actualData);

        // satir sayisini bulalim - getLastRowNum()

        System.out.println("Satir sayisi " + (workbook.getSheet("Sayfa1").getLastRowNum() + 1));

        // sayfa2'dekis satiri sayisi ve Fiziki olarak kullanilan satir sayiini bulun
        System.out.println("Sayfa2 Satir sayisi " + (workbook.getSheet("Sayfa2").getLastRowNum() + 1));

        System.out.println("Sayfa2 Satir sayisi " + (workbook.getSheet("Sayfa2").getLastRowNum() + 1));

        System.out.println("Sayfa2 Physical kullanilan satir sayisi " + (workbook.getSheet("Sayfa2").getPhysicalNumberOfRows() + 1));

        // Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim.

        Map<String, String> ulkelerMap = new TreeMap<>();

        int sonSatirIndexi = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 1; i <= sonSatirIndexi; i++) { // basligi almamak icin 1'den baslatttim.

            String ulke = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String baskent = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            ulkelerMap.put(ulke, baskent);
        }

        System.out.println(ulkelerMap);

    }
}
