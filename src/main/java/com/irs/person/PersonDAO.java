package com.irs.person;

/**
 *
 * @author Kenneth.Maposa
 */
import java.util.List;

/**
 *
 * @author nkululekophakela
 */
public interface PersonDAO {
    public List<Person> getPersons();
    public Person getPerson(Integer id);
    public void edit(Person person);
    public void addTitles(List<Title> titleList);
    public Title getTitle(int id);
    public Integer getLatestTitle();
    public void saveTitle(Title title);    
    public List<Title> getTitles();
    public void editTitle(Title title);
}
