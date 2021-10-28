package code;

import java.util.ArrayList;

public class DevelopRating {
    private static final int BASE_RATING = 1000;

    private ArrayList<ProgramInfo> completedPrograms = new ArrayList<>();

    public static void main(String[] args) {
        DevelopRating programmerRating = new DevelopRating();
        programmerRating.addProgram(new ProgramInfo(ProgramInfo.LEVEL_ADA, 5, 0));
        programmerRating.addProgram(new ProgramInfo(ProgramInfo.LEVEL_ADA, 7, 2));
        programmerRating.addProgram(new ProgramInfo(ProgramInfo.LEVEL_ADA, 9, 5));
        programmerRating.addProgram(new ProgramInfo(ProgramInfo.LEVEL_ADA, 11, 4));

        System.out.println("c(λ,R) = 1/(λ*R)");
        programmerRating.printRating(1);
        System.out.println("c(λ,R) = 1/(λ+R)");
        programmerRating.printRating(2);
        System.out.println("c(λ,R) = 1/λ * 1/R");
        programmerRating.printRating(3);

        ProgramInfo newProgram = new ProgramInfo(ProgramInfo.LEVEL_ADA, 15, 0);
        System.out.println("Expected errors: " +
                programmerRating.calcC(3, newProgram.getLanguageLevel(),
                        programmerRating.completedPrograms.size()) * newProgram.getSizeInKB());
    }

    private void addProgram(ProgramInfo program){
        completedPrograms.add(program);
    }

    private void printRating(int type){
        for (int i = 0; i <= completedPrograms.size(); i++){
            System.out.println("Рейтинг разработчика, " + i + " программа: " + getRating(i - 1, type));
        }
    }

    private float getRating(int programIndex, int type){
        if(programIndex < 0)
            return BASE_RATING;

        return getRating(programIndex - 1, type) *
                Math.abs(1 + (getSumOfProgramSize(programIndex) - calcSumOfErrors(programIndex, type))/1000);
    }

    private float getSumOfProgramSize(int programIndex){
        float result = 0;
        for (int i = 0; i <= programIndex; i++){
            result += completedPrograms.get(i).getSizeInKB();
        }

        return result;
    }

    private float calcSumOfErrors(int programIndex, int type){
        float result = 0;
        for (int i = 0; i <= programIndex; i++){
            ProgramInfo completedProgram = completedPrograms.get(i);
            result += completedProgram.getErrors() / calcC(type, completedProgram.getLanguageLevel(), i);
        }

        return result;
    }

    private float calcC(int type, float languageLevel, int programIndex){

        if (type == 1) {
            return 1 / (languageLevel * getRating(programIndex - 1, type));
        }

        if (type == 2) {
            return 1 / (languageLevel + getRating(programIndex - 1, type));
        }

        if (type == 3) {
            return 1 / languageLevel + 1 / getRating(programIndex - 1, type);
        }

        return 1;
    }
}
