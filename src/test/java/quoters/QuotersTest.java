package quoters;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuotersTest {
    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("context.xml");
    }

    @Test
    public void testConfig() {
        context.getBean(TerminatorQuoter.class).sayQuote();
    }


}
