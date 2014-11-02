package com.lhcs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Ravi on 10/20/2014.
 */
public class ScannerTest {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner hello = new Scanner(new FileReader("E:\\test.txt"));
        while(hello.hasNextInt())
            System.out.println(hello.nextInt());

//        for (int i = 0; i < 3; i++) {
//            System.out.println(hello.nextInt());
//            System.out.println(hello.next());
//        }
    }
}
