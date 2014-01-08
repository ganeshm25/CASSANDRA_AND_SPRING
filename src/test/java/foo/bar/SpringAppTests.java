package foo.bar;

import info.archinnov.achilles.junit.AchillesCQLResource;
import info.archinnov.achilles.junit.AchillesCQLResourceBuilder;
import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class SpringAppTests
{
    @Autowired
    private HelloService helloService = new HelloService();

    @Test
    public void testSayHello()
    {
        helloService.storeUser();
        Assert.assertEquals("Hello world" +  " Gayetri" + "!", helloService.sayHello());
    }
}
