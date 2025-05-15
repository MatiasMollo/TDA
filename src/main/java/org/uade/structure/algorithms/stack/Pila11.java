package org.uade.structure.algorithms.stack;

import org.uade.structure.definition.StackADT;
import org.uade.structure.implementation.dynamics.DynamicStack;
import org.uade.structure.utils.StackHelpers;

public class Pila11 {

    /* Crear las pilas MOD y DADA, eliminar de DADA todos los elementos que sean
     * igual a MOD
     */
    public static void main(String[] args) {
        StackADT mod = new DynamicStack();
        StackADT dada = new DynamicStack();

        mod.add(1);
        mod.add(2);
        mod.add(3);

        dada.add(4);
        dada.add(2);
        dada.add(6);

        System.out.println("MOD:");
        StackHelpers.print(mod);

        System.out.println("DADA:");
        StackHelpers.print(dada);

        System.out.println("Removiendo duplicados");
        removeDuplicates(mod,dada);

        System.out.println("MOD:");
        StackHelpers.print(mod);

        System.out.println("DADA:");
        StackHelpers.print(dada);
    }

    private static void removeDuplicates(StackADT original, StackADT falsy){
        StackADT aux = new DynamicStack();

        while (!falsy.isEmpty()){
            StackADT copyOriginal = StackHelpers.copy(original);
            boolean repeated = false;

            while(!copyOriginal.isEmpty()){
                if(copyOriginal.getElement() == falsy.getElement()){
                    repeated = true;
                }
                copyOriginal.remove();
            }

            if(!repeated) aux.add(falsy.getElement());
            falsy.remove();
        }

        while (!aux.isEmpty()){
            falsy.add(aux.getElement());
            aux.remove();
        }
    }

}
