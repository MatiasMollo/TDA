package org.uade.structure.algorithms.Set;

import org.uade.structure.definition.SetADT;
import org.uade.structure.implementation.dynamics.DynamicSet;
import org.uade.structure.implementation.statics.StaticSet;
import org.uade.structure.utils.SetHelpers;

public class StaticSetTest {
    public static void main(String[] args)
    {

        SetADT set = new DynamicSet();

        set.add(10);
        set.add(20);
        set.add(30);


        SetADT copy = SetHelpers.copy(set); // !!! PROBLEMA COPIANDO DYNAMIC !!!
        copy.add(40); // CON DYNAMIC, PROBLEMA DE "EL ELEMENTO YA SE ENCUENTRA..." EN COPY

        SetHelpers.print(copy);



    }
}
