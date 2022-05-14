package dao;

import model.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ova konkretna implementacija će snimati elemente tipa {@link Person}
 * tako što će ih serijalizovati u neki format koji nije human readable.
 */
public class PersonSerializableDao implements Dao<Person> {
    static final String FILE_NAME = "persons.dat";

    @Override
    public List<Person> readElements() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))){
            List<Person> personList =  (List<Person>) ois.readObject();
            return personList;
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    @Override
    public void writeElements(List<Person> persons) {
        try(ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            ous.writeObject(persons);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}
