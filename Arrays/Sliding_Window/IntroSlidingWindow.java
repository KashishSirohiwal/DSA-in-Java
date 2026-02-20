package Arrays.Sliding_Window;

/*
The Sliding Window Technique is an efficient algorithmic approach used to solve 
problems involving subarrays or substrings within a dataset.The technique 
involves maintaining a "window" of elements that slides over the dataset, 
performing calculations incrementally by reusing results from the previous window.
*/

public class IntroSlidingWindow {

    /*
    A window is a contigous range that grow -> shrinks -> moves
    & maintains a running result in O(1) per step
    */

    /*
    Types of sliding window :
    1. Fixed size window 
      - window size is constant(k)
      - Pattern : 
        * Add next element
        * Remove previous element
    
    2. Variable size window
      - Window size is dynamic
      - Pattern :
        * Expand -> until condition breaks
        * Shrink -> until valid again
    */

    // First window : sum = arr[0] + arr[1] + ... + arr[k-1]
    // Next window : sum = sum + arr[i-1] + arr[i+k-1]
    // This makes every move O(1)

    /*
    This is invariant flow :
    1. compute first window
    2. for each next index:
       - subtract outgoing element
       - add incoming element
       - update answer
    */
}
