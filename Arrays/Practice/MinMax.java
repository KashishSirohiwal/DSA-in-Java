package Arrays.Practice;

public class MinMax {
    public static int[] getMinAndMax(int[] arr) { 
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return new int[]{min, max}; 
    }
    public static void main(String[] args) {
        int[] numbers = {3, 5, 1, 8, 2};
        int[] minMax = getMinAndMax(numbers);
        System.out.println("Minimum: " + minMax[0] + ", Maximum: " + minMax[1]);
    }
}
