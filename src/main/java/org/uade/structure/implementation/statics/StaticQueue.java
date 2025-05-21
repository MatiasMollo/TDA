package org.uade.structure.implementation.statics;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.OverflowADTException;

public class StaticQueue implements QueueADT {

    private int[] items;
    private int size = 0;
    private int maxSize = 10;

    public StaticQueue(){
        this.items = new int[this.maxSize];
    }

    public StaticQueue(int length){
        this.maxSize = length;
        this.items = new int[this.maxSize];
    }

    @Override
    public int getElement() {
        if(isEmpty()) throw new EmptyADTException("La cola está vacía");
        return this.items[0];
    }

    @Override
    public void add(int value) {
        if(this.size >= maxSize) throw new OverflowADTException("La cola llegó a su máximo de elementos");

        this.items[this.size] = value;
        this.size++;
    }

    @Override
    public void remove() {
        if(isEmpty()) throw new EmptyADTException("La cola se encuentra vacía");
        int []newArray = new int[this.maxSize];
        int index = 0;

        while(this.size > 1 && index < this.size-1){
            newArray[index] = this.items[index+1];
            index++;
        }

        this.items = newArray;
        this.size--;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
