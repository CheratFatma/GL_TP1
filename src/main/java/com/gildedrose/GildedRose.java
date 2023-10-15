package com.gildedrose;

class GildedRose {
  Item[] items;

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
    if (!item.name.equals("Aged Brie")) {
      if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        if (item.quality > 0) {
          if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
          }
        }
      } else {
        item.quality = 0;
      }
    } else {
      increaseQualityIfLessThan50(item);
    }
  }

  private void modifySellin(Item item) {
    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
      item.sellIn--;
    }
  }

  private void modifyQuality(Item item) {
    if (item.name.equals("Aged Brie")){
      increaseQualityIfLessThan50(item);
    }
    else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      increaseQualityIfLessThan50(item);

      if (item.sellIn < 11) {
        increaseQualityIfLessThan50(item);
      }

      if (item.sellIn < 6) {
        increaseQualityIfLessThan50(item);
      }
    }
    else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
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

