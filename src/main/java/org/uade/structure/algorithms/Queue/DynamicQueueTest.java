package org.uade.structure.algorithms.Queue;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.dynamics.DynamicQueue;
import org.uade.structure.implementation.statics.StaticQueue;
import org.uade.structure.utils.QueueHelpers;

public class DynamicQueueTest {
    public static void main(String[] args) {

        QueueADT queue = new DynamicQueue();
        //QueueADT queue = new StaticQueue();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(15);
        queue.add(5);
        queue.remove();


        // No está eliminando como debería, por ahi está eliminando el último

        //System.out.println("Queue First Element: " + queue.getElement());
        QueueHelpers.print(queue);


    }
}
