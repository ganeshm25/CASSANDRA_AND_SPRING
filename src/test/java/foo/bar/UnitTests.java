package foo.bar;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * User: gbhattac
 * Date: 1/7/14
 * Time: 2:53 PM
 */
import info.archinnov.achilles.junit.AchillesCQLResource;
import info.archinnov.achilles.junit.AchillesCQLResourceBuilder;
import org.junit.Rule;

import java.util.*;

public class UnitTests
{
    private HelloService helloService = new HelloService();

    @Rule
    public AchillesCQLResource resource = AchillesCQLResourceBuilder.withEntityPackages
            ("foo.bar").truncateBeforeAndAfterTest().build();

    @Before
    public void setupConnection()
    {
        helloService.setManager(resource.getPersistenceManager());
    }

    @Test
    public void testStoreUser()
    {
        helloService.setUser(constructUserData());
        helloService.storeUser();
        Assert.assertEquals("Gayetri", helloService.findUser().getFirstname());
        helloService.deleteUser();
    }

    @Test
    public void testFindUser()
    {
        helloService.setUser(constructUserData());
        helloService.storeUser();
        Assert.assertFalse("Dummy".equals(helloService.findUser()));
        helloService.deleteUser();
    }

    @Test
    public void testUpdateUser()
    {
        helloService.setUser(constructUserData());
        helloService.storeUser();
        final User foundUser = helloService.findUser();
        foundUser.getFavoriteTags().add("achilles");
        helloService.updateUser(foundUser);
        final List<String> favTags = helloService.findUser().getFavoriteTags();
        Assert.assertTrue(favTags.contains("achilles"));
        helloService.deleteUser();
    }

    @Test
    public void testDeleteUser()
    {
        helloService.setUser(constructUserData());
        helloService.storeUser();
        helloService.deleteUser();
        Assert.assertTrue(helloService.findUser() == null);
    }

    @Test
    public void testDeleteUserById()
    {
        helloService.setUser(constructUserData());
        helloService.storeUser();
        helloService.deleteUserById();
        Assert.assertTrue(helloService.findUser() == null);
    }

    private User constructUserData()
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



