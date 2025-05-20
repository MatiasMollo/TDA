package org.uade.structure.implementation.statics;

import org.uade.structure.definition.SetADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.OverflowADTException;

import java.util.Random;

public class StaticSet implements SetADT {

    private int[] items;
    private int size;
    private boolean empty = true;

    public StaticSet() {
        this.items = new int[10];
    }

    public StaticSet(int max){
        this.items = new int[max];
    }

    @Override
    public boolean exist(int value) {
        int index = 0;
        boolean found = false;

        while(!found && index < this.size){
            if(this.items[index] == value) found = true;
            index++;
        }

        return found;
    }

    @Override
    public int choose() {
        if(this.isEmpty()) throw new EmptyADTException("El Set se encuentra vacío");
        Random rand = new Random();

        // nextInt devuelve un random entre cero y el número que recibe como parámentro (sin incluir a este último)
        int number = rand.nextInt(this.size);

        return this.items[number];
    }

    @Override
    public void add(int value) {
        if(this.items.length <= this.size) throw new OverflowADTException("Se ha alcanzado el límite de elementos");

        if(!this.exist(value)){
            this.items[this.size] = value;
            this.size++;
            this.empty = false;
        }
    }

    @Override
    public void remove(int element) {
        if(this.isEmpty()) throw new EmptyADTException("No se puede eliminar un Set vacío");
        if(!this.exist(element)) throw new EmptyADTException("El elemento no existe");

        boolean found = false;
        int index = 0;

        while (!found && index < this.size){
            if(this.items[index] == element) found = true;
            else index++;
        }

        for(int x = index; x < this.size - 1; x++){
            this.items[x] = this.items[x+1];
        }

        if(this.size >= 1) this.size--;
        if(this.size == 0) this.empty = true;
    }

    @Override
    public boolean isEmpty() {
        return this.empty;
    }
}
