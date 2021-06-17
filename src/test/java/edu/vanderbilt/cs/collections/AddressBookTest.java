package edu.vanderbilt.cs.collections;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTest {

    private static int randomInt(int min, int max) {
        int range = max - min;
        return min + (int) Math.rint(Math.random() * range);
    }

    private static String randomString() {
        return UUID.randomUUID().toString();
    }

    private static List<String> randomStringKeyValue() {
        return Collections.unmodifiableList(
                Arrays.asList(randomString(), randomString()));
    }

    private static List<List<String>> randomListOfKeyValuePairs(int min, int max){
        int total = randomInt(min, max);

        return Collections.unmodifiableList(
                IntStream.range(0,total).mapToObj(i -> randomStringKeyValue())
                .collect(Collectors.toList()));
    }

    private class RandomPersonData {
        public final String personName = randomString();
        public final String email = randomString();
        public final int age = randomInt(1,100);
        public final String phone = randomString();

        public final List<List<String>> randomPhones = randomListOfKeyValuePairs(0, 100);
        public final List<List<String>> randomNotes = randomListOfKeyValuePairs(0, 100);
    }



    /**
     * You should run this test by itself FIRST!
     *
     */
    @Test
    public void testSimpleEntry() {
        AddressBook addressBook = new AddressBook();

        String personName = "Bob Smith";
        String email = "bob.smith@vanderbilt.edu";
        int age = 48;
        String phone = "555-555-5555";
        String cell = "555-555-5555";
        String cellPhoneType = "cell";
        String randomNoteType = "birthday";
        String randomNoteContent = "not today";

        addressBook.setPersonAge(personName, 45);
        addressBook.setPersonEmail(personName, email);
        addressBook.setPersonAge(personName, age);
        addressBook.setPersonNote(personName, randomNoteType, randomNoteContent);
        addressBook.setPersonPhoneNumber(personName,phone);
        addressBook.setPersonPhoneNumber(personName, cellPhoneType, cell);

        assertEquals(phone, addressBook.getPersonPhoneNumber(personName));
        assertEquals(cell, addressBook.getPersonPhoneNumber(personName, cellPhoneType));
        assertEquals(null, addressBook.getPersonPhoneNumber("doesn't exist"));
        assertEquals(age, addressBook.getPersonAge(personName));
        assertEquals(randomNoteContent, addressBook.getPersonNote(personName, randomNoteType));
        assertEquals(null, addressBook.getPersonNote(personName, randomNoteContent));
        assertEquals(null, addressBook.getPersonPhoneNumber("bob smith"));
        assertEquals(null, addressBook.getPersonPhoneNumber("Bob"));

        String personName2 = "Jill Smith";
        String email2 = "jill.smith@vanderbilt.edu";
        int age2 = 49;
        String phone2 = "555-555-5555";
        String cell2 = "555-555-5556";
        String randomNoteContent2 = "tomorrow";
        String metAtNote = "met.at";
        String metAtContent = "unknown";

        addressBook.setPersonAge(personName2, age2);
        addressBook.setPersonEmail(personName2, email2);
        addressBook.setPersonNote(personName2, randomNoteType, randomNoteContent2);
        addressBook.setPersonNote(personName2, metAtNote, metAtContent);
        addressBook.setPersonPhoneNumber(personName2,phone2);
        addressBook.setPersonPhoneNumber(personName2, cellPhoneType, cell2);

        assertEquals(phone2, addressBook.getPersonPhoneNumber(personName2));
        assertEquals(cell2, addressBook.getPersonPhoneNumber(personName2, cellPhoneType));
        assertEquals(null, addressBook.getPersonPhoneNumber("doesn't exist"));
        assertEquals(age2, addressBook.getPersonAge(personName2));
        assertEquals(randomNoteContent2, addressBook.getPersonNote(personName2, randomNoteType));
        assertEquals(metAtContent, addressBook.getPersonNote(personName2, metAtNote));
        assertEquals(null, addressBook.getPersonNote(personName2, randomNoteContent));
        assertEquals(null, addressBook.getPersonPhoneNumber("jill smith"));
        assertEquals(null, addressBook.getPersonPhoneNumber("Jill"));

        assertEquals(phone, addressBook.getPersonPhoneNumber(personName));
        assertEquals(cell, addressBook.getPersonPhoneNumber(personName, cellPhoneType));
        assertEquals(null, addressBook.getPersonPhoneNumber("doesn't exist"));
        assertEquals(age, addressBook.getPersonAge(personName));
        assertEquals(randomNoteContent, addressBook.getPersonNote(personName, randomNoteType));
        assertEquals(null, addressBook.getPersonNote(personName, randomNoteContent));
        assertEquals(null, addressBook.getPersonPhoneNumber("bob smith"));
        assertEquals(null, addressBook.getPersonPhoneNumber("Bob"));

        List namesStartingWithBob = addressBook.namesThatStartWith("Bob");
        assertEquals(1, namesStartingWithBob.size());
        assertTrue(namesStartingWithBob.contains(personName));

        List namesStartingWithJill = addressBook.namesThatStartWith("Jill");
        assertEquals(1, namesStartingWithJill.size());
        assertTrue(namesStartingWithJill.contains(personName2));

        List namesStartingWithSerena = addressBook.namesThatStartWith("Serena");
        assertEquals(0, namesStartingWithSerena.size());

    }

    @Test
    public void testNullHandling(){
        AddressBook addressBook = new AddressBook();

        String personName = "Bob Smith";
        String email = null;
        int age = 48;
        String phone = null;
        String cell = null;
        String cellPhoneType = null;
        String randomNoteType = null;
        String randomNoteContent = null;

        addressBook.setPersonAge(personName, 45);
        addressBook.setPersonEmail(personName, email);
        addressBook.setPersonAge(personName, age);
        addressBook.setPersonNote(personName, randomNoteType, randomNoteContent);
        addressBook.setPersonPhoneNumber(personName,phone);
        addressBook.setPersonPhoneNumber(personName, cellPhoneType, cell);

        assertEquals(phone, addressBook.getPersonPhoneNumber(personName));
        assertEquals(cell, addressBook.getPersonPhoneNumber(personName, cellPhoneType));
        assertEquals(null, addressBook.getPersonPhoneNumber("doesn't exist"));
        assertEquals(age, addressBook.getPersonAge(personName));
        assertEquals(randomNoteContent, addressBook.getPersonNote(personName, randomNoteType));
        assertEquals(null, addressBook.getPersonNote(personName, randomNoteContent));
        assertEquals(null, addressBook.getPersonPhoneNumber("bob smith"));
        assertEquals(null, addressBook.getPersonAge("Bob"));

        List namesStartingWithBob = addressBook.namesThatStartWith("Bob");
        assertEquals(1, namesStartingWithBob.size());
        assertTrue(namesStartingWithBob.contains(personName));

        addressBook.setPersonAge("Jill", 30);
        addressBook.setPersonAge("Barbara", 72);

        List namesStartingWithNull = addressBook.namesThatStartWith(null);
        assertEquals(3, namesStartingWithNull.size());
    }

    /**
     * Run this test last as it will be the hardest to debug
     *
     *
     */
    @Test
    public void propertyBasedTesting(){
        AddressBook addressBook = new AddressBook();

        int totalEntries = randomInt(1, 1000);

        List<RandomPersonData> randomPeople = IntStream.range(0,totalEntries)
                .mapToObj(i -> new RandomPersonData())
                .collect(Collectors.toList());

        randomPeople
                .forEach(p ->{
                    addressBook.setPersonPhoneNumber(p.personName, p.phone);
                    addressBook.setPersonAge(p.personName, p.age);
                    addressBook.setPersonEmail(p.personName, p.email);
                    p.randomPhones.stream().forEach(phone ->
                            addressBook.setPersonPhoneNumber(p.personName, phone.get(0), phone.get(1)));
                    p.randomNotes.stream().forEach(note ->
                            addressBook.setPersonNote(p.personName, note.get(0), note.get(1)));
                });

        randomPeople
                .forEach(p ->{
                    assertEquals(p.phone, addressBook.getPersonPhoneNumber(p.personName));
                    assertEquals(p.age, addressBook.getPersonAge(p.personName));
                    assertEquals(p.email, addressBook.getPersonEmail(p.personName));
                    p.randomPhones.stream().forEach(phone ->
                            assertEquals(phone.get(1),
                                addressBook.getPersonPhoneNumber(p.personName, phone.get(0))));
                    p.randomNotes.stream().forEach(note ->
                            assertEquals(note.get(1),
                                addressBook.getPersonNote(p.personName, note.get(0))));
                });
    }


}
