package Java_Built_In_Sorting;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

/*
Java provides built-in sorting methods that allow efficient sorting 
of arrays, lists, and objects without manually implementing sorting 
algorithms. The primary methods used are Arrays.sort() for arrays 
and Collections.sort() for lists.
*/

/*
1. Arrays.sort() : Used to sort arrays in ascending order
2. Collections.sort() : Used to sort lists such as ArrayList.
3. Descending Order Sorting :
 - For Object Arrays : Arrays.sort(arr, Collections.reverseOrder());
 - For ArraysList : Collections.sort(arr, Collections.reverseOrder());
*/

/*
A Comparator is a custom rule that defines how two elements should be compared during sorting.
Syntax: (a, b) -> comparison logic

Comparator return rules : 
 - a comes before b when return value < 0
 - b comes before a when return value > 0
 - equal when return value 0
*/

public class BuiltinSorting {

    // Primitive
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // Object

        Integer[] arr1 = {3, 6, 1, 9}; 
        Arrays.sort(arr1, Collections.reverseOrder()); // Reverse Order
        System.out.println(Arrays.toString(arr1));

        // Array List
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(1);
        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder()); // Reverse Order
        System.out.println(list);
    }
}
