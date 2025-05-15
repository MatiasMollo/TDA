package org.uade.structure.utils;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.implementation.dynamics.DynamicQueue;
import org.uade.structure.implementation.statics.StaticQueue;

public class QueueHelpers {

    public static QueueADT copy(QueueADT original){
        QueueADT newQueue = getQueue(original);
        QueueADT temp = getQueue(original);

        while (!original.isEmpty()) {
            newQueue.add(original.getElement());
            temp.add(original.getElement());
            original.remove();
        }

        while (!temp.isEmpty()) {
            original.add(temp.getElement());
            temp.remove();
        }

        return newQueue;
    }

    public static void print(QueueADT queue){
        QueueADT temp = copy(queue);

        while (!temp.isEmpty()) {
            System.out.println(temp.getElement());
            temp.remove();
        }
    }


    private static QueueADT getQueue(QueueADT queue){
        if(queue instanceof DynamicQueue) return new DynamicQueue();
        else return new StaticQueue();
    }
}
