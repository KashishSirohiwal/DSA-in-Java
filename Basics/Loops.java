package Basics;

/* 
- In programming, a loop is a control flow structure used to execute a block 
  of code repeatedly as long as a specified condition remains true.

- Every loop has 3 parts :
1. Initialization : This is where define a counter variable
2. Condition(Guard) : A boolean expression checked before every iteration.
3. Update(Incrementor) : Changes & update counter variable after each loop. 
                         Otheriwse cause infinite loop.
*/

public class Loops {
    public static void main(String[] args) {
        System.out.println("--- For Loop ---");
        System.out.println("1. Basic for loop");
        for(int i=1; i<=5; i++) {
            System.out.print(i + " ");
        }

        System.out.println("\n\n2. Multiple variables");
        for(int i = 0, j = 10; i < j; i++, j--) {
            System.out.println(i + " " + j);
        }

        System.out.println("\n3. Missins parts");
        int i = 0;
        for(; i < 5; ) {
            System.out.print(i + " ");
            i++;
        }

        System.out.println("\n\n4. Infinite for loop");
        /* It is infinte, so avoid it
        for(;;) {
            System.out.println("Infinite");
        } */

        System.out.println("\n--- While Loop ---");
        int n = 5; // Initialization
        while(n >= 1) { // Condition
            System.out.print(n + " ");
            n--; // Update
        }
        System.out.println("\nAccessible outside loop : " + n);

        System.out.println("\n--- Do-While Loop ---");
        System.out.println("1. Simple do-while loop");
        int n1 = 5;
        do { 
            System.out.print(n1 + " ");
            n1--;
        } while(n1 >= 1);

        System.out.println("\n\n2. Runs once when condition - false");
        int n2 = 5;
        do {
            System.out.println(n2);
            n2--;
        } while(n2 < 1); // Here condition fails but still 5 is printed

        System.out.println("\n--- Nested Loop ---");
        for(int j=1; j<=3; j++) {
            for(int k=1; k<=4; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
