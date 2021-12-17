package Assignments.five.Oppg1;

public class Main {

    public static void main(String[] args) {
        HashTable table = new HashTable(128);

        String personSomSkalFinnes = "Marius Klemp Petersen";

        System.out.println("\n** Position of: "+ personSomSkalFinnes  +" ** \n" +
                table.findPosition(personSomSkalFinnes) + "\n");

        System.out.println("Load factor: " + table.calculateLoadFactor());

        System.out.println("Average collisions per element: " + table.getAverageCollisions());
    }
}
