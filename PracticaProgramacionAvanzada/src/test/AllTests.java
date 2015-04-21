package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClienteTest.class, LlamadaTest.class, ParticularTest.class,
		TarifaTest.class })
public class AllTests {

}
