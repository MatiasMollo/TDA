package org.uade.structure.implementation.statics;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.OverflowADTException;

public class StaticLinkedList implements LinkedListADT {

    private int maxSize = 10;
    private int[] list;
    private int size;

    public StaticLinkedList() {
        this.list = new int[maxSize];
        this.size = 0;
    }

    public StaticLinkedList(int max) {
        this.list = new int[max];
        this.maxSize = max;
        this.size = 0;
    }

    @Override
    public void add(int value) {
        this.checkSize();
        this.list[size] = value;
        this.size++;
    }

    @Override
    public void insert(int index, int value) {
        if(index >= this.maxSize) throw new OverflowADTException("El índice no puede superar el máximo de la lista");;

        this.list[index] = value;
        if(this.size < index) this.size = index+1;
    }

    @Override
    public void remove(int index) {
        if(this.isEmpty() || this.size <= index) throw new EmptyADTException("No se puede remover un indice inexistente");

        int helper;
        this.list[index] = 0;
        this.size--;

        for (int i = index; i < this.size; i++){
            helper = list[i+1];
            list[i+1] = list[i];
            list[i] = helper;
        }
    }

    @Override
    public int get(int index) {
        if (index >= maxSize) throw new OverflowADTException("El indice supera la cantidad máxima de elementos de la lista");;
        return this.list[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    private void checkSize(){
        if(this.size >= this.maxSize) throw new OverflowADTException("Se alcanzó el máximo de elementos de la lista");
    }
}
