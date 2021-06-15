package edu.vanderbilt.cs.collections;

import java.util.Iterator;
import java.util.List;

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

    }

    public String getPersonPhoneNumber(String personName){
        return null;
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

    }

    public String getPersonPhoneNumber(String personName, String phoneType){
        return null;
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

    }

    public String getPersonEmail(String personName){
        return null;
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

    }

    public String getPersonNote(String personName, String noteType){
        return null;
    }

    /**
     * Sets the age of the person
     *
     *
     * @param personName
     * @param age
     */
    public void setPersonAge(String personName, int age){

    }

    public Integer getPersonAge(String personName){
        return null;
    }

    /**
     * Return the list of names of everyone in the address book
     *
     * @return
     */
    public String[] listNames(){
        return null;
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
        return null;
    }


}
