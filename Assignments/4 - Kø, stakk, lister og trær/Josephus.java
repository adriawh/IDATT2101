package Assignments.four;

public class Josephus {

    public static void main(String[] args) {

        int numberOfPeople = 40;
        int interval = 3;

        System.out.println("*** The Josephus problem ***");
        System.out.println("Number of people: " + numberOfPeople +
                "\nInterval: " + interval +
                "\nSurvivor: number " + josephus(numberOfPeople,interval) );

    }

    /**
     * Method for solving the Josephus problem
     *
     * "People are standing in a circle waiting to be executed. Counting begins at a specified point
     * in the circle and proceeds around the circle in a specified direction. After a specified number
     * of people are skipped, the next person is executed. The procedure is repeated with the remaining
     * people, starting with the next person, going in the same direction and skipping the same number
     * of people, until only one person remains, and is freed." -wikipedia
     *
     * @param m number of people in line
     * @param n interval size
     * @return the placement that would survive.
     */
    private static int josephus(int n, int m){
        CircularList l = new CircularList();

        for(int i = 1; i<=n; i++){//generating a circular list with the specified count m
            l.addNode(i);
        }

        Node current = l.getHead();
        do{

            if (m > 2) {
                for(int i = 0; i<m-2; i++){//iterating to the correct node
                    current = current.getNext();
                }
            }
            if(current.getNext()==l.getHead()){//if removing the head, asign new head.
                l.setHead(current.getNext().getNext());
            }
            if(current.getNext() == l.getTail()){//if removing the tail, asign new tail.
                l.setTail(current);
            }

            current.setNext(current.getNext().getNext());//remove

            current = current.getNext();//iterating

        } while(l.getHead() != l.getTail());

        return l.getHead().getValue();
    }
}
