package org.uade.structure.implementation.statics;

import org.uade.structure.definition.PriorityQueueADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.OverflowADTException;

public class StaticPriorityQueue implements PriorityQueueADT {
    private int[] list;
    private int[] priority;
    private int size = 0;

    public StaticPriorityQueue() {
        this.list = new int[10];
        this.priority = new int[10];
    }

    public StaticPriorityQueue(int size) {
        this.list = new int[size];
        this.priority = new int[size];
    }

    @Override
    public int getElement() {
        if(isEmpty()) throw new EmptyADTException("La cola está vacía");
        return this.list[0];
    }

    @Override
    public int getPriority() {
        if(isEmpty()) throw new EmptyADTException("La cola está vacía");
        return this.priority[0];
    }

    @Override
    public void add(int value, int priority) {
        if(this.size == this.list.length) throw new OverflowADTException("Se ha alcanzado el máximo disponible de elementos");
        int index = 0;

        while(index < this.size && this.priority[index] >= priority){
            index++;
        }

        for(int i = this.size; i > index; i--){
            this.list[i] = this.list[i - 1];
            this.priority[i] = this.priority[i - 1];
        }

        this.list[index] = value;
        this.priority[index] = priority;

        this.size++;
    }

    @Override
    public void remove() {
        if(isEmpty()) throw new EmptyADTException("La cola ya se encuentra vacía");

        for(int i = 1; i < this.size; i++){
            this.list[i-1] = this.list[i];
            this.priority[i-1] = this.priority[i];
        }
        this.size--;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
