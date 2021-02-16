package com.leetcode.easy;

// Classical Java implementation of singleton 
class Singleton
{
    private static Singleton obj;
 
    // getInstance() to create Singleton object
    private Singleton() {}
 
    public static Singleton getInstance()
    {
        if (obj == null)
            obj = new Singleton();
        return obj;
    }
}