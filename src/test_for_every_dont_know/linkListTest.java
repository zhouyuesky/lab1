package test_for_every_dont_know;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.*;

public class linkListTest {
	Graph T = null;
	private static linkList lnklist = new linkList();
	@Before
	public void setUp() throws Exception {
		T = new Graph("D:\\Users\\zhouyue\\Desktop\\test_for_every_dont_know\\test2.txt");
	}
	@Test
	public void testShortestroad() {
		lnklist.shortestroad("to","new");

	}
}
