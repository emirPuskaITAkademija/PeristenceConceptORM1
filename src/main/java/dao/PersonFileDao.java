package dao;

import model.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Ova konkretna implementacija klase {@link Dao} će
 * snimati {@link Person} elemente u TXT file.
 */
public class PersonFileDao implements Dao<Person> {
    static final String FILE_NAME = "persons.txt";

    @Override
    public List<Person> readElements() {
        List<Person> personList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while ((line = br.readLine())!=null){
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String nin = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                String surname = tokenizer.nextToken();
                int age = Integer.parseInt(tokenizer.nextToken());
                Person person = new Person(nin, name, surname, age);
                personList.add(person);
            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        return personList;
    }

    @Override
    public void writeElements(List<Person> persons) {
        if (persons == null || persons.isEmpty()) {
            return;
        }
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME))) {
            //nin;name;surname;age
            for (Person person : persons) {
                String line = person.getNationalIdentificationNumber()
                        + ";" + person.getName()
                        + ";" + person.getSurname()
                        + ";" + person.getAge();
                out.println(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
