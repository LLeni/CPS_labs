package code;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Config {

    // число одновременно сопровождаемых целей
    public static int goalCount = 20;

    // количество измерений каждого отслеживаемого параметра, которое необходимо для поражения каждой цели
    public static int measurementCount = 30;

    // количество отслеживаемых параметров
    public static int parameterCount = 10;

    // количество рассчитываемых параметров по каждой цели, передаваемых системе уничтожения
    public static int parameterForEachGoalCount = 3;

    // количество программистов
    public static int developerCount = 4;

    // количество отлаженных команд
    public static int commandCount = 20;

    // количество рабочих часов
    public static int hourCount = 8;

    public static void readFileConfig(String parameterFileName) throws FileNotFoundException {
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
                case "developerCount":
                    developerCount = Integer.parseInt(line[1]);
                    break;
                case "commandCount":
                    commandCount = Integer.parseInt(line[1]);
                    break;
                case "hourCount":
                    hourCount = Integer.parseInt(line[1]);
                    break;
            }
        }
    }
}
