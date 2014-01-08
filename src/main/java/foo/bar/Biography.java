package foo.bar;

import java.util.List;

/**
 * User: gbhattac
 * Date: 1/6/14
 * Time: 1:20 PM
 */
public class Biography
{
	private String birthPlace;
	private List<String> diplomas;
	private String description;

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public List<String> getDiplomas() {
        return diplomas;
    }

    public void setDiplomas(List<String> diplomas) {
        this.diplomas = diplomas;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
