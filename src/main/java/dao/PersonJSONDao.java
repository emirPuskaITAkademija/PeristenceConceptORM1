package dao;

import model.Person;

import java.util.List;

/**
 * Ova implementacije će snimati {@link Person} elemente u
 * JSON fajl.
 */
public class PersonJSONDao implements Dao<Person> {
    @Override
    public List<Person> readElements() {
        return null;
    }

    @Override
    public void writeElements(List<Person> elements) {

    }
}
