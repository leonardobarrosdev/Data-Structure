package com.mycompany.staticlist;

import java.util.ArrayList;

/**
 *
 * @author Leonardo Barros
 */
public class Crud {

    private static ArrayList<String> times = new ArrayList<>();
    
    public static void main(String[] args) {

        // 1.1 Questão
        String[] timeList = {"VASCO", "FLAMENGO", "FLUMINENSE", "BOTAFOGO"};
        addTimes(timeList);
        
        // 1.2 Questão
        // System.out.println(print());

        // 1.3 Questão
        // System.out.println(getTime("BOTAFOGO"));

        // 1.4 Questão
        // System.out.println(getTimeByIndex(1));
        
        // 1.5 Questão
        rmTime(2);
        System.out.println(print());
    }
    
    static void addTime(String name) {
        times.add(name);
    }

    static void addTimes(String[] names) {
        for (String name : names) {
            addTime(name);
        }
    }
    
    static String print() {
        return times.toString();
    }

    static String getTime(String name) {
        return (times.contains(name)) ? "Contido" : "Não contido";
    }

    static String getTimeByIndex(int index) {
        return times.get(index);
    }
    
    static void rmTime(int index) {
        times.remove(index);
    }
}
