import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
    @Test
    public void isNumberTest(){
        Reader rd = new Reader();
        boolean n = rd.isNumber("s");

        assertEquals(n, false);
    }

    @Test
    public void getNodesTest(){
        ArrayList<String> refArray = new ArrayList<String>();
        Reader rd = new Reader();

        refArray.add("Mixco");
        refArray.add("Antigua");
        refArray.add("Escuintla");
        refArray.add("Santa-Lucia");
        refArray.add("Guatemala");

        assertEquals(refArray, rd.nodeArray);
    }
}