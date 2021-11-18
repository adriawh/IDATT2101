package Assignments.five.Oppg2;

public class HashTableDouble extends HashTable {

    public HashTableDouble(int m, double prosent) {
        super(m, prosent);
    }

    @Override
    protected int addValue(int value) {
        int h1 = hashOne(value);
        int h2;
        int pos = h1;

        if (array[pos] == 0) {
            array[pos] = value;
            return pos;
        } else {
            h2 = hashTwo(value);
            while (array[pos] != 0) {
                collision++;
                pos = probe(pos, h2);
                if (array[pos] == 0) {
                    array[pos] = value;
                    return pos;
                }
            }
        }
        return -1; //Full
    }

    protected int probe(int pos, int h2) {
        return (pos + h2) % arraySize;
    }

    private int hashOne(int value) {
        return value % arraySize;
    }

    private int hashTwo(int value){
        return (value % arraySize-1) + 1;
    }


}


