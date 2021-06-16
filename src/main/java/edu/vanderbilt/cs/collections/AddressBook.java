package edu.vanderbilt.cs.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ToDo
 *
 * Implement all of the methods in this class using either:
 *
 * 1. A single Java Map with a compound key strategy
 *    (e.g., String key = "person." +personName + ".phone." + phoneType)
 *
 * 2. A master map with sub-maps for each individual person
 *    String key = personName;
 *    Map personData = ....
 *    personData.put("phone" + phoneType, phoneNumber);
 *    Map addressBookData = ....
 *    addressBookData.put(key, personData);
 *
 * Whatever you do, you must have at least one Map that associates
 * a person's name with their data. It is not acceptable to have a
 * list of objects that you search through sequentially to find the
 * person in.
 *
 * There can only be one entry in the AddressBook for a given
 * name.
 *
 */
public class AddressBook {

    private  HashMap<String, HashMap<String, String>> addressBook = new HashMap<>();

    /**
     *
     * Sets the person's primary phone number in the address book
     *
     * Do not validate phone numbers
     *
     * @param personName
     * @param phoneNumber
     */
    public void setPersonPhoneNumber(String personName, String phoneNumber){
        HashMap<String, String> map = new HashMap<>();
        if(addressBook.containsKey(personName)){
            addressBook.get(personName).put("phoneNumber", phoneNumber);
        } else {
            map.put("phoneNumber", phoneNumber);
            addressBook.put(personName, map);
        }
    }

    public String getPersonPhoneNumber(String personName){
        return addressBook.get(personName).get("phoneNumber");
    }

    /**
     *
     * Sets a phone number for the person in the address book
     *
     * The phoneType is *arbitrary* and could be "mobile", "home", "office", "yacht" etc.
     *
     * Do not validate phone numbers
     *
     * @param personName
     * @param phoneNumber
     */
    public void setPersonPhoneNumber(String personName, String phoneType, String phoneNumber){
        HashMap<String, String> map = new HashMap<>();
        if(addressBook.containsKey(personName)){
            addressBook.get(personName).put(phoneType, phoneNumber);
        } else {
            map.put(phoneType, phoneNumber);
            addressBook.put(personName, map);
        }
    }

    public String getPersonPhoneNumber(String personName, String phoneType){
        return addressBook.get(personName).get(phoneType);
    }

    /**
     * Sets the person's email address
     *
     * Do not validate email addresses
     *
     * @param personName
     * @param email
     */
    public void setPersonEmail(String personName, String email){
        HashMap<String, String> map = new HashMap<>();
        if(addressBook.containsKey(personName)){
            addressBook.get(personName).put("email", email);
        } else {
            map.put("email", email);
            addressBook.put(personName, map);
        }
    }

    public String getPersonEmail(String personName){
        // return ((HashMap<String, String>)addressBook.get(personName)).get("email").toString();
        return addressBook.get(personName).get("email");
    }

    /**
     * Adds a note about the person
     *
     * Each note has a type to identify what it represents (e.g., birthday, favorite food,
     * where we met, etc.)
     *
     * Each person can only have one note of each type
     *
     * @param personName
     * @param noteType
     * @param data
     */
    public void setPersonNote(String personName, String noteType, String data){
        HashMap<String, String> map = new HashMap<>();
        if(addressBook.containsKey(personName)){
            addressBook.get(personName).put(noteType, data);
        } else {
            map.put(noteType, data);
            addressBook.put(personName, map);
        }
    }

    public String getPersonNote(String personName, String noteType){
        return addressBook.get(personName).get(noteType);
    }

    /**
     * Sets the age of the person
     *
     *
     * @param personName
     * @param age
     */
    public void setPersonAge(String personName, int age){
        HashMap<String, String> map = new HashMap<>();
        if(addressBook.containsKey(personName)){
            addressBook.get(personName).put("age", String.valueOf(age));
        } else {
            map.put("age", String.valueOf(age));
            addressBook.put(personName, map);
        }
    }

    public Integer getPersonAge(String personName){
        return Integer.parseInt(addressBook.get(personName).get("age"));
    }

    /**
     * Return the list of names of everyone in the address book
     *
     * @return
     */
    public String[] listNames(){
        return addressBook.keySet().toArray(new String[0]);  // or  (String[]) addressBook.keySet().toArray();
    }

    /**
     * Returns a list of the names that start with the specified
     * prefix.
     *
     * If the prefix is null, it should return all names
     *
     * Hint:
     *
     * String name = "Bob Smith";
     * assertTrue( name.startsWith("Bob"));
     *
     * assertEquals( addressBook.listNames().size(),
     *               addressBook.namesThatStartWith(null).size()
     *              );
     *
     * @param prefix
     * @return
     */
    public List namesThatStartWith(String prefix){
        if(prefix == null){
            return new ArrayList<>(addressBook.keySet());
        }
      
        return addressBook.entrySet().stream().filter(map -> map.getKey()
                                    .substring(0,prefix.length()).equals(prefix)) 
                                                .collect(Collectors.toList());  
    }


}
