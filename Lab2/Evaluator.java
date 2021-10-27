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

    // Позволяет отобразить все найденные значения
    public void showResults(){
        if(B == Double.MIN_VALUE){
            System.out.println("Ошибка! Еще не производился расчет");
        } else {
            System.out.println("\nРезультаты");
            System.out.printf("%-40s%25f ошибок","Общее число ошибок ",B);
            System.out.printf("%n%-40s%25f", "Коэффициент пропорциональности", K);
            System.out.printf("%n%-40s%25f д.", "Среднее время до появление ошибки ", X);
            System.out.printf("%n%-40s%25f д.", "Время до окончания тестирования ", T);
        }
    }

    //Расчитывает общее число ошибок
    public void calculateB(){
        defineMinMaxB();

        double currentB = 0;
        while((maxB - minB) >= 0.001){
            currentB = (minB + maxB)/ 2;
            if(calculateVerisimilitude(currentB) < 0){
                maxB = currentB;
            } else {
                minB = currentB;
            }
        }

        B = currentB;
    }

    //Определяет минимальное и максимальное значения B
    private void defineMinMaxB(){
        minB = errorsIntervals.size();
        maxB = 100;


        //Расчитывает различные промежуточные суммы, которые понадобятся для
    //оценки максимального правдоподобия величины B
    private void calculateSums(){
        for (int i = 0; i < countIntervals; i++) {
            sum += errorsIntervals.get(i);
            sumConsiderIndexes += errorsIntervals.get(i) * (i+1);
        }
    }
}