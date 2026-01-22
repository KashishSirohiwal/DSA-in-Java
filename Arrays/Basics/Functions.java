package Arrays.Basics;

public class Functions {
    public static void void_function() {
        System.out.println("This is a void function");
    }

    public static void void_functions_para(int a, int b) {
        System.out.println("This is void functions with parameters");
        System.out.println("Sum of a+b : " + (a+b));
    }

    public static int square_function(int x) {
        System.out.println("This is a returning functions");
        return x*x;
        // Unreachable code : System.out.println("This will not print");
    }

    public static String greeting_function(String name, int year) {
        System.out.println("This is a returning functions with multiple String");
        return "I am " + name + ", from year " + year;
    }
    public static void main(String[] args) {
        System.out.println("1. --- Void Function with no parameters ---");
        void_function();

        System.out.println("\n2. --- Void function with parameters ---");
        void_functions_para(3,7);

        System.out.println("\n3. --- Returning function");
        System.out.println("Square of no 8 is : " + square_function(8));

        System.out.println("\n4. --- Returning multiple string function");
        System.out.println(greeting_function("Kashish",2026));
    }
}
