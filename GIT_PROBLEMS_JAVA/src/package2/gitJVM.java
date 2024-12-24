package package2;

import java.util.*;
public class gitJVM {

    // Static variable (stored in Method Area)
    static int staticVar = 100; 

    // Instance variable (stored in Heap as part of the object)
    int instanceVar; 

    // Constructor
    public gitJVM(int instanceVar) {
        // 'this.instanceVar' reference is stored in the Heap (part of the object)
        this.instanceVar = instanceVar;
    }

    // Instance method (method code stored in Method Area)
    public void display() {
        // Local variable (stored in the Stack)
        int localVar = 50; 

        // Printing output (method call, references stored in the Stack)
        System.out.println("Static Var: " + staticVar);
        System.out.println("Instance Var: " + instanceVar);
        System.out.println("Local Var: " + localVar);
    }

    public static void main(String[] args) {
        // Stack frame for 'main' created in the Stack

        // Object reference (stored in Stack), object itself stored in Heap
    	gitJVM example = new gitJVM(200);

        // Method invocation (new stack frame created for 'display' method)
        example.display();

        // Local variable in 'main' method (stored in Stack)
        int anotherLocalVar = 300; 
        System.out.println("Another Local Var: " + anotherLocalVar);
        
        // End of main method, 'main' stack frame is removed
    }
}
