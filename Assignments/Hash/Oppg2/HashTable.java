package Assignments.Hash.Oppg2;

import java.util.Random;

public abstract class HashTable {

    protected int[] array;
    protected int arraySize;
    protected int[] generatedArray;

    protected int collision = 0;
    protected int numberOfNames = 0;

    public HashTable(int m){
        arraySize = m;
        array = new int[m];
        fillTableRandomNumbers();
    }

    public abstract void printData();


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
        return originalArray;
    }

    /**
     *
     * @param array array to populate hashTable
     * @return time used to fill the hashTable
     */
    public long fillHashTable(int[] array){

        long start = System.currentTimeMillis();
        for (int i = 0; i<array.length; i++){
            if (array[i] <1){
                System.out.println(array[i]);
            }
            addValue(array[i]);
        }
        long end = System.currentTimeMillis();
        return end-start;
    }
    public double calculateLoadFactor(){
        return (double) numberOfNames/arraySize;
    }
}
