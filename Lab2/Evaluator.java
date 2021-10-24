package Lab2;

import java.util.ArrayList;

public class Evaluator {
    private ArrayList<Integer> errorsIntervals;
    private int countIntervals;
    private int sum, sumConsiderIndexes; //промежуточные значения
    private double minB, maxB; //границы отрезка

    //Содержат итоговые результаты уравнений
    private double B = Double.MIN_VALUE, K = Double.MIN_VALUE, X = Double.MIN_VALUE, T = Double.MIN_VALUE;

    Evaluator(ArrayList<Integer> errorsIntervals) {
        this.errorsIntervals = errorsIntervals;
        countIntervals = errorsIntervals.size();
    }
}