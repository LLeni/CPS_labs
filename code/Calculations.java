package code;

public class Calculations {

    /**
     * Минимальное число операндов
     * */
    public static int minCountOperand () {

        // количество входных параметров
        int nIn = Config.parameterCount * Config.measurementCount * Config.goalCount;

        // количество выходных параметров
        int nOut = Config.parameterForEachGoalCount * Config.goalCount;

        // минимальное количество параметров
        return nIn + nOut;
    }

    /**
     * Потенциальный объем программы
     * */
    public static double potentialScopeProgram (int minCountOperand) {
        return (minCountOperand + 2) * (Math.log(minCountOperand+2) / Math.log(2));
    }

    /**
     * Потенциальное число ошибок
     * */
    public static double potentialErrorCount (double potentialScopeProgram, double languageLevel) {
        return Math.pow(potentialScopeProgram, 2) / (3000 * languageLevel);
    }

    /**
     * Количество модулей
     * */
    public static double moduleCount(int minCountOperand) {
        double moduleCount = Double.parseDouble(String.valueOf(minCountOperand))/8;

        if (moduleCount > Main.moduleCountDefault) {
            return moduleCount + Double.parseDouble(String.valueOf(minCountOperand))/(Math.pow(Main.moduleCountDefault, 2));
        }

        return moduleCount;
    }

    /**
     * Расчет длины программы
     * */
    public static double programLength(double moduleCount) {
        return 220 * moduleCount + moduleCount * (Math.log(moduleCount)/Math.log(2));
    }

    /**
     * Расчет объема ПО
     * */
    public static double programVolume(double moduleCount) {
        return moduleCount * 220 * (Math.log(48)/Math.log(2));
    }

    /**
     * Расчет количества команд ассемблера
     * */
    public static double commandCountAssembler(double programLength) {
        return Config.parameterForEachGoalCount * programLength/8;
    }

    /**
     * Расчет календарного времени программирования
     * */
    public static double programTime(double programLength) {
        return Config.parameterForEachGoalCount * programLength / (8 * Config.developerCount * Config.commandCount);
    }

    /**
     * Расчет начального количества ошибок
     * */
    public static double errorCount(double programVolume) {
        return programVolume / 3000;
    }

    /**
     * Расчет начальной надежности ПО (времени наработки на отказ)
     * */
    public static double programReliability(double programTime, double errorCount) {
        return programTime * 8 / (2 * Math.log(errorCount));
    }
}
