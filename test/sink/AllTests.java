package sink;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	BoardBlockTest.class, BoardTest.class, BoatTest.class, GameTest.class, PlayerTest.class,
	ScoreTest.class, TimeTest.class,
})

public class AllTests {
}
