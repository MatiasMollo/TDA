package org.uade.structure.utils;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;

public class MultipleDictionaryHelpers {

    public static void print(MultipleDictionaryADT dictionary)
    {
        SetADT keys = SetHelpers.copy(dictionary.getKeys());
        int key;
        int[] items;

        while(!keys.isEmpty()){
            key = keys.choose();
            System.out.print(key + ": ");
            items = dictionary.get(key);

            for(int x = 0; x < items.length; x++){
                System.out.print(items[x] + " ");
            }

            System.out.println();
            keys.remove(key);
        }
    }
}
