package org.uade.structure.algorithms.list;

import org.uade.structure.definition.LinkedListADT;
import org.uade.structure.implementation.dynamics.DynamicLinkedList;
import org.uade.structure.implementation.statics.StaticLinkedList;
import org.uade.structure.utils.ListHelpers;

public class DynamicListTest {
    public static void main(String[] args) {

        LinkedListADT test = new DynamicLinkedList();
        //LinkedListADT test = new StaticLinkedList();

        test.add(1);
        test.add(2);
        test.add(3);
        test.add(2);
        test.add(3);

        //test.insert(8, 583);

        ListHelpers.print(test);

        System.out.println("---------------------");

        test.remove(4);
        test.remove(3);
        test.remove(2);
        test.remove(1);

        ListHelpers.print(test);
    }
}
