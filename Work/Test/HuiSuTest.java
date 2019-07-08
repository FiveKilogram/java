import org.junit.Test;
import practice.HuiSu;

import static org.junit.Assert.*;

public class HuiSuTest {
    HuiSu h = new HuiSu();

    @Test
    public void hasPath() {

        char c[] = new String("ABCESFCSADEE").toCharArray();
        char b[] = new String("ABCCED").toCharArray();
        assertEquals(true, h.hasPath(c,3,4,b));






    }
}