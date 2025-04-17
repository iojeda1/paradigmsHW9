import java.util.*;
import java.io.*;
import java.nio.*;

public class FileParserTask implements Runnable {
    private File folder;
    private Map<String, Integer> namesCount;
    private Map<String, Integer> occupationCount;

    public FileParserTask(File folder, Map<String, Integer> namesCount, Map<String, Integer> occupationCount) {
        this.folder = folder;
        this.namesCount = namesCount;
        this.occupationCount = occupationCount;
    }

    @Override
    public void run() {
        String row;
        try (BufferedReader reader = new BufferedReader(new FileReader(folder))) {
            reader.readLine();
            while ((row = reader.readLine()) != null) {
                String[] cols = row.split(",");
                String job = cols[1].trim();
                String name = cols[3].trim();
                if (namesCount.containsKey(name)) {
                    namesCount.put(name, namesCount.get(name) + 1);
                } else {
                    namesCount.put(name, 1);
                }

                if (occupationCount.containsKey(job)) {
                    occupationCount.put(job, occupationCount.get(job) + 1);
                } else {
                    occupationCount.put(job, 1);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
