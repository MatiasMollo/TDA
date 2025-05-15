package org.uade.structure.implementation.dynamics;
import org.uade.structure.definition.StackADT;
import org.uade.structure.exception.EmptyADTException;
import org.uade.structure.implementation.common.Node;

public class DynamicStack implements StackADT {

    private Node node;


    public int getElement(){

        if(this.isEmpty())
            throw new EmptyADTException("El Stack no tiene elementos");

        return this.node.item;
    }

    public void add(int value){
        Node newNode = new Node(value);
        newNode.next = this.node;
        this.node = newNode;
    }


    public void remove(){
        if(!this.isEmpty()){
            this.node = this.node.next;
        }
        else throw new EmptyADTException("El stack está vacío");
    }

    public boolean isEmpty(){
        return this.node == null;
    }

}
