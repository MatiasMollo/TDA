package org.uade.structure.implementation.dynamics;

import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.OverflowADTException;

public class DynamicSimpleDictionary implements SimpleDictionaryADT {

    private Node node;
    private SetADT keys;

    public DynamicSimpleDictionary() {
        this.node = null;;
        this.keys = new DynamicSet();
    }

    @Override
    public void add(int key, int value) {
        if(keys.exist(key)){
            // Se recorren los nodos hasta encontrar el correcto y se sustituye el valor
            boolean found = false;
            Node current = this.node;

            while(current != null && !found){
                if(current.key == key) found = true;
                else current = current.next;
            }

            if(current != null)
                current.value = value;
        }
        else{
            keys.add(key);
            Node newNode = new Node(key,value);
            newNode.next = this.node;
            this.node = newNode;
        }
    }

    @Override
    public void remove(int key) {
        if(!keys.exist(key)) throw new EmptyADTException("No existe la key en el diccionario");

        Node current = this.node;
        boolean found = false;

        while(current.next != null && !found){
            if(current.next.key == key) found = true;
            else current = current.next;
        }

        if(found) current.next = current.next.next;
        else this.node = this.node.next;

        keys.remove(key);
    }

    @Override
    public int get(int key) {
        if(!keys.exist(key)) throw new OverflowADTException("No existe la key en el diccionario");

        int element = 0;
        boolean found = false; // Se utiliza un booleano porque si usamos "element" como condición, al poder ser 0, se podrían hacer iteraciones de mas
        Node current = this.node;

        while(current != null && !found){
            if(current.key == key){
                found = true;
                element = current.value;
            }
            else current = current.next;
        }

        return element;
    }

    @Override
    public SetADT getKeys() {
        DynamicSet copy = new DynamicSet();
        DynamicSet temp = new DynamicSet();
        int number;

        while(!this.keys.isEmpty()){
            number = this.keys.choose();
            copy.add(number);
            temp.add(number);
            this.keys.remove(number);
        }

        while(!temp.isEmpty()){
            number = temp.choose();
            this.keys.add(number);
            temp.remove(number);
        }

        return copy;
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }


    class Node{
        public int key;
        public int value;
        public Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

}

