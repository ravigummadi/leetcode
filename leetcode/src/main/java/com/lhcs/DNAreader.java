package com.lhcs;

import java.util.*;
import java.io.*;
public class DNAreader
{
    public static void main(String[] args)throws FileNotFoundException
    {
        File file = new File("D:\\Other\\FilesForHomework\\dna.txt");
        Scanner hola = new Scanner(file);
        while(hola.hasNextLine())
        {
            prettyMuchMainMethod(hola);
        }
    }

    public static void prettyMuchMainMethod(Scanner hola)throws FileNotFoundException
    {
        //Finds the file and gets the protein's name and definition
        String regionName = hola.nextLine();
        String Nucleotides = hola.nextLine();

        //changes the protein definition to be more readable by the computer and declares useful variables
        Nucleotides.toUpperCase();
        String NucleotidesWithDashes = Nucleotides;
        Nucleotides = Nucleotides.replace("-", "");
        double totalMass = totalMass(NucleotidesWithDashes);

        //prints the cool stuff found out by your cool code
        System.out.println("Region Name: " + regionName);
        System.out.println("Nucleotides: " + NucleotidesWithDashes);
        System.out.println("Nuc. Counts: " + Arrays.toString(nucCounts(Nucleotides)));
        System.out.println("Total Mass%: " + Arrays.toString(massPercentages(totalMass, Nucleotides)) + " of " + totalMass);
        System.out.println("Codons List: " + Arrays.toString(codonList(Nucleotides)));
        if (isProtein(Nucleotides, totalMass))
            System.out.println("Is Protein?: YES");
        else
            System.out.println("Is Protein?: NO");

        //prints some whitespace
        System.out.println();
    }
    //end of main method

    //start of "nucCounts" method
    public static int[] nucCounts(String Nucleotides) throws FileNotFoundException
    {
        int[] nucCounts = new int[4];

        //for loop that counts the number of Nucleotides in a protein
        for (int i = 0; i < Nucleotides.length(); i ++)
        {
            if(Nucleotides.charAt(i) == 'A')
                nucCounts[0]++;
            if(Nucleotides.charAt(i) == 'C')
                nucCounts[1]++;
            if(Nucleotides.charAt(i) == 'G')
                nucCounts[2]++;
            if(Nucleotides.charAt(i) == 'T')
                nucCounts[3]++;
        }

        return nucCounts;
    }
    //end of "nucCounts" method

    //start of "totalMass" method
    public static double totalMass(String NucleotidesWithDashes)
    {
        double totalMass = 0;

        //for loop to find the mass of the protein in grams/mol
        for(int i = 0; i < NucleotidesWithDashes.length(); i ++)
        {
            if(NucleotidesWithDashes.toUpperCase().charAt(i) == 'A')
                totalMass+=135.128;
            if(NucleotidesWithDashes.toUpperCase().charAt(i) == 'C')
                totalMass+=111.103;
            if(NucleotidesWithDashes.toUpperCase().charAt(i) == 'G')
                totalMass+=151.128;
            if(NucleotidesWithDashes.toUpperCase().charAt(i) == 'T')
                totalMass+=125.107;
            if(NucleotidesWithDashes.toUpperCase().charAt(i) == '-')
                totalMass+=100.000;
        }

        totalMass = Math.round(totalMass * 10.0) / 10.0;
        return totalMass;
    }
    //end of "totalMass" method

    //start of "massPercentages" method
    public static double[] massPercentages(double totalMass, String Nucleotides)
    {
        double[] massPercentages = new double[4];
        double Amass = 0.0;
        double Cmass = 0.0;
        double Gmass = 0.0;
        double Tmass = 0.0;

        //for loop to calculate the mass of each respective nucleotide
        for(int i = 0; i < Nucleotides.length(); i ++)
        {
            if(Nucleotides.charAt(i) == 'A')
                Amass+=135.128;
            if(Nucleotides.charAt(i) == 'C')
                Cmass+=111.103;
            if(Nucleotides.charAt(i) == 'G')
                Gmass+=151.128;
            if(Nucleotides.charAt(i) == 'T')
                Tmass+=125.107;
        }

        //Formats each of the masses to a percentage
        Amass = Math.round((Amass * 1000.0 / totalMass));
        Amass = Amass / 10.0;

        Cmass = Math.round((Cmass * 1000.0 / totalMass));
        Cmass = Cmass / 10.0;

        Gmass = Math.round((Gmass * 1000.0 / totalMass));
        Gmass = Gmass / 10.0;

        Tmass = Math.round((Tmass * 1000.0 / totalMass));
        Tmass = Tmass / 10.0;

        //sets each mass to their respective array slot
        massPercentages[0] = Amass;
        massPercentages[1] = Cmass;
        massPercentages[2] = Gmass;
        massPercentages[3] = Tmass;

        return massPercentages;
    }
    //end of "massPercentages" method

    //start of "typesOfCodons" method
    public static String[] codonList(String Nucleotides)
    {
        String[] codonList = new String[Nucleotides.length() / 3];
        for(int i = 0; i < Nucleotides.length(); i+=3)
        {
            codonList[i/3] = Nucleotides.substring(i, i+3).toUpperCase();
        }

        return codonList;
    }
    //end of "typesOfCodons" method

    //start of "isProtein" method
    public static boolean isProtein(String Nucleotides, double totalMass)
    {
        boolean isProtein = false;
        String NucleotidesStart = codonList(Nucleotides)[0];
        String NucleotidesEnd = codonList(Nucleotides)[codonList(Nucleotides).length - 1];

        if(Nucleotides.length() / 3 >= 5)
            if(massPercentages(totalMass, Nucleotides)[1] + massPercentages(totalMass, Nucleotides)[2] >= 30.0)
                isProtein = true;

        if(!NucleotidesStart.equals("ATG"))
            isProtein = false;

        if(!(NucleotidesEnd.equals("TAA") || NucleotidesEnd.equals("TAG") || NucleotidesEnd.equals("TGA")))
            isProtein = false;

        return isProtein;
    }
    //end of "isProtein" method

}//end of class