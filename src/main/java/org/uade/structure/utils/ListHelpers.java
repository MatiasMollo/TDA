package org.uade.structure.utils;

import org.uade.structure.definition.LinkedListADT;

public class ListHelpers {

    public static void print(LinkedListADT list){
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
