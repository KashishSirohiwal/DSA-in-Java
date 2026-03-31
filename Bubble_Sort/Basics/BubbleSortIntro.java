package Bubble_Sort.Basics;
/*
Bubble Sort is a comparison-based sorting algorithm that repeatedly
traverses the array and compares adjacent elements, swapping them 
if they are in the wrong order, until the entire array becomes sorted.

Working :
1. Compares element pair by pair
2. If pair is wrong -> swap them
3. This keeps pushing larger elements towards right
4. After one full pass -> the largest element reaches end
5. After second pass -> second largest reaches second last
6. And this goes on...till (n - 1) passes where n is length of array
*/

/*
Bubble sort is stable because 
- It only swap when arr[j] > arr[j+1]
- Equal elemetns are not awapped
*/

/*
Time complexity : O(n^2)
Space complexity : O(n) (In place)
*/

public class BubbleSortIntro {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Correct swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Print sorted array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
