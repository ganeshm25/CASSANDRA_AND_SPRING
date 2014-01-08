package foo.bar;

/**
 * User: gbhattac
 * Date: 1/6/14
 * Time: 1:15 PM
 */
import javax.persistence.Table;

import info.archinnov.achilles.annotations.Column;
import info.archinnov.achilles.annotations.Entity;
import info.archinnov.achilles.annotations.Id;
import info.archinnov.achilles.annotations.Lazy;

import java.util.List;
import java.util.Map;

@Entity
@Table(name="user")
public class User
{
	@Id
	private Long id;

    @Column
   	private Biography bio;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private Integer age;


    @Lazy
	@Column
	private List<String> favoriteTags;

	@Column
	private Map<Integer,String> preferences;

    public Long getId() {
        return id;
    }

    public Biography getBio() {
        return bio;
    }

    public void setBio(Biography bio) {
        this.bio = bio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public List<String> getFavoriteTags() {
        return favoriteTags;
    }

    public void setFavoriteTags(List<String> favoriteTags) {
        this.favoriteTags = favoriteTags;
    }

    public Map<Integer, String> getPreferences() {
        return preferences;
    }

    public void setPreferences(Map<Integer, String> preferences) {
        this.preferences = preferences;
    }
}

