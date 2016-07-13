package com.xebia.hr.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anirudh on 03/08/15.
 */
public class Constants {
    public static final String ERROR = "error";
    public static final String FAILURE = "failure";
    public static final String SUCCESS = "success";
    public static final String DOUBLE_FORMAT = "0.00";

    public static void main(String[] args) {

        List<String> stringList1 = new ArrayList<>();
        stringList1.add("a");
        stringList1.add("b");
        stringList1.add("c");
        stringList1.add("d");
        stringList1.add("e");

        List<String> stringList2 = new ArrayList<>();
        stringList2.add("p");
        stringList2.add("q");
        stringList2.add("r");
        stringList2.add("s");
        stringList2.add("t");

        List<List<String>> parentList = new ArrayList<>();
        parentList.add(stringList1);
        parentList.add(stringList2);

        System.out.println(parentList.stream().anyMatch(e -> e.contains("a")));


    }
}
