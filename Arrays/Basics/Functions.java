package Arrays.Basics;

public class Functions {
    public static void void_function() {
        System.out.println("This is a void function");
    }

    public static void void_functions_para(int a, int b) {
        System.out.println("This is void functions with parameters");
        System.out.println("Sum of a+b : " + (a+b));
    }
    public static void main(String[] args) {
        System.out.println("1.--- Void Function with no parameters ---");
        void_function();

        System.out.println("\n2. --- Void function with parameters ---");
        void_functions_para(3,7);
    }
}
