/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment06.pkg1;

import java.util.Arrays;

/**
 *
 * @author Mert Yacan
 */
public class Assignment6_3 {

    static int[] twentynums = new int[20];
    static int[] repeatednumindexes = new int[20];
    static int repeatednumloc;

    static void mover(int b) {
        int[] temp = new int[twentynums.length - 1];
        for (int i = 0; i < b; i++) {
            temp[i] = twentynums[i];
        }
        for (int i = 0; i < (twentynums.length) - b - 1; i++) {
            temp[b + i] = twentynums[b + i + 1];
        }
        int templength = twentynums.length;
        twentynums = new int[templength - 1];
        for (int i = 0; i < twentynums.length; i++) {
            twentynums[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        System.out.println("The array is created: ");
        for (int i = 0; i < 20; i++) {
            twentynums[i] = (int) (1 + (Math.random() * 20));
            System.out.print(twentynums[i] + " ");
        }

        System.out.println("\nFinding and storing repeated number indexes...");
        for (int i = 1; i < 21; i++) {
            boolean numfound = false;
            for (int j = 0; j < 20; j++) {
                if (numfound == true) {
                    if (i == twentynums[j]) {
                        repeatednumindexes[repeatednumloc] = j;
                        repeatednumloc++;
                    }
                } else {
                    if (i == twentynums[j]) {
                        numfound = true;
                    }
                }
            }
        }

        System.out.println("\nSorting the repeated number indexes so they wont affect each other when deleted from bigger numbers to the lower ones...");
        //array is bigger than index numbers so its sorted only for the first numbers where the value isnt 0
        Arrays.sort(repeatednumindexes, 0, repeatednumloc);
        System.out.println("\nThese indexes will be deleted...");
        for (int i = repeatednumloc - 1; i > -1; i--) {
            System.out.println(repeatednumindexes[i]);
            mover(repeatednumindexes[i]);
        }

        System.out.println("\nPrinting the cleaned array...");
        for (int i = 0; i < twentynums.length; i++) {
            System.out.print(twentynums[i] + " ");
        }
        System.out.println("\n\nThe length of the array is: " + twentynums.length + "\n");
    }
}
