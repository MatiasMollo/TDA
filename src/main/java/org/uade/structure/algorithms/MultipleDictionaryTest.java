package org.uade.structure.algorithms;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.dynamics.DynamicMultipleDictionary;
import org.uade.structure.implementation.statics.StaticSimpleDictionary;
import org.uade.structure.utils.MultipleDictionaryHelpers;
import org.uade.structure.utils.SimpleDictionaryHelpers;

public class MultipleDictionaryTest {

    public static void main(String[] args) {
        MultipleDictionaryADT dict = new DynamicMultipleDictionary();

        dict.add(1,1);
        dict.add(2,2);
        dict.add(3,3);
        dict.add(4,4);

        dict.add(8,2);
        dict.add(8,3);

        dict.add(1,20);
        dict.add(1,20);
        dict.add(1,10);

        MultipleDictionaryHelpers.print(dict);

        System.out.println("-------------------");

        dict.remove(1);
        dict.remove(8,2);
        //dict.remove(3);

        MultipleDictionaryHelpers.print(dict);


    }
}
