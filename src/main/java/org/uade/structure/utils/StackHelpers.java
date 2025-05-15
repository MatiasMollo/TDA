package org.uade.structure.utils;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamics.DynamicStack;
import org.uade.structure.implementation.statics.StaticStack;

public class StackHelpers {

    public static StackADT copy(StackADT stack){
        StackADT newStack = new DynamicStack();
        StackADT tempStack = new DynamicStack();

        while (!stack.isEmpty()){
            tempStack.add(stack.getElement());
            stack.remove();
        }

        while (!tempStack.isEmpty()){
            stack.add(tempStack.getElement());
            newStack.add(tempStack.getElement());
            tempStack.remove();
        }

        return newStack;
    }

    public static void print(StackADT stack){
        StackADT copy = copy(stack);

        while (!copy.isEmpty()){
            System.out.println(copy.getElement());
            copy.remove();
        }
    }

    private StackADT getNewStack(StackADT stack){
        StackADT newStack;
        if(stack instanceof StaticStack) newStack = new StaticStack();
        else newStack = new DynamicStack();

        return newStack;
    }

}
