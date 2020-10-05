package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Game;
import main.Season;

class SeasonTest {

	Season s;
	Game g;
	@BeforeEach
	void setUp() throws Exception {
		s = new Season();
		g = new Game();
		s.addNewGame(g);
	}
	
	@Test
	void testGetMaxScore() {
		assertEquals(20, s.getMatches().get(0).getScore());
		fail("Not yet implemented");
	}

	@Test
	void testGetMinScore() {
		assertEquals(20, s.getMatches().get(0).getScore());
		fail("Not yet implemented");
	}

	@Test
	void testGetMaxRecordCount() {
		assertEquals(0, s.getMaxRecordCount());
		fail("Not yet implemented");
	}

	@Test
	void testGetMinRecordCount() {
		assertEquals(0, s.getMinRecordCount());
		fail("Not yet implemented");
	}

	@Test
	void testGetMatches() {
		Assertions.assertEquals(g, s.getMatches().get(0));
		fail("Not yet implemented");
	}

	@Test
	void testCheckMaxRecordCount() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckMinRecordCount() {
		fail("Not yet implemented");
	}

}
