package com.irs.person;

import java.util.List;
/**
 *
 * @author Kenneth.Maposa
 */
public interface PersonService {
    public List<Person> getPersons();
    public Person getPerson(Integer id);
    public void editPerson(Person person);
    public void addTitles(List<Title> titleList);
    public Integer getLatestTitle();
    public Title getTitle(int intValue);
    public void saveTitle(Title title);
    public List<Title> getTitles();
    public void editTitle(Title title);
}
