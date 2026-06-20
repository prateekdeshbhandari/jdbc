package com.xworkz.softer_data.runner;

import com.xworkz.softer_data.Dao.SoftwareDAO;
import com.xworkz.softer_data.Dao.impl.SoftwareDAOImpl;
import com.xworkz.softer_data.Dto.SoftwareDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;

public class SoftwareRunner {

    public static void main(String[] args) {

        try {

            FileInputStream fis =
                    new FileInputStream("C:\\Users\\Prateek DeshBhandari\\OneDrive\\Desktop\\X-works Intenship\\JDBC\\software.xlsx");

            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            SoftwareDAO dao = new SoftwareDAOImpl();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

              Row row = (Row) sheet.getRow(i);

                String softwareName = row.getCell(0).getStringCellValue();
                int currentVersion = (int) row.getCell(1).getNumericCellValue();
                int developedYear = (int) row.getCell(2).getNumericCellValue();
                String developedBy = row.getCell(3).getStringCellValue();
                String openSource = row.getCell(4).getStringCellValue();

                SoftwareDTO dto = new SoftwareDTO();

                dto.setSoftwareName(softwareName);
                dto.setCurrentVersion(currentVersion);
                dto.setDevelopedYear(developedYear);
                dto.setDevelopedBy(developedBy);
                dto.setOpenSource(openSource);

                dao.save(dto);
            }

            workbook.close();
            fis.close();

            System.out.println("Data inserted successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}