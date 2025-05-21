package org.uade.structure.algorithms;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.implementation.dynamics.DynamicMultipleDictionary;
import org.uade.structure.implementation.statics.StaticMultipleDictionary;
import org.uade.structure.implementation.statics.StaticSimpleDictionary;
import org.uade.structure.utils.MultipleDictionaryHelpers;
import org.uade.structure.utils.SimpleDictionaryHelpers;

public class MultipleDictionaryTest {

    public static void main(String[] args) {

        MultipleDictionaryADT dict = new StaticMultipleDictionary(1);

        dict.add(10,20);
        dict.remove(10);

        MultipleDictionaryHelpers.print(dict);


    }
}
