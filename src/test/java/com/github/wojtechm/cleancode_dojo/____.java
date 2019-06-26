package com.github.wojtechm.cleancode_dojo;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.testng.annotations.Test;

import java.util.*;

public class ____ {

    @Test
    private void _____() {
        assert _.class.getDeclaredFields()[0].getName().equals("__________________________");
        assert _.class.getDeclaredFields()[1].getName().equals("______________________");
        assert _.class.getDeclaredFields()[2].getName().equals("______________________________________");
    }

    @Test
    private void ___() {
        Reflections _ = new Reflections("com.github.wojtechm.cleancode_dojo", new SubTypesScanner(false) );
        String __ = "_";
        Set ___ = _.getSubTypesOf(Object.class);
        List ____ = new ArrayList();
        for (Object o : ___) {
            if (!((Class)o).getName().contains("$")) {
                ____.add(o);
            }
        }
        Collections.sort(____, new Comparator() {
            public int compare(Object o1, Object o2) {
                Class c1 = (Class) o1;
                return c1.getName().compareTo(((Class) o2).getName());
            }
        });

        for (Object object : ____) {
            assert ((Class) object).getName().split("\\.")[((Class) object).getName().split("\\.").length-1].equals(__) : String.format("Expected %s, got %s", __, ((Class) object).getName().split("\\.")[((Class) object).getName().split("\\.").length -1]);
            __ += "_";
        }
    }

    @Test
    private void _________() {
        byte __ = (byte) new Random(111100010L).nextInt(2 << 4);
        byte ____ = _.__();
        assert __ == ____ : String.format("%d %d", ____, __);
    }
}