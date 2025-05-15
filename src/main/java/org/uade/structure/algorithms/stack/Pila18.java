package org.uade.structure.algorithms.stack;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamics.DynamicStack;
import org.uade.structure.utils.StackHelpers;

public class Pila18 {

    /**
     * Mostrar los elementos de una pila sin utilizar bucles
     */
    public static void main(String[] args){
        StackADT stack = new DynamicStack();

        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        print(stack);
    }

    private static void print(StackADT stack){
        StackADT copy = StackHelpers.copy(stack);
        printElement(copy);
    }

    private static void printElement(StackADT stack){
        if(!stack.isEmpty()){
            System.out.println(stack.getElement());
            stack.remove();
            printElement(stack);
        }
    }
}
