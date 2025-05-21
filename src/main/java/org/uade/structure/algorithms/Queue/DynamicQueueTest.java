package org.uade.structure.algorithms.Queue;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.dynamics.DynamicQueue;
import org.uade.structure.implementation.statics.StaticQueue;
import org.uade.structure.utils.QueueHelpers;

public class DynamicQueueTest {
    public static void main(String[] args) {

        //QueueADT queue = new DynamicQueue();
        QueueADT queue = new StaticQueue(100);

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        queue.add(11);





        QueueHelpers.print(queue);


    }
}
