package org.uade.structure.utils;

import org.uade.structure.definition.SetADT;
import org.uade.structure.definition.SimpleDictionaryADT;
import org.uade.structure.implementation.dynamics.DynamicSimpleDictionary;
import org.uade.structure.implementation.statics.StaticSimpleDictionary;

public class SimpleDictionaryHelpers {

    public static SimpleDictionaryADT copy (SimpleDictionaryADT dictionary)
    {
        SetADT keys = SetHelpers.copy(dictionary.getKeys());
        SimpleDictionaryADT copy = getInstance(dictionary);
        int key = 0;
        int item = 0;

        while(!keys.isEmpty()){
            key = keys.choose();
            item = dictionary.get(key);

            copy.add(key, item);
            keys.remove(key);
        }

        return copy;
    }

    public static void print(SimpleDictionaryADT dictionary)
    {
        SetADT keys = SetHelpers.copy(dictionary.getKeys());
        int key = 0;

        while(!keys.isEmpty()){
            key = keys.choose();

            System.out.println(key + ": " + dictionary.get(key));
            keys.remove(key);
        }
    }

    public static SimpleDictionaryADT getInstance(SimpleDictionaryADT dictionary)
    {
        return dictionary instanceof DynamicSimpleDictionary ? new DynamicSimpleDictionary() : new StaticSimpleDictionary();
    }
}
