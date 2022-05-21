package dao;

import model.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ova implementacije će snimati {@link Person} elemente u
 * JSON fajl.
 */
public class PersonJSONDao implements Dao<Person> {

    static final String FILE_NAME = "persons.json";

    /**
     * {@link JSONParser}
     * {@link JSONArray}
     * {@link JSONObject}
     *
     * @return elements
     */
    @Override
    public List<Person> readElements() {
        List<Person> personList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(FILE_NAME)) {
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                Person person = new Person();
                person.setNationalIdentificationNumber(jsonObject.get("nin").toString());
                person.setName(jsonObject.get("name").toString());
                person.setSurname(jsonObject.get("surname").toString());
                person.setAge(Integer.parseInt(jsonObject.get("age").toString()));
                personList.add(person);
            }
        } catch (IOException | ParseException e) {
            System.err.println(e.getMessage());
        }
        return personList;
    }

    /**
     * {@link JSONArray}
     * {@link JSONObject}
     * <p>
     * jsonArray -> persons
     * <p>
     * jsonObject -> person
     *
     * @param persons
     */
    @Override
    public void writeElements(List<Person> persons) {
        if (persons == null || persons.isEmpty()) {
            return;
        }
        JSONArray jsonArray = new JSONArray();
        for (Person person : persons) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nin", person.getNationalIdentificationNumber());
            jsonObject.put("name", person.getName());
            jsonObject.put("surname", person.getSurname());
            jsonObject.put("age", person.getAge());
            jsonArray.add(jsonObject);
        }
        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            String jsonArrayString = jsonArray.toJSONString();
            fileWriter.write(jsonArrayString);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
