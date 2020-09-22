package com.kbds.kbforum.authority;

import java.util.HashSet;

public class Test {
  public static void main(String[] args) {
    HashSet<String> set1 = new HashSet<String>();
    HashSet<String> set2 = new HashSet<String>();
    set1.add("test1");
    set2.add("test1");
    System.out.println("set1 hashCode : " + set1.hashCode());
    System.out.println("set2 hashCode : " + set2.hashCode());
  }
}
