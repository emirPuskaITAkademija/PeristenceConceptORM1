import dao.Dao;
import dao.PersonFileDao;
import dao.PersonJSONDao;
import dao.PersonSerializableDao;
import dao.PersonXMLDao;
import model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        //tranzijentan
        Person teodora = new Person("1233", "Teodora", "Marković", 33);
        Person semra = new Person("3233", "Semra", "Gačanin", 13);
        Person bilal27 = new Person("1111", "Bilal", "Hujdurović", 27);
        Person bilal21 = new Person("2222", "Bilal", "Sporišević", 21);
        Person nedim = new Person("2333232", "Nedim", "Čimić", 31);
        Person sarajlic = new Person("122323", "Emir", "Sarajlić", 43);

        List<Person> personList = List.of(teodora, semra, bilal21, bilal27, nedim, sarajlic);
        /**
         * Test upisivanja personList u persons.txt
         */
        //Dao<Person> personDao = new PersonFileDao();
        //personDao.writeElements(personList);ž

        /**
         * Test upisivanja personList u persons.dat
         */
//        Dao<Person> personDao = new PersonSerializableDao();
//        personDao.writeElements(personList);

        /**
         * Test upisivanja personList u persons.xml
         */
        //Dao<Person> personDao = new PersonXMLDao();
        //personDao.writeElements(new ArrayList<>(personList));


        /**
         * Test čitanja podataka iz persons.txt fajla
         */
//        List<Person> procitanePersone = personDao.readElements();
//        procitanePersone.forEach(System.out::println);

        /**
         * Test čitanja podataka iz persons.dat
         */
//        List<Person> procitanePersoneIzDat = personDao.readElements();
//        for (Person person : procitanePersoneIzDat){
//            System.out.println(person);
//        }
        /**
         * Test čitanja personList iz XML
         */
//        List<Person> xmlLista = personDao.readElements();
//        xmlLista.forEach(System.out::println);

        Dao<Person> personDao = new PersonJSONDao();
//        personDao.writeElements(personList);
        List<Person> jsonLista = personDao.readElements();
        for(Person person : jsonLista){
            System.out.println(person);
        }
    }
}
