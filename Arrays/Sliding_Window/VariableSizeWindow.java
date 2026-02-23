package Arrays.Sliding_Window;

/*
Variable sliding window is a technique where window expands or
shrinks dynamically based on condition. 
*/

public class VariableSizeWindow {
    // We maintain a window that is always VALID according to condition
    // If it becomes invalid -> shrink it
    // If it is valid -> try to expand it 

    /********************************************/

    // Two pointer roles
    /*
    start -> left boundary
    end -> right boundary
    - And we only move forward, never backward
    - So total time = O(n)
    */

    /********************************************/

    // The invariant, behaviour
    /*
    for (end = 0 → n-1) {
        include nums[end]  // expand window
        
        while (window is valid) {
           update answer
           remove nums[start]  // shrink window
           start++
        }
    }
    */

    /********************************************/

    /*
    What actually happens :
    - EXPANSION : To make condition true
    - SHRINKING : To optimise the answer
    */

    /********************************************/

    /*
    Why it is O(n)?
    - Each element enters window and leaves window once
    - Total pointer movement : n times, not nested loop
    - Thus O(n)
    */
}
