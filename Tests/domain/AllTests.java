package domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({PuntTest.class, SpelerTest.class, CirkelTest.class, LijnStukTest.class, RechthoekTest.class,
        DriehoekTest.class, TekeningTest.class, OmhullendeTest.class, WoordenLijstTest.class})
public class AllTests {
}
