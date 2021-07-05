package listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tests.BaseTest;

public class Excel extends BaseTest{

	private Excel() {
	}
	public static List<Map<String, String>> getTestDetails() {
		List<Map<String, String>> list = new ArrayList<>();
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(prop.getProperty("excel_file"));
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheetAt(0);

			Map<String, String> map = null;

			int lastrownum = sheet.getLastRowNum();
			int lastcolnum = sheet.getRow(0).getLastCellNum();

			for (int i = 1; i <= lastrownum; i++) {
				map = new HashMap<String, String>();
				for (int j = 0; j < lastcolnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(Objects.nonNull(fs))
				fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.print(list);
	
		return list;
	}
}
