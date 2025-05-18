package org.uade.structure.implementation.statics;

import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.OverflowADTException;

public class StaticSimpleDictionary implements SimpleDictionaryADT {

    private Item[] items;
    private int maxSize;
    private int size = 0;
    private SetADT keys;

    public StaticSimpleDictionary() {
        this.maxSize = 10;
        this.items = new Item[this.maxSize];
        this.keys = new StaticSet(this.maxSize);
    }

    public StaticSimpleDictionary(int max) {
        this.items = new Item[max];
        this.maxSize = max;
        this.keys = new StaticSet(max);
    }

    @Override
    public void add(int key, int value) {
        if(this.size == this.maxSize) throw new OverflowADTException("Se ha alcanzado el máximo de elementos para el diccionario");

        if(this.keys.exist(key)){
            this.items[this.findIndex(key)].value = value;
        }
        else {
            Item newItem = new Item(key, value);

            this.items[this.size] = newItem;
            this.size++;
            this.keys.add(key);
        }

    }

    @Override
    public void remove(int key) {
        if(!this.keys.exist(key)) throw new EmptyADTException("La llave especificada no existe");

        int index = this.findIndex(key);

        while(index < this.size - 1){
            this.items[index] = this.items[index+1];
            index++;
        }

        this.size--;
        this.keys.remove(key);

        /*
        this.items[this.findIndex(key)] = null; // Falta mover los elementos del array
        this.size--;
        this.keys.remove(key);

         */
    }

    @Override
    public int get(int key) {
        if(!this.keys.exist(key)) throw new EmptyADTException("La llave especificada no existe");

        return this.items[this.findIndex(key)].value;
    }

    @Override
    public SetADT getKeys() {
        return this.keys;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }


    /**
     * Función de búsqueda, se debe saber que la key está dentro del array de items antes de buscar
     * @param key int
     * @return index - Posición del elemento Item en el array de items
     */
    private int findIndex(int key)
    {
        int index = 0;
        boolean found = false;

        while(!found && index < this.size){
            if(this.items[index].key == key) found = true;
            else index++;
        }

        return index;
    }
}

class Item{
    public int key;
    public int value;

    public Item(int key, int value) {
        this.key = key;
        this.value = value;
    }
}