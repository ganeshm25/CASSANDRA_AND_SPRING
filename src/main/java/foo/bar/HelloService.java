package foo.bar;

import info.archinnov.achilles.entity.manager.CQLPersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class HelloService {

    @Autowired
    private info.archinnov.achilles.entity.manager.CQLPersistenceManager manager;

    private User user;

    public String sayHello() {
        storeUser();
        final User user = findUser();
        return "Hello world " + user.getFirstname() + "!";
    }

    public void storeUser()
    {
        // Save user
        manager.persist(user);
    }

    public User findUser()
    {
        final User foundUser = manager.find(User.class, user.getId());
        return foundUser;
    }

    public List<String> updateUser(final User updatedUser)
    {
        final User foundUser = manager.merge(updatedUser);
        return foundUser.getFavoriteTags();
    }

    public void deleteUserById()
    {
        manager.removeById(User.class, user.getId());
    }

    public void deleteUser()
    {
        User foundUser = manager.find(User.class, user.getId());
        manager.remove(foundUser);
    }

    public CQLPersistenceManager getManager()
    {
        return manager;
    }

    public void setManager(CQLPersistenceManager manager)
    {
        this.manager = manager;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
