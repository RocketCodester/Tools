import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayMethods {
    static ArrayList al = new ArrayList();
    
    //Test the three ways of populating arrays
    public void testArrayPopulation(int size) {
        populate(size);
        depopulate(size);
        populate(size);
        depopulateAscend(size);
        populate(size);
        depopulateRandomly(size);
    }

    //Adds elements to an array list
    public static void populate(int size) {
        for (int i = 0; i < size; i++) {
            al.add(i);
        }
    }

    //Removes elements from the array list in descending order
    public void depopulate(int size) {
        System.out.println(al);
        for (int i = 0; i < size; i++) {
            al.remove(size - 1 - i);
            System.out.println(al);
        }
    }

    //Removes elements from the array list in ascending order
    public void depopulateAscend(int size) {
        System.out.println(al);
        for (int i = 0; i < size; i++) {
            al.remove(0);
            System.out.println(al);
        }
    }

    //Removes elements from the array list randomly
    public void depopulateRandomly(int size) {
        int ousted;
        System.out.println(al);
        for (int i = size; i > 0; i--) {
            ousted = ThreadLocalRandom.current().nextInt(0, i);
            al.remove(ousted);
            System.out.println(al);
        }
    }
}
