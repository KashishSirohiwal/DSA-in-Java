package Arrays.Kadane_Algo;

/*
2D Kadane is an extension of Kadane’s Algorithm used to find 
the maximum sum rectangular submatrix inside a 2D matrix.
*/

public class TwoDKadane {
    /*
    So unlike 1D Kadane, where we find the best contiguous subarray, 
    here we find the best contiguous rectangular block.

    Brute Force method :
      - O(rows^2) ways to choose top and bottom
      - O(cols^2) ways to choose left and right
      - So total rectangle : O(rows^2 . cols^2)
    Thus brute force is not practical
    */

    /*
    Core Insight of 2D Kadane :
    - 2D Kadane converts a 2D rectangle problem into multiple 1D subarray problems.
    - Fix columns to handle horizontal boundaries
    - Kadane find vertical boundaries

    It's important to choose best :
    left & right column, top & bottom row

    For every row between add :
    - row 0 => matrix[0][left...right]
    - row 1 => matrix[1][left...right]
    - row 2 => matrix[2][left...right]...

    This gives 1D array :
    temp[run] = sum of elements from left to right in that row
    */

    /*
    If matrix size :
    rows = R, cols = C

    Choosing left & right cols => O(C^2)
    Running Kadane for each pair => O(R)
    So total => O(C^2 . R)
    */

    public static int twoDKadane(int[] arr, int[] result) {
        int currentSum = arr[0];
        int maxSum = arr[0];

        int start = 0, end = 0, tempStart = 0;

        for(int i = 1; i < arr.length; i++) {
            if (arr[i] > currentSum + arr[i]) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        result[0] = start;  // top row
        result[1] = end;    // bottom row

        return maxSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxSum = Integer.MIN_VALUE;
        int finalLeft = 0, finalRight = 0, finalTop = 0, finalBottom = 0;

        for (int left = 0; left < cols; left++) {
            int[] temp = new int[rows];

            for (int right = left; right < cols; right++) {

                for (int i = 0; i < rows; i++) {
                    temp[i] += matrix[i][right];
                }

                int[] result = new int[2]; // result[0] = top, result[1] = bottom
                int currentSum = twoDKadane(temp, result);

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    finalLeft = left;
                    finalRight = right;
                    finalTop = result[0];
                    finalBottom = result[1];
                }
            }
        }

        System.out.println("Maximum Sum = " + maxSum);
        System.out.println("Top Row = " + finalTop);
        System.out.println("Bottom Row = " + finalBottom);
        System.out.println("Left Column = " + finalLeft);
        System.out.println("Right Column = " + finalRight);

        System.out.println("\nMaximum Sum Rectangle:");
        for (int i = finalTop; i <= finalBottom; i++) {
            for (int j = finalLeft; j <= finalRight; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }




}
