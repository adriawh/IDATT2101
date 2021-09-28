package Assignments.Hash.Oppg2;

public class HashTableSquared extends HashTable{
    public HashTableSquared(int m) {
        super(m);
    }


    /**
     * Add a value to the hashTable
     * @param value the String value to be added
     */
    protected int addValue(int value){
        int h = hash(value);
        for (int i = 0; i<arraySize;++i){
            int j = probe(h,i);
            if(array[j] == 0){
                array[j] = value;
                return j;
            }
        }
        return -1; //Full
    }

    protected int probe(int hash, int i) {
        int k1 = 5;
        int k2 = 7;
        return (int) (hash+k1*i+k2*Math.pow(i,2)%arraySize);
    }
}
