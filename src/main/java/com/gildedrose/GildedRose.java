package com.gildedrose;

class GildedRose {
  Item[] items;
  private static final String AGED = "Aged Brie";
  private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
  private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      updateItem(item);
    }
  }

  private void updateItem(Item item) {
    modifyQuality(item);

    modifySellin(item);

    if (expiredItem(item)) {
      expiryMethod(item);
    }
  }

  private boolean expiredItem(Item item) {
    return item.sellIn < 0;
  }

  private void expiryMethod(Item item) {
    if (item.name.equals(AGED)) {
      increaseQualityIfLessThan50(item);
    }
    else if (item.name.equals(BACKSTAGE)) {
      item.quality = 0;
    }
    else {
      if (!item.name.equals(SULFURAS)) {
        decreaseQualityIfHigherThan0(item);
      }
    }
  }

  private void decreaseQualityIfHigherThan0(Item item) {
    if (item.quality > 0) {
      item.quality = item.quality - 1;
    }
  }
  

  private void modifySellin(Item item) {
    if (item.name.equals(SULFURAS)) {
      return;
    }
      item.sellIn--;
  }
  

  private void modifyQuality(Item item) {
    if (item.name.equals(AGED)){
      increaseQualityIfLessThan50(item);
    }
    else if (item.name.equals(BACKSTAGE)) {
      increaseQualityIfLessThan50(item);

      if (item.sellIn < 11) {
        increaseQualityIfLessThan50(item);
      }

      if (item.sellIn < 6) {
        increaseQualityIfLessThan50(item);
      }
    }
    else if (item.name.equals(SULFURAS)) {
      return;
    }
    else if (item.quality > 0) {
          item.quality = item.quality - 1;
    }
  }

  private void increaseQualityIfLessThan50(Item item) {
    if (item.quality < 50) {
      item.quality = item.quality + 1;
    }
  }
}
