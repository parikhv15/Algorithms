package Leetcode;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by vrajp on 3/18/2016.
 */

public class Solution {

    enum COLORS {
        blue (0),
        red (1)
        ;

        int code;

        COLORS(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }
    };

    public static void main(String args[] ) {
        System.out.println((int)3.9);
    }
}

class A {

    A() {
        System.out.println("C -> A");
    }

    public static void mA() {
        System.out.println("M -> A in A");
    }
}

class B extends A{
    B() {
        System.out.println("C -> B");
    }

    public static void mA() {
        System.out.println("M -> A in B");
    }

    public void mB() {
        System.out.println("M -> B");
    }
}