package unicalc.test;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import unicalc.semantics.MyUnitList;
import unicalc.semantics.UnitList;

@RunWith(JUnit4.class)
public class MyUnitListTest {

    @Test
    public void cancel1() {
        UnitList list1 = new MyUnitList("m", "m", "s");
        UnitList list2 = new MyUnitList("kg", "m", "s", "s");
        UnitList result = new MyUnitList("m");
        Assert.assertEquals(result, list1.cancel(list2));
    }
    
    @Test
    public void cancel2() {
        UnitList list1 = new MyUnitList("m", "s");
        UnitList list2 = new MyUnitList("kg", "m", "s", "s");
        UnitList result = new MyUnitList();
        Assert.assertEquals(result, list1.cancel(list2));
    }
    
    @Test
    public void cancel3() {
        UnitList list1 = new MyUnitList("m", "s", "s", "s");
        UnitList list2 = new MyUnitList("kg", "m", "s", "s");
        UnitList result = new MyUnitList("s");
        Assert.assertEquals(result, list1.cancel(list2));
    }
    
    @Test
    public void cancel4() {
        UnitList list1 = new MyUnitList("kg", "m", "s", "s");
        UnitList list2 = new MyUnitList("m", "m", "s");
        UnitList result = new MyUnitList("kg", "s");
        Assert.assertEquals(result, list1.cancel(list2));
    }
    
    @Test
    public void cancel5() {
        UnitList list1 = new MyUnitList("kg", "m", "m", "s");
        UnitList list2 = new MyUnitList("kg", "kg", "m", "s");
        UnitList result = new MyUnitList("m");
        Assert.assertEquals(result, list1.cancel(list2));
    }
    
    @Test
    public void merge1() {
        UnitList list1 = new MyUnitList("m", "m", "s");
        UnitList list2 = new MyUnitList("kg", "m", "s", "s");
        UnitList expected = new MyUnitList("kg", "m", "m", "m", "s", "s", "s");
        Assert.assertEquals(expected, list1.merge(list2));
    }
    
    @Test
    public void nMerge1() {
        UnitList list = new MyUnitList("kg", "m", "s");
        UnitList expected = new MyUnitList();
        Assert.assertEquals(expected, list.nMerge(0));
    }
    
    @Test
    public void nMerge2() {
        UnitList list = new MyUnitList("kg", "m", "s");
        UnitList expected = list;
        Assert.assertEquals(expected, list.nMerge(1));
    }
    
    @Test
    public void nMerge3() {
        UnitList list = new MyUnitList("kg", "m", "s");
        UnitList expected = new MyUnitList("kg", "kg", "m", "m", "s", "s");
        Assert.assertEquals(expected, list.nMerge(2));
    }
}
