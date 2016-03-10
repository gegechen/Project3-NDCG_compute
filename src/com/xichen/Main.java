package com.xichen;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String [] querys = new String[10];
        querys[0] = "mario";
//        querys[0] = "mondego";
//        querys[1] = "machine+learning";
//        querys[2] = "software+engineering";
//        querys[3] = "security";
//        querys[4] = "student+affair";
//        querys[5] = "graduate+courses";
//        querys[6] = "Crista+Lopes";
//        querys[7] = "REST";
//        querys[8] = "computer+games";
//        querys[9] = "information+retrieval";

        FunnyCrawler obj = new FunnyCrawler();
        obj.sendQueryAndFetch(querys);
    }
}
