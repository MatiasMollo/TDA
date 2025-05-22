package org.uade.structure.algorithms.SimpleDictionary;

import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.dynamics.DynamicSimpleDictionary;
import org.uade.structure.implementation.statics.StaticSimpleDictionary;
import org.uade.structure.utils.SetHelpers;
import org.uade.structure.utils.SimpleDictionaryHelpers;

public class DictionaryTest {
    public static void main(String[] args) {

        SimpleDictionaryADT dict = new DynamicSimpleDictionary();

        dict.add(1,1);
        dict.add(1,2);
        //dict.add(2,2);
        //dict.add(3,3);
        //dict.add(4,4);
        dict.add(8,2);

        SetADT keys = dict.getKeys();

        SetHelpers.print(keys);


        //dict.remove(2);
        //dict.add(3,5);

        SimpleDictionaryHelpers.print(dict);

    }
}
