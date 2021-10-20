package code;

import java.io.FileNotFoundException;

public class Main {

    final private static String parameterFileName = "./src/files/config.txt";
    final private static String codeFileName = "./src/files/text_code.txt";

    // уровень языка программирования
    final private static double languageLevel = 1.53;


    public static void main(String[] args) throws FileNotFoundException {
        Config.readFileConfig(parameterFileName);

        int minCountOperand = Calculations.minCountOperand();
        double potentialScopeProgram = Calculations.potentialScopeProgram(minCountOperand);
        double potentialErrorCount = Calculations.potentialErrorCount(potentialScopeProgram, languageLevel);

        String result = "Миимальное число оперантов: " + minCountOperand + "\n" +
                "Потенциальный объем программы: " + potentialScopeProgram + "\n" +
                "Потенциальное число ошибок: " + potentialErrorCount + "\n";

        System.out.println(String.valueOf(result));
    }
}
