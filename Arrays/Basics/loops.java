package Arrays.Basics;

/* 
- In programming, a loop is a control flow structure used to execute a block 
  of code repeatedly as long as a specified condition remains true.

- Every loop has 3 parts :
1. Initialization : This is where define a counter variable
2. Condition(Guard) : A boolean expression checked before every iteration.
3. Update(Incrementor) : Changes & update counter variable after each loop. 
                         Otheriwse cause infinite loop.
*/

public class loops {
    public static void main(String[] args) {
        System.out.println("--- For Loop ---");
        System.out.println("1. Basic for loop");
        for(int i=1; i<=5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("\n2. Multiple variables");
        for(int i = 0, j = 10; i < j; i++, j--) {
            System.out.println(i + " " + j);
        }

        System.out.println("\n3. Missins parts");
        int i = 0;
        for(; i < 5; ) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();

        System.out.println("\n4. Infinite for loop");
        /* It is infinte, so avoid it
        for(;;) {
            System.out.println("Infinite");
        } */
    }
}
