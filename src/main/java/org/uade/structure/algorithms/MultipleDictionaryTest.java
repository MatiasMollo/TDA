package org.uade.structure.algorithms;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.implementation.dynamics.DynamicMultipleDictionary;
import org.uade.structure.implementation.statics.StaticMultipleDictionary;
import org.uade.structure.implementation.statics.StaticSimpleDictionary;
import org.uade.structure.utils.MultipleDictionaryHelpers;
import org.uade.structure.utils.SimpleDictionaryHelpers;

public class MultipleDictionaryTest {

    public static void main(String[] args) {
        /*
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
         */

        MultipleDictionaryADT dict = new StaticMultipleDictionary(2);

        dict.add(1,1);
        dict.add(1,2);

        dict.remove(1);
        dict.add(1,3); // Problema agregando nuevamente, porque la key no se remueve correctamente
        dict.remove(1);
        dict.add(20,2);
        dict.add(20,3);
        dict.add(21,4);
        dict.remove(20,2);

        MultipleDictionaryHelpers.print(dict);


    }
}
