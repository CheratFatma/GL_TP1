package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {
  //Tester NAME
  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo", element.name, "the name changed");
  }

  //Tester QUALITY
  @Test
  @DisplayName("Test that the quality is unchanged")
  void testQuality(){
    Item element = new Item("foo", 0, 1); 
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "the quality changed");
  }

  //Tester SELLIN
  @Test
  @DisplayName("Test that the Sellin is unchanged")
  void testSellin(){
    Item element = new Item("foo", 0, 0) ; 
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "the Sallin changed");
  }

  //Tester ToSTRING
  @Test
  @DisplayName("Test toString")
  void testToString2() {
    Item element = new Item("foo", 1, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    String result = "foo" + ", " + 0 + ", " + 1;
    assertEquals(result  , element.toString(), "the tostring changed");
  }

  //Tester UpdateQuality
  @Test 
  @DisplayName("Test UpdateQuality")
  void testUpdateQuality(){

    Item [] items= new Item []{
      //jacoco (8 tests) Line Coverage
      new Item("Hello", -1, 70),//s<0 (ligne 43)
      new Item("Aged Brie", -5, 0), //s<0 q<50 (ligne 56)
      new Item("Aged Brie", -2, 50), //q<50 (ligne 55)
      new Item("Backstage passes to a TAFKAL80ETC concert", -1, -1),//s<0, q<0 (ligne 52)
      new Item("Backstage passes to a TAFKAL80ETC concert",10 , 49),//q<50 (ligne 25)
      new Item("Backstage passes to a TAFKAL80ETC concert",4 , 48),//s<6 q<50 (ligne 31)
      new Item("Backstage passes to a TAFKAL80ETC concert",11 , 30),//s<11 (ligne 24)
      new Item("Sulfuras, Hand of Ragnaros", -1, 20),//(lignes 15 39 47)

      //pitest (2 tests) Mutation Coverage
      new Item("Backstage passes to a TAFKAL80ETC concert", 5, -20), 
      new Item("Backstage passes to a TAFKAL80ETC concert",6, 30), 
    };

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    /***** quality *****/
    assertEquals(68,items[0].quality,"the quality changed"); //q-2
    assertEquals(2,items[1].quality,"the quality changed");  //q+2
    assertEquals(50,items[2].quality,"the quality changed"); //q
    assertEquals(0,items[3].quality,"the quality changed");  //q+1
    assertEquals(50,items[4].quality,"the quality changed"); //q+1
    assertEquals(50,items[5].quality,"the quality changed"); //q+2
    assertEquals(31,items[6].quality,"the quality changed"); //q+1
    assertEquals(20,items[7].quality,"the quality changed"); //q

    assertEquals(-17,items[8].quality,"the quality changed"); //q+3
    assertEquals(32,items[9].quality,"the quality changed");  //q+2
  
    
    /****** sellIn ******/
    assertEquals(-2,items[0].sellIn,"the sellin changed"); //s-1
    assertEquals(-6,items[1].sellIn,"the sellin changed"); //s-1
    assertEquals(-3,items[2].sellIn,"the sellin changed"); //s-1
    assertEquals(-2,items[3].sellIn,"the sellin changed"); //s-1
    assertEquals(9,items[4].sellIn,"the sellin changed");  //s-1
    assertEquals(3,items[5].sellIn,"the sellin changed");  //s-1
    assertEquals(10,items[6].sellIn,"the sellin changed"); //s-1
    assertEquals(-1,items[7].sellIn,"the sellin changed"); //s

    assertEquals(4,items[8].sellIn,"the sellin changed"); //s-1
    assertEquals(5,items[9].sellIn,"the sellin changed"); //s-1

  }
  
}


