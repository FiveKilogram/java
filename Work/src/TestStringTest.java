import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStringTest {
	
	TestString ts = new TestString();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPt() {
		String str = "rr";
		String str2 = "rr";
		ts.pt(str==str2);
		
	}






}
