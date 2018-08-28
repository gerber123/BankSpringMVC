package com.gerberjava.ownSpring.Utils;

import java.util.Set;

public class Ids
{
    public static int generateNewId(Set<Integer> keySoFar)
    {

        if (keySoFar.isEmpty())
        {
            return 0;
        }
        else
        {
            Integer integer = keySoFar.stream().max((o1,o2)->o1.compareTo(o2)).get();
            return integer + 1;
        }

    }
}
