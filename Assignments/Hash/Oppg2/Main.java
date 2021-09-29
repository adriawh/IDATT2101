package Assignments.Hash.Oppg2;

public class Main {
    private static int tall = 10000019;
    //private static int tall = 50051;

    public static void main(String[] args) {

        int tall = 12500003;
        HashTable hashTable = new HashTableDouble(tall);
        HashTable hashTable1 = new HashTableLinear(tall);
        hashTable1.f


        int n= 1;
        while(n<=5){
            switch (n){
                case 1:
                    runTest(0.5);
                    break;
                case 2:
                    runTest(0.8);
                    break;
                case 3:
                    runTest(0.9);
                    break;
                case 4:
                    runTest(0.99);
                    break;
                case 5:
                    runTest(1);
                     break;
                default:
                    System.out.println("Something unexcpected happened");
                    break;

            }
            n++;
        }
        System.out.println("**TESTS FINISHED**");
    }

    private static void runTest(double p){
        System.out.println("Prosent: "+p*100 + "%\n");
        Assignments.Hash.Oppg2.HashTable hashTableDouble = new HashTableDouble(tall, p);
        hashTableDouble.printData();
        Assignments.Hash.Oppg2.HashTable hashTableLinear = new HashTableLinear(tall, p);
        hashTableLinear.printData();
        HashTable hashTableSquared = new HashTableSquared(tall, p);
        hashTableSquared.printData();
    }
}
