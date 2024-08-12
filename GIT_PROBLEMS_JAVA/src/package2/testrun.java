package package2;
import java.util.*;

public class testrun {

    public static void main(String[] args) {
        // Sample list
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        
        System.out.println(a);
        // Initialize variables to track the largest and second-largest numbers
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int resultIndex = -1;
        
        // Traverse the list to find the largest and second-largest numbers
        for (int i = 0; i < a.size(); i++) {
            int current = a.get(i);
            if (current > largest) {
                // Update second largest before updating largest
                secondLargest = largest;
                largest = current;
                // Update index for the new largest
                resultIndex = -1; // Reset index as we need the second largest
            } else if (current > secondLargest && current < largest) {
                // Update second largest and its index
                secondLargest = current;
                resultIndex = i;
            }
        }
        
        // Check if the second-largest number was found
        if (resultIndex == -1) {
            System.out.println("No distinct second-largest element found.");
        } else {
            System.out.println("Index of the second-largest number: " + resultIndex);
        }
    }
}
