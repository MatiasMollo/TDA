package org.uade.structure.algorithms.list;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.statics.StaticLinkedList;
import org.uade.structure.utils.ListHelpers;

public class ReverseList {
    public static void main(String[] args) {
        LinkedListADT list = new StaticLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        System.out.println("La lista es:");
        ListHelpers.print(list);

        LinkedListADT reversed = reverseList(list);
        System.out.println("La lista revertida es: ");
        ListHelpers.print(reversed);
    }

    public static LinkedListADT reverseList(LinkedListADT list){
        LinkedListADT newList = new StaticLinkedList();

        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }

        return newList;
    }
}
