package org.uade.structure.implementation.dynamics;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.implementation.common.PriorityNode;

public class DynamicPriorityQueue implements PriorityQueueADT {

    private PriorityNode node;

    @Override
    public int getElement() {
        if(isEmpty()) throw new EmptyADTException("La cola está vacía");
        return this.node.item;
    }

    @Override
    public int getPriority() {
        if(isEmpty()) throw new EmptyADTException("La cola está vacía");
        return this.node.priority;
    }

    @Override
    public void add(int value, int priority) {
        PriorityNode newNode = new PriorityNode(value, priority);

        if(this.node == null || priority > this.node.priority){
            newNode.next = this.node;
            this.node = newNode;
        }
        else{
            PriorityNode current = this.node;

            while(current.next != null && current.next.priority >= priority){
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }

    }

    @Override
    public void remove() {
        if(isEmpty()) throw new EmptyADTException("La cola ya se encuentra vacía");

        this.node = this.node.next;
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }
}
