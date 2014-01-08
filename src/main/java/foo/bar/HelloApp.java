package foo.bar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class HelloApp {
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloService helloService = context.getBean(HelloService.class);
        helloService.setUser(constructUserData());
        System.out.println(helloService.sayHello());
    }

    private static User constructUserData()
    {
        final User user = new User();
        user.setId(1L);
        user.setFirstname("Gayetri");
        user.setLastname("Bhattacharjee");
        user.setAge(35);

        // Biography
        Biography bio = new Biography();
        bio.setBirthPlace("Where pigs fly");
        bio.setDiplomas(Arrays.asList("Code cog", "Engineer"));
        bio.setDescription("Yet another code cog");
        user.setBio(bio);
        // Favorite Tags
        List<String> tags = new ArrayList<String>();
        tags.add("computing");
        tags.add("java");
        tags.add("cassandra");
        user.setFavoriteTags(tags);

        // Preferences
        Map<Integer, String> preferences = new HashMap<Integer, String>();
        preferences.put(1, "FR");
        preferences.put(2, "French");
        preferences.put(3, "Paris");
        user.setPreferences(preferences);
        return user;
    }

}
