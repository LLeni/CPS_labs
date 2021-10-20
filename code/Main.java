package code;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    final private static String parameterFileName = "./src/files/config.txt";
    final private static String codeFileName = "./src/files/text_code.txt";

    // число одновременно сопровождаемых целей
    private static Integer goalCount = 20;

    // количество измерений каждого отслеживаемого параметра, которое необходимо для поражения каждой цели
    private static Integer measurementCount = 30;

    // количество отслеживаемых параметров
    private static Integer parameterCount = 10;

    // количество рассчитываемых параметров по каждой цели, передаваемых системе уничтожения
    private static Integer parameterForEachGoalCount = 3;

    private static void readFile() throws FileNotFoundException {
        FileReader file = new FileReader(parameterFileName);
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("=");
            if (!line[1].matches("\\d+")) {
                System.out.println("ERROR! Параметр '" + line[1] + "' не является числом!");
                continue;
            }

            switch (line[0]) {
                case "goalCount":
                    goalCount = Integer.parseInt(line[1]);
                    break;
                case "measurementCount":
                    measurementCount = Integer.parseInt(line[1]);
                    break;
                case "parameterCount":
                    parameterCount = Integer.parseInt(line[1]);
                    break;
                case "parameterForEachGoalCount":
                    parameterForEachGoalCount = Integer.parseInt(line[1]);
                    break;
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        readFile();

        System.out.println(goalCount);
        System.out.println(measurementCount);
        System.out.println(parameterCount);
        System.out.println(parameterForEachGoalCount);
    }
}
