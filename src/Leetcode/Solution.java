package Leetcode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by vrajp on 3/18/2016.
 */
public class Solution {

    public static void main(String args[] ) throws Exception {
        A a = new B();

         a.mA();
        ((B)a).mA();
        ((B)a).mB();
//        a.mB();

    }
}

class A {
    A() {
//        System.out.println("C -> A");
    }

    public void mA() {
        System.out.println("M -> A in A");
    }
}

class B extends A{
    B() {
//        System.out.println("C -> B");
    }

    public void mA() {
        System.out.println("M -> A in B");
    }

    public void mB() {
        System.out.println("M -> B");
    }
}