package org.uade.structure.algorithms.Set;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamics.DynamicSet;
import org.uade.structure.implementation.statics.StaticSet;
import org.uade.structure.utils.SetHelpers;

public class StaticSetTest {
    public static void main(String[] args)
    {

        SetADT set = new StaticSet(2);

        set.add(10);
        set.remove(10);
        set.add(20);
        set.add(10);
        set.remove(10);




        SetHelpers.print(set);



    }
}
