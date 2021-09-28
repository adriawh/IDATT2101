package Assignments.Hash.Oppg2;

import Assignments.Hash.Oppg1.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public abstract class HashTable {

    protected int[] array;
    protected int arraySize;

    private int collision = 0;
    protected int numberOfNames = 0;

    public HashTable(int m){
        arraySize = m;
        array = new int[m];
        fillTableRandomNumbers();
    }

    /**
     *
     * @return the average collisons each element
     */
    public double getAverageCollisions(){
        return (double) collision/numberOfNames;
    }




    /**
     *
     * @param k integer based on the string
     * @return an index for the string
     */
    protected int hash(int k){
        return k % arraySize;
    }

    protected abstract int addValue ( int value);

    /**
     * Method for reading navn.txt and adding the values to the list.
     */
    public void fillTableRandomNumbers(double prosent){
        int[] originalArray = new int[(int)Math.round(12500003*prosent)];
        int tall= 0;
        Random rand = new Random();
        for(int i = 0; i<originalArray.length; i++){
            tall+= 1 + rand.nextInt(1000);
            originalArray[i] = tall;
        }
        for (int i = 0; i < originalArray.length; i++) {
            int randomIndexToSwap = rand.nextInt(originalArray.length);
            int temp = originalArray[randomIndexToSwap];
            originalArray[randomIndexToSwap] = originalArray[i];
            originalArray[i] = temp;
        }
        for (int i = 0; i<originalArray.length; i++){
            addValue(originalArray[i]);
        }
    }
    public double calculateLoadFactor(){
        return (double) numberOfNames/arraySize;
    }
}
