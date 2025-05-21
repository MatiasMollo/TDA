package org.uade.structure.algorithms.SimpleDictionary;

import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.dynamics.DynamicSimpleDictionary;
import org.uade.structure.implementation.statics.StaticSimpleDictionary;
import org.uade.structure.utils.SimpleDictionaryHelpers;

public class DictionaryTest {
    public static void main(String[] args) {

        SimpleDictionaryADT dict = new StaticSimpleDictionary();

        dict.add(1,1);
        //dict.add(2,2);
        //dict.add(3,3);
        //dict.add(4,4);
        dict.add(8,2);


        //dict.remove(2);
        //dict.add(3,5);
        dict.remove(1);
        dict.remove(8);

        SimpleDictionaryHelpers.print(dict);

    }
}
