package Lab2;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    //Считывает интервалы между ошибками в проекте из указанного файла
    public static ArrayList<Integer> readErrorsIntervals(String pathname){
        ArrayList<Integer> errorsIntervals = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(pathname)))) {
            String line = reader.readLine();
            while (line != null) {
                errorsIntervals.add(Integer.valueOf(line));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return errorsIntervals;
    }
}
