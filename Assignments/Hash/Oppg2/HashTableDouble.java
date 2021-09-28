package Assignments.Hash.Oppg2;

public class HashTableDouble extends HashTable {

    public HashTableDouble(int m) {
        super(m);
    }

    @Override
    protected int addValue(int value) {
        int hashVal = hashOne(value); // hash the key
        int stepSize = hashTwo(value); // get step size
        // until empty cell or -1
        while (array[hashVal] <= 0 && array[hashVal] != -1) {
            hashVal += stepSize; // add the step
            hashVal %= arraySize; // for wraparound
        }
        hashArray[hashVal] = item; // insert item
    }

    protected int probe(int h1, int h2, int i) {
        return (h1 + i*h2) % arraySize;
    }

    private int hashOne(int value){
        return value % arraySize;
    }

    private int hashTwo(int value){
        return (value % arraySize-1) + 1;
    }


}


