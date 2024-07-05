package mnenobot.lnclib;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public abstract class AbstractCSVReader {
    /*
    * Этот метод используется для чтения csv файло построчно по
    * @param fileName название файла который мы планируем считывать
    * @param skipHeader пропускаем первую строку с аннотацией столбцов
    * @return String[] Row возвращает коллекцию считанных строк
    *
    * */
    public void readDataLineByLine(String fileName) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException("Файл не найден: " + fileName);
            }

            InputStreamReader reader = new InputStreamReader(is);

            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).build();

            List<String[]> allData = csvReader.readAll();
            boolean skipHeader = true;
            for (String[] row : allData) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                processRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void processRow(String[] row);
}
