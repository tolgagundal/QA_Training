package Day09_excel_screenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_writeExcel {

    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/test/java/Day09_excel_screenshot/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        sayfa1.getRow(0).createCell(4).setCellValue("Nufus");
        sayfa1.getRow(1).createCell(4).setCellValue(150000);
        sayfa1.getRow(9).createCell(4).setCellValue(250000);
        sayfa1.getRow(14).createCell(4).setCellValue(54000);

        FileOutputStream fos = new FileOutputStream(dosyaYolu); // dosyayi kaydet.
        workbook.write(fos);

        fis.close();
        fos.close();
        workbook.close();

    }
}
