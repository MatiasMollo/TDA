package org.uade.structure.implementation.statics;

import org.uade.structure.definition.StackADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.OverflowADTException;

public class StaticStack implements StackADT {

    // Es correcto usar un array estático? o se deben usar nodos?
    int[] items;
    int size = 0;

    public StaticStack(int maxSize) {
        this.items = new int[maxSize > 0 ? maxSize : 1];
    }

    public StaticStack(){
        this.items = new int[10];
    }

    @Override
    public int getElement() {
        if (isEmpty()) throw new EmptyADTException("El stack está vacío");
        return items[this.size - 1];
    }

    @Override
    public void add(int value) {
        if(this.size >= items.length) throw new OverflowADTException("Se superó el límite de elementos a almacenar");
        this.items[this.size] = value;
        this.size++;
    }

    @Override
    public void remove() {
        if(isEmpty()) throw new EmptyADTException("El stack está vacío");
        this.size--;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }
}
