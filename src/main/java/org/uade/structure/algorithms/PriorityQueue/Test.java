package org.uade.structure.algorithms.PriorityQueue;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.dynamics.DynamicPriorityQueue;
import org.uade.structure.implementation.statics.StaticPriorityQueue;
import org.uade.structure.utils.PriorityQueueHelpers;

public class Test {
    public static void main(String[] args) {

        PriorityQueueADT queue = new StaticPriorityQueue();

        /*
        queue.add(10,5);
        queue.add(20,7);
        queue.add(30,7);
        queue.add(40,7);
        queue.add(15,6);
        queue.add(5,4);


        System.out.println("---------");

        // Mueve la prioridad de todos los de 7
        queue.add(1000,10);
         */

        // Probar array limit (fuera de rango) y array de 10 posiciones

        queue.add(10,2);
        queue.add(20,3);
        queue.add(30,1);
        queue.add(40,5);
        queue.add(50,5);
        queue.add(60,5);
        queue.remove();
        PriorityQueueHelpers.print(queue);
    }
}
