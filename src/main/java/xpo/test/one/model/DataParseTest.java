package xpo.test.one.model;

import org.junit.Test;

public class DataParseTest {
    String str ="#.x....O..";

    @org.junit.Test
    public void getMatrix() {
    }

    @Test
    public void RegexTest()
    {
        DataParse dataParse= new DataParse(str);
        dataParse.checkSize(str);

    }
}