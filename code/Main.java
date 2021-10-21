package code;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class Main {

    final private static String parameterFileName = "./src/files/config.txt";

    // уровень языка программирования
    final private static double languageLevel = 1.53;

    // количество модулей по дефолту
    final public static int moduleCountDefault = 8;


    public static void main(String[] args) throws FileNotFoundException {
        Config.readFileConfig(parameterFileName);

        int minCountOperand = Calculations.minCountOperand();
        double potentialScopeProgram = Calculations.potentialScopeProgram(minCountOperand);
        double potentialErrorCount = Calculations.potentialErrorCount(potentialScopeProgram, languageLevel);
        double moduleCount = Calculations.moduleCount(minCountOperand);
        double programLength = Calculations.programLength(moduleCount);
        double programVolume = Calculations.programVolume(moduleCount);
        double commandCountAssembler = Calculations.commandCountAssembler(programLength);
        double programTime = Calculations.programTime(programLength);
        double errorCount = Calculations.errorCount(programVolume);
        double programReliability = Calculations.programReliability(programTime, errorCount);

        String result = "Миимальное число оперантов: " + minCountOperand + "\n" +
                "Потенциальный объем программы: " + format(potentialScopeProgram) + "\n" +
                "Потенциальное число ошибок: " + format(potentialErrorCount) + "\n\n" +
                "Количество модулей: " + format(moduleCount) + "\n" +
                "Длина программы: " + format(programLength) + "\n" +
                "Объем программного обеспечения: " + format(programVolume) + "\n" +
                "Количество команд ассемблера: " + format(commandCountAssembler) + "\n" +
                "Календарное время программирования: " + format(programTime) + "\n" +
                "Начальное количество ошибок: " + format(errorCount) + "\n" +
                "Начальная надежность ПО (время наработки на отказ): " + programReliability + " дней и "
                                            + format(programReliability / Config.hourCount) + " часов \n";

        System.out.println(result);
    }

    private static String format(double number) {
        return new DecimalFormat("#0.00").format(number);
    }
}
