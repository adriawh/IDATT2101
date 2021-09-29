package Assignments.Hash.Oppg2;

public class HashTableLinear extends HashTable {
    public HashTableLinear(int m) {
        super(m);
    }

    /**
     * Add a value to the hashTable
     * @param value the String value to be added
     */
    protected int addValue(int value){
        int h = hash(value);
        for (int i = 0; i<arraySize;i++){
            int j = probe(h,i);
            if(array[j] == 0){
                array[j] = value;
                return j;
            }else{
                collision++;
            }
        }
        return -1; //Full
    }

    protected int probe(int hash, int i) {
        return (hash+i)%arraySize;
    }
}
