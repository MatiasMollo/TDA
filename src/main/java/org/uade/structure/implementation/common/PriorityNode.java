package org.uade.structure.implementation.common;

public class PriorityNode extends Node{
    public int priority;
    public PriorityNode next;

    public PriorityNode(int item, int priority){
        super(item);
        this.priority = priority;
    }
}
