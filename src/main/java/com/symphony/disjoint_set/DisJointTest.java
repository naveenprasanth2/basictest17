package com.symphony.disjoint_set;

public class DisJointTest {
public static void main(String[] args) {
    DisjointSet ds = new DisjointSet(5);
    System.out.println(ds.isSame(2, 4));
    ds.merge(2, 4);
    System.out.println(ds.isSame(2, 4));
    //false
    System.out.println(ds.isSame(3, 4));
    ds.merge(3, 4);
    System.out.println(ds.isSame(2, 3));
}
}
