package com.general;

import javafx.collections.transformation.SortedList;
import org.junit.Test;

import java.util.*;

/**
 * Created by Ravi on 9/25/2014.
 */
public class PermutationsTest {

    @Test
    public void testPermutations() {
//        Permutations perm = new Permutations();
//        List<Character> inputList = new ArrayList<Character>();
//        inputList.add('v');
//        inputList.add('a');
//        inputList.add('e');
//        inputList.add('y');
//        perm.printPermutations(inputList);

        try{
            Integer iObj= Integer.parseInt("9999");
        }catch (NumberFormatException nfe){

        }

        Country indiaCountry=new Country(1, "India");
        Country indiaCountry2=new Country(1, "India");
        Country chinaCountry=new Country(3, "USA");
        Country nepalCountry=new Country(4, "Russia");
        Country bhutanCountry=new Country(2, "Japan");

        List<Country> listOfCountries = new ArrayList<Country>();
        listOfCountries.add(indiaCountry);
        listOfCountries.add(indiaCountry2);
        listOfCountries.add(chinaCountry);
        listOfCountries.add(nepalCountry);
        listOfCountries.add(bhutanCountry);

        System.out.println("Before Sort by id : ");
        for (int i = 0; i < listOfCountries.size(); i++) {
            Country country=(Country) listOfCountries.get(i);
            System.out.println("Country Id: "+country.getCountryId()+"||"+"Country name: "+country.getCountryName());
        }

        Set<Country> countrySet = new TreeSet<>((country1, country2) -> (country1.getCountryId() < country2.getCountryId()) ? -1 : ((country1.getCountryId() > country2.getCountryId()) ? 1 : 0));
        countrySet.addAll(listOfCountries);
        List<Country> sortedCountries = new ArrayList<>(countrySet);
        for (int i = 0; i < sortedCountries.size(); i++) {
            Country country=(Country) sortedCountries.get(i);
            System.out.println("Country Id: "+country.getCountryId()+"|| "+"Country name: "+country.getCountryName());
        }



        Collections.sort(listOfCountries, (country1, country2) -> (country1.getCountryId() < country2.getCountryId() ) ? -1: (country1.getCountryId() > country2.getCountryId() ) ? 1:0);

        System.out.println("After Sort by id: ");
        for (int i = 0; i < listOfCountries.size(); i++) {
            Country country=(Country) listOfCountries.get(i);
            System.out.println("Country Id: "+country.getCountryId()+"|| "+"Country name: "+country.getCountryName());
        }

        //Sort by countryName
        Collections.sort(listOfCountries, new Comparator<Country>() {

            @Override
            public int compare(Country o1, Country o2) {
                return o1.getCountryName().compareTo(o2.getCountryName());
            }
        });

        System.out.println("After Sort by name: ");
        for (int i = 0; i < listOfCountries.size(); i++) {
            Country country=(Country) listOfCountries.get(i);
            System.out.println("Country Id: "+country.getCountryId()+"|| "+"Country name: "+country.getCountryName());
        }

    }

    class Country{
        int countryId;
        String countryName;

        public Country(int countryId, String countryName) {
            super();
            this.countryId = countryId;
            this.countryName = countryName;
        }

        public int getCountryId() {
            return countryId;
        }


        public void setCountryId(int countryId) {
            this.countryId = countryId;
        }


        public String getCountryName() {
            return countryName;
        }


        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

    }

}
