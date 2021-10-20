package code;

public class Calculations {
    public static int minCountOperand () {

        // количество входных параметров
        int nIn = Config.parameterCount * Config.measurementCount * Config.goalCount;

        // количество выходных параметров
        int nOut = Config.parameterForEachGoalCount * Config.goalCount;

        // минимальное количество параметров
        int n2 = nIn + nOut;

        return n2;
    }

    public static double potentialScopeProgram (int minCountOperand) {
        return (minCountOperand + 2) * (Math.log(minCountOperand+2) / Math.log(2));
    }

    public static double potentialErrorCount (double potentialScopeProgram, double languageLevel) {
        return Math.pow(potentialScopeProgram, 2) / (3000 * languageLevel);
    }
}
