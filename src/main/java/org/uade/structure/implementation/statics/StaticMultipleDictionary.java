package org.uade.structure.implementation.statics;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.OverflowADTException;

public class StaticMultipleDictionary implements MultipleDictionaryADT {

    private Node[] items;
    private SetADT keys;
    private int maxSize = 10;
    private int size = 0;

    public StaticMultipleDictionary(){
        this.keys = new StaticSet(this.maxSize);
        Node.maxSize = this.maxSize;
        this.items = new Node[this.maxSize];
    }

    public StaticMultipleDictionary(int max) {
        this.maxSize = max;
        this.keys = new StaticSet(this.maxSize);

        Node.maxSize = maxSize;
        this.items = new Node[this.maxSize];
    }

    @Override
    public void add(int key, int value) {
        if(this.size == this.maxSize) throw new OverflowADTException("Se ha alcanzado el límite del diccionario");

        if(keys.exist(key)){
            int index = this.findIndex(key);
            this.items[index].items.add(value);
        }
        else {
            this.items[this.size] = new Node(key,value);
            this.keys.add(key);
            this.size++;
        }
    }

    @Override
    public void remove(int key) {
        if(this.keys.exist(key)){
            int index = this.findIndex(key);

            while(index < this.size){
                this.items[index] = this.items[index+1];
                index++;
            }

            this.keys.remove(key);
            this.size--;
        }
    }

    @Override
    public int[] get(int key) {
        if(!this.keys.exist(key)) throw new EmptyADTException("La key no existe en el diccionario");
        return this.items[this.findIndex(key)].getItems();
    }

    @Override
    public SetADT getKeys() {
        return this.keys;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void remove(int key, int value) {
        if(this.keys.exist(key)){
            int index = this.findIndex(key);
            Node current = this.items[index];

            if(current.items.size() == 1) this.remove(key);
            else{
                current.removeValue(value);
                if(current.items.isEmpty()) this.remove(key);
            }
        }
    }


    /**
     * Retorna el indice en donde coincide la key. Se debe conocer que exista la Key previamente
     * @param key int
     * @return int
     */
    private int findIndex(int key){
        int index = 0;
        boolean found = false;


        while(index < this.size && !found){
            if(this.items[index].key == key) found = true;
            else index++;
        }

        return index;
    }


    class Node {
        public int key;
        public StaticLinkedList items;
        private static int maxSize;

        public Node(int key, int value){
            this.key = key;
            this.items = new StaticLinkedList(this.maxSize);
            this.items.add(value);
        }

        /**
         * Retorna los elementos en formato array
         * @return array []int
         */
        public int[] getItems()
        {
            int[] elements = new int[this.items.size()];
            int index = 0;

            while(index < this.items.size())
            {
                elements[index] = this.items.get(index);
                index++;
            }

            return elements;
        }


        /**
         * Busca y elimina todas las coincidencias del value en base al indice del array
         * @param value int
         */
        public void removeValue(int value)
        {
            int index = 0;
            int maxSize = this.items.size();

            while(index < maxSize){
                if(this.items.get(index) == value){
                    this.items.remove(index);
                    maxSize--;
                }
                else index++;
            }
        }
    }
}
