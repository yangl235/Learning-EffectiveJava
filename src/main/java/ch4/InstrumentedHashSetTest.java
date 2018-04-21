package ch4;

import java.util.Arrays;

public class InstrumentedHashSetTest {
    public static void main(String[] args) {
        InstrumentedHashSet s = new InstrumentedHashSet();
        //实际打印即如果为6
        s.addAll(Arrays.asList(new String[]{"Snap", "Crackle", "Pop"}));
        System.out.println(s.getAddCount());
    }

}
