package org.mednov.csv.writer;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StartWriter {

    public static void main(String[] args) {
        int n = 2;
        for (int i = 1; i <= n; i++) {
            File f = new File(String.format("./files/file_%d.csv", (i)));

            f.getParentFile().mkdirs();
            try {
                f.createNewFile();
                long millisStart = System.currentTimeMillis();
                CsvRandomWriter csvRandomWriter = new CsvRandomWriter(f);
                csvRandomWriter.writeRows(100000L);
//                csvRandomWriter.writeRows(200L);
                long millisStop = System.currentTimeMillis();
                System.out.println("File " + i + " from "
                        + n + ", time taken to fill file:"
                        + TimeUnit.MILLISECONDS.toSeconds(millisStop - millisStart)
                        + "seconds.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
