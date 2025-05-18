package org.uade.structure.implementation.dynamics;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.exception.EmptyADTException;

public class DynamicMultipleDictionary implements MultipleDictionaryADT {

    private Node node;
    private SetADT keys = new DynamicSet();

    @Override
    public void add(int key, int value) {

        if(keys.exist(key)){
            Node current = this.find(key);
            if(current != null) current.items.add(value);
        }
        else {
            Node newNode = new Node(key, value);
            newNode.next = this.node;
            this.node = newNode;
            keys.add(key);
        }

    }

    @Override
    public void remove(int key) {
        if(this.keys.exist(key)){

            Node current = this.node;
            boolean found = false;

            // EL PROBLEMA ES CUANDO SE INTENTA ELIMINAR EL ÚLTIMO ELEMENTO
            while(current.next != null && !found){
                if(current.next.key == key) found = true;
                else current = current.next;
            }

            if(found) current.next = current.next.next;
            else this.node = this.node.next;

            keys.remove(key);
        }
    }

    @Override
    public int[] get(int key) {
        this.checkKey(key);

        return this.find(key).getItems();
    }

    @Override
    public SetADT getKeys() {
        return keys;
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }

    @Override
    public void remove(int key, int value) {
        if(this.keys.exist(key)){
            Node current = this.find(key);

            if(current.items.size() == 1) this.remove(key);
            else{
                current.removeValue(value);
                if(current.items.isEmpty()) this.remove(key);
            }
        }
    }

    /**
     * Lanza una excepción en caso de que la key no esté en el Set de keys
     * @param key int
     */
    private void checkKey(int key)
    {
        if(!keys.exist(key)) throw new EmptyADTException("La key no existe");
    }


    /**
     * Se encarga de buscar el nodo, se debe saber que existe la key previammente
     * @param key int
     * @return Node
     */
    private Node find(int key)
    {
        Node current = this.node;
        boolean found = false;

        while(current != null && !found){
            if(current.key == key) found = true;
            else current = current.next;
        }

        return current;
    }


    class Node{
        public int key;
        public Node next;
        public DynamicLinkedList items = new DynamicLinkedList();


        public Node(int key, int value)
        {
            this.key = key;
            this.items.add(value);
            this.next = null;
        }

        /**
         * Retorna los elementos en formato array
         * @return array []int
         */
        public int[] getItems()
        {
            int[] elements = new int[this.items.size()];
            int index = 0;

            while(index < elements.length)
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

