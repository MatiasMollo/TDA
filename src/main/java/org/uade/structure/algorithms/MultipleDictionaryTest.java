package org.uade.structure.algorithms;

import org.uade.structure.definition.MultipleDictionaryADT;
import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamics.DynamicMultipleDictionary;
import org.uade.structure.implementation.statics.StaticMultipleDictionary;
import org.uade.structure.implementation.statics.StaticSimpleDictionary;
import org.uade.structure.utils.MultipleDictionaryHelpers;
import org.uade.structure.utils.SetHelpers;
import org.uade.structure.utils.SimpleDictionaryHelpers;

public class MultipleDictionaryTest {

    public static void main(String[] args) {

        MultipleDictionaryADT dict = new StaticMultipleDictionary();

        dict.add(10,20);
        dict.add(10,24);
        dict.add(25,10);

        dict.remove(10,205);

        MultipleDictionaryHelpers.print(dict);


    }
}
