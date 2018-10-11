package org.mednov.csv.writer;

import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * создает файл, заполненный случайными целыми числами
 */
public class CsvRandomWriter {
    private CsvWriter csvWriter;
    private Random random;

    public CsvRandomWriter(File file) {
        csvWriter = new CsvWriter(file, new CsvWriterSettings());
        random = new Random(Integer.MAX_VALUE);
    }

    /**
     * пишем в файл заданное
     * @param quantity количество строк
     */
    public void writeRows(Long quantity) {
        for (long i = 0; i <quantity; i++) {
            writeRow();
        }

        csvWriter.close();
    }

    private void writeRow() {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt());
        }
        csvWriter.writeRow(list);

    }
}
