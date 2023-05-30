package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringListImplTest {

    private StringListImpl stringList = new StringListImpl(5);

    @BeforeEach
    public void list(){
        stringList.add("name1");
        stringList.add("name2");
        stringList.add("name3");
        stringList.add("name4");
        stringList.add("name5");
    }

    @AfterEach
    public void cleanList(){
        stringList.clear();
    }

    @Test
    public void addPositive(){
        int size = stringList.size();
        Assertions.assertEquals("name6",stringList.add("name6"));
        Assertions.assertEquals(size +1,stringList.size());
    }

    @Test
    public void addIndexPositive(){
        int index = 1;
        int size = stringList.size();
        Assertions.assertEquals("name6",stringList.add(index,"name6"));
        Assertions.assertEquals(index,stringList.indexOf("name6"));
        Assertions.assertEquals(size+1,stringList.size());
    }

    @Test
    public void removePositive(){
        int size = stringList.size();
        Assertions.assertEquals("name2",stringList.remove("name2"));
        Assertions.assertEquals(size - 1,stringList.size());
    }

    @Test
    public void removeIndexPositive(){
        int size = stringList.size();
        Assertions.assertEquals("name3",stringList.remove(2));
        Assertions.assertEquals(size - 1, stringList.size());
    }

    @Test
    public void removeNegativeTest(){
        Assertions.assertThrows(NullItemException.class,()->stringList.remove(-1));
    }


    @Test
    public void setPositive(){
        Assertions.assertEquals("name3",stringList.set(2,"name3"));
    }

    @Test
    public void contPositive(){

    }

}
