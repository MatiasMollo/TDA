package org.uade.structure.utils;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamics.DynamicSet;
import org.uade.structure.implementation.statics.StaticSet;

public class SetHelpers {

    public static void print(SetADT original)
    {
        int element;
        SetADT set = copy(original);

        while(!set.isEmpty()){
            element = set.choose();
            System.out.println(element);
            set.remove(element);
        }
    }

    public static SetADT copy(SetADT set)
    {
        SetADT copy = getNewSet(set);
        SetADT temp = getNewSet(set);
        int number;

        while(!set.isEmpty()){
            number = set.choose();
            copy.add(number);
            temp.add(number);
            set.remove(number);
        }

        while(!temp.isEmpty()){
            number = temp.choose();
            set.add(number);
            temp.remove(number);
        }

        return copy;
    }

    public static SetADT getNewSet(SetADT set)
    {
        return set instanceof StaticSet ? new StaticSet() : new DynamicSet();
    }


}
