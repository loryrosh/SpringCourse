package quoters;

import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class PropertyFileApplicationContext extends GenericApplicationContext {
    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader beanReader = new PropertiesBeanDefinitionReader(this);
        int i = beanReader.loadBeanDefinitions(fileName);
        System.out.println("found " + i + " beans");
        refresh();
    }
}
