package org.uade.structure.utils;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.implementation.dynamics.DynamicPriorityQueue;

public class PriorityQueueHelpers {

    public static PriorityQueueADT copy(PriorityQueueADT original){
        PriorityQueueADT newQueue = getQueue(original);
        PriorityQueueADT temp = getQueue(original);

        while (!original.isEmpty()) {
            newQueue.add(original.getElement(), original.getPriority());
            temp.add(original.getElement(), original.getPriority());
            original.remove();
        }

        while (!temp.isEmpty()) {
            original.add(temp.getElement(), temp.getPriority());
            temp.remove();
        }

        return newQueue;
    }


    public static void print(PriorityQueueADT queue){
        PriorityQueueADT temp = copy(queue);

        while (!temp.isEmpty()) {
            System.out.println(temp.getElement());
            temp.remove();
        }
    }


    private static PriorityQueueADT getQueue(PriorityQueueADT queue){
        return new DynamicPriorityQueue();
    }
}
