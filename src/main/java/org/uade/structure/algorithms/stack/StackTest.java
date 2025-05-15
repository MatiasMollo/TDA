package org.uade.structure.algorithms.stack;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamics.DynamicStack;
import org.uade.structure.implementation.statics.StaticStack;
import org.uade.structure.utils.StackHelpers;

public class StackTest {
    public static void main(String[] args) {
        //StackADT stack = new StaticStack();
        StackADT stack = new StaticStack(20);
        //StackADT stack = new DynamicStack();

        stack.add(10);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.remove();
        stack.add(222);

        StackHelpers.print(stack);
        //System.out.println(stack.getElement());
    }
}
