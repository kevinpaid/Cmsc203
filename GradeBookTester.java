import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {

GradeBook g1 = new GradeBook(5);
GradeBook g2 = new GradeBook(5);


@BeforeEach
void setUp() throws Exception {

g1.addScore(20);
g1.addScore(50);
g2.addScore(45);
g2.addScore(25);
g2.addScore(30);

}

@AfterEach
void tearDown() throws Exception {
g1 = null;
g2 = null;
}

@Test
void testToString()
{
assertEquals("20.0 50.0 ", g1.toString());
assertEquals("45.0 25.0 30.0 ", g2.toString());
}

@Test
void testFinalScore() {
assertEquals(50, g1.finalScore());
assertEquals(75, g2.finalScore());
}

@Test
void testSum()
{
assertEquals(70, g1.sum(), .0001);
assertEquals(100, g2.sum(), .0001);

}

@Test
void testGetScoreSize() {
assertEquals(2, g1.getScoreSize());
assertEquals(3, g2.getScoreSize());

}
@Test
void testMinimum() {
assertEquals(20, g1.minimum(), .001);
assertEquals(25, g2.minimum(), .001);
}

@Test
void testAddScore() {
assertTrue(g1.toString().equals("20.0 50.0 "));
assertEquals(2, g1.getScoreSize());

assertTrue(g2.toString().equals("45.0 25.0 30.0 "));
assertEquals(3, g2.getScoreSize());
}
}
