package quoters;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quoters.interfaces.Quoter;

public class QuotersTest {

    @Test
    public void testConfig() throws InterruptedException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(Quoter.class).sayQuote();
    }

    @Test
    public void testPropertiesDef() throws InterruptedException {
        PropertyFileApplicationContext context = new PropertyFileApplicationContext("context.properties");
        context.getBean(Quoter.class).sayQuote();
    }
}
