package day19;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class decendingOrder {
    @Test
    public void decending() throws IOException {
        List<String> listStrings = new ArrayList<String>();
        listStrings.add("John");
        listStrings.add("Jerry");
        listStrings.add("Mike");
        listStrings.add("Azamat");
        listStrings.add("Timur");

        System.out.println(listStrings);

        for (int i=0; i<=listStrings.size(); i++){
            String str = listStrings.get(i).toLowerCase();
            if (listStrings.get(i).charAt(0) > listStrings.get(i).charAt(0)){

            }
        }
    }
}
