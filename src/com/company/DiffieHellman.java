package com.company;

import java.math.BigInteger;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class DiffieHellman {

    public static void main(String[] args)
    {
        Random random = new Random();
        long x, y, ka, kb;

        long n = 7237;
        System.out.println("The value of P:" + n);

        long g = findRoot(n);
        System.out.println("The value of G:" + g);

        //=========================PERSON1

        int a = random.nextInt();
            while(a < 0)
                a = random.nextInt();
        System.out.println("Prywatny klucz osoby1 = " + a);

        x = power(g, a, n);

        //=========================PERSON2
        int b = random.nextInt();
        while(b < 0)
            b = random.nextInt();

        System.out.println("Prywatny klucz osoby2 = " + b);

        y = power(g, b, n);

        //=================================

        ka = power(y, a, n); //zamiana kluczy
        kb = power(x, b, n);

        System.out.println("k dla osoby1 = " + ka);
        System.out.println("k dla osoby2 = " + kb);
        }

    private static int findRoot(long n){
        Set<BigInteger> set = new TreeSet<>();
        for(int i = 2; i < n; i++) {
            set.clear();
            for (int j = 0; j < n - 1; j++) {
                set.add(BigInteger.valueOf(i).modPow(BigInteger.valueOf(j), BigInteger.valueOf(n)));
            }
            if(set.size() == n-1){
                return  i;
            }
        }
        return 0;
    }

    private static long power(long a, long b, long p) {
        if (b == 1)
            return a;
        else
            return (((long)Math.pow(a, b)) % p);
    }
}




