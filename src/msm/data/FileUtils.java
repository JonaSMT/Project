package msm.data;

import java.util.List;

/**
 * This is a Interface generate two method to write on file and read
 */
public interface FileUtils {
    void readData(String name, List<String> list);
    void writeData(String name, List<String> list2);
}
