package edu.vanderbilt.cs.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class AddressBook {

    
    private  HashMap<String, HashMap<String, String>> addressBook = new HashMap<>();


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
        if(addressBook.containsKey(personName) && addressBook.get(personName).containsKey("phoneNumber"))
            return addressBook.get(personName).get("phoneNumber");
        
        return null;
    }


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
        if(addressBook.get(personName).get(phoneType) != null)
            return addressBook.get(personName).get(phoneType);

        return null;
    }


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
        if(addressBook.get(personName).get("email") != null)
            return addressBook.get(personName).get("email");
        
        return null;
    }

    
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
        if(addressBook.get(personName).get(noteType) != null)
            return addressBook.get(personName).get(noteType);

        return null;
    }

   
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
        if(addressBook.containsKey(personName) && addressBook.get(personName).containsKey("age"))
            return Integer.parseInt(addressBook.get(personName).get("age"));
        
        return null;
    }

  
    public String[] listNames(){
        return addressBook.keySet().toArray(new String[0]);
    }

   
    public List namesThatStartWith(String prefix){
        if(prefix == null){
            return new ArrayList<>(addressBook.keySet());
        }

        return addressBook.entrySet().stream().filter(map -> map.getKey()
                                        .substring(0, prefix.length()).equals(prefix))
                                                    .map(Map.Entry::getKey).collect(Collectors.toList());
    }


}
