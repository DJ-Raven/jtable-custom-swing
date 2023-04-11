package table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVDataReader {
    public ArrayList<CSVData> retrieveCSVData() {

        final String path = getClass().getResource("/test.csv").toString();
        String line = "";
        ArrayList<CSVData> listOfData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                String[] lastVal = data[4].split(" ");
                CSVData csvData = new CSVData(Integer.parseInt(data[0].trim()), data[1].trim(), data[2].trim(),
                        Integer.parseInt(data[3].trim()), Integer.parseInt(lastVal[1]));
                listOfData.add(csvData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfData;
    }
}
