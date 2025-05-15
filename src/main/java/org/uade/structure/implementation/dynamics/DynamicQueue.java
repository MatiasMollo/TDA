package org.uade.structure.implementation.dynamics;

import org.uade.structure.definition.QueueADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.implementation.common.Node;

public class DynamicQueue implements QueueADT {

    private Node node;

    @Override
    public int getElement() {
        if(isEmpty()) throw new EmptyADTException("La cola está vacía");

        Node item = this.node;

        while (item.next != null){
            item = item.next;
        }
        return item.item;
    }

    @Override
    public void add(int value) {
        Node newNode = new Node(value);
        newNode.next = this.node;
        this.node = newNode;
    }

    @Override
    public void remove() {
        if(isEmpty()) throw new EmptyADTException("La cola ya se encuentra vacía");

        Node toDelete = this.node;
        Node temp = toDelete;

        // Se recorren todos los elementos y se guarda el ante último en temp
        while (toDelete.next != null){
            temp = toDelete;
            toDelete = toDelete.next;
        }

        // Si no hay next, solo hay un elemento y se elimina. Si hay next, se elimina la refetencia
        if(temp.next != null) temp.next = null;
        else this.node = null;
    }

    @Override
    public boolean isEmpty() {
        return this.node == null;
    }
}
