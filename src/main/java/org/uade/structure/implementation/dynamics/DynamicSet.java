package org.uade.structure.implementation.dynamics;

import org.uade.structure.definition.SetADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.exception.OverflowADTException;
import org.uade.structure.implementation.common.Node;

import java.util.Random;

public class DynamicSet implements SetADT {

    private Node node;
    private int size;

    @Override
    public boolean exist(int value) {
        Node item = this.node;
        boolean found = false;

        // Bucle infinito
        while(item != null && !found){
            if(item.item == value) found = true;
            else item = item.next;
        }

        return found;
    }

    @Override
    public int choose() {
        int index = 1;
        Node item = this.node;

        /*
        // Se obtiene la cantidad máxima
        while(item.next != null){
            index++;
            item = item.next;
        }

        Random rand = new Random();
        int random = rand.nextInt(index);
         */

        Random rand = new Random();
        int random = rand.nextInt(this.size);

        index = 0;
        item = this.node;

        while(index < random){
            item = item.next;
            index++;
        }

        return item.item;
    }

    @Override
    public void add(int value) {
        if(this.exist(value)) throw new OverflowADTException("Ya existe el elemento en el Set");

        Node newNode = new Node(value);
        newNode.next = this.node;
        this.node = newNode;

        this.size++;
    }

    @Override
    public void remove(int element) {

        if(!this.exist(element)) throw new EmptyADTException("No existe el elemento a eliminar");

        if(this.node != null && this.node.next != null){
            Node item = this.node;
            Node nextItem = this.node.next;
            boolean found = false;

            while (nextItem != null && !found){
                if(nextItem.item == element) found = true;
                else{
                    item = nextItem;
                    nextItem = item.next;
                }
            }

            if(!found) this.node = this.node.next;
            else item.next = nextItem.next;
        }
        else this.node = null;

        this.size--;
    }

    @Override
    public boolean isEmpty() {
        return  this.node == null;
    }
}
