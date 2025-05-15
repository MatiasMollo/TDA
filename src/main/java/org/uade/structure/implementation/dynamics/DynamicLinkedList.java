package org.uade.structure.implementation.dynamics;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.implementation.common.Node;

public class DynamicLinkedList implements LinkedListADT {

    private Node element;
    private int size = 0;

    @Override
    public void add(int value) {
        if (this.size == 0) this.element = new Node(value);
        else{
            Node current = this.element;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node(value);
        }
        this.size++;
    }

    @Override
    public void insert(int index, int value) {
        // es válido ingresar ceros hasta la posición del indice en caso de que sea vacío?
        if(index < 0)
            throw new EmptyADTException("El indice está fuera de rango");

        // Llena las posiciones hasta llegar el nuevo size
        if(index > this.size){
            while (index > this.size){
                add(0);
            }
            // Inserta el elemento una vez que se completaron las posiciones con ceros
            add(value);
        }
        else{
            int currentIndex = 0;
            Node currentElement = this.element;

            while (currentIndex < index){
                currentElement = currentElement.next;
                currentIndex++;
            }
            currentElement.item = value;
        }

    }

    @Override
    public void remove(int index) {
        if(index >= this.size || index < 0) throw new EmptyADTException("El indice no existe");

        // Es correcto que al remover se corran todos los indices? o se debería insertar un cero
        int currentIndex = 0;
        Node currentElement = this.element;

        while(currentIndex < index - 1){
            currentElement = currentElement.next;
            currentIndex++;
        }
        if((this.size - currentIndex) > 2){
            currentElement.next = currentElement.next.next;
        }
        else{
            currentElement.next = null;
        }

        this.size--;
    }

    @Override
    public int get(int index) {
        if(isEmpty() || index < 0 || index >= this.size)
            throw new EmptyADTException("El indice no es compatible con la longitud de la lista");

        int currentIndex = 0;
        Node indexElement = this.element;

        while(currentIndex < index){
            indexElement = indexElement.next;
            currentIndex++;
        }

        return indexElement.item;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.element == null;
    }
}
