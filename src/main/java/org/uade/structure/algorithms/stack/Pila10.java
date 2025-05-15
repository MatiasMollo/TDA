package org.uade.structure.algorithms.stack;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamics.DynamicStack;
import org.uade.structure.utils.StackHelpers;

public class Pila10 {
    /*
    * Cree e inicialice las pilas POZO, JUG1 y jUG2. Reparta los elementos de la pila
    * POZO en las pilas JUG1 y JUG2 de forma alternativa.
    * POZO puede contener una cantidad de elementos par, impar o ningún elemento
    * */
    public static void main(String[] args) {
        StackADT pozo = new DynamicStack();
        StackADT jug1 = new DynamicStack();
        StackADT jug2 = new DynamicStack();
        pozo.add(1);
        pozo.add(2);
        pozo.add(3);
        pozo.add(4);


        System.out.println("Pozo es:");
        StackHelpers.print(pozo);

        distribute(pozo, jug1, jug2);

        System.out.println("----------------");
        System.out.println("Jug1 es:");
        StackHelpers.print(jug1);
        System.out.println("---------------");
        System.out.println("Jug2 es:");
        StackHelpers.print(jug2);
    }

    /**
     * Distribuye de forma alternada los elementos
     */
    private static void distribute(StackADT pozo, StackADT jug1, StackADT jug2) {
        boolean useJug1 = true;

        while (!pozo.isEmpty()) {
            if (useJug1) jug1.add(pozo.getElement());
            else jug2.add(pozo.getElement());

            pozo.remove();
            useJug1 = !useJug1;
        }
    }


}
