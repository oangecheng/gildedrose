package com.ustc.orange.gildedrose;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import com.ustc.orange.gildedrose.items.AgedBrieItem;
import com.ustc.orange.gildedrose.items.BackstagePassItem;
import com.ustc.orange.gildedrose.items.ConjuredItem;
import com.ustc.orange.gildedrose.items.SulfurasItem;

public class GildedRoseTestV2 {

  @Test
  public void test_AgedBrieItem() {
    testAgedBrieItem();
  }

  @Test
  public void test_BackstageItem() {
    testBackstageItem();
  }

  @Test
  public void test_ConjuredItem() {
    testConjuredItem();
  }

  @Test
  public void test_NormalItem() {
    testNormalItem();
  }

  @Test
  public void test_SulfurasItem() {
    testSulfurasItem();
  }

  private void testAgedBrieItem() {
    Item item = new AgedBrieItem(20, 20);
    Item old = new Item("Aged Brie", 20, 20);

    check(item, old, 10);
    check(item, old, 10);
    check(item, old, 20);
  }

  private void testBackstageItem() {
    Item item = new BackstagePassItem(20, 20);
    Item old = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 20);

    check(item, old, 5);
    check(item, old, 7);
    check(item, old, 3);
    check(item, old, 3);
    check(item, old, 2);
    check(item, old, 2);
  }

  /**
   * 新增物品
   */
  private void testConjuredItem() {
    String name = "conjured";
    Item item = new ConjuredItem(20, 20);

    passedDays(item, 5);
    assertThat(item.name, is(name));
    assertThat(item.quality, is(10));
    assertThat(item.sellIn, is(15));

    passedDays(item, 5);
    assertThat(item.name, is(name));
    assertThat(item.quality, is(0));
    assertThat(item.sellIn, is(10));

    passedDays(item, 25);
    assertThat(item.name, is(name));
    assertThat(item.quality, is(0));
    assertThat(item.sellIn, is(-15));
  }

  private void testNormalItem() {
    String name = "normal";
    Item item = new Item(name, 20, 20);
    Item old = new Item(name, 20, 20);

    check(item, old, 5);
    check(item, old, 5);
    check(item, old, 25);
  }

  private void testSulfurasItem() {
    Item item = new SulfurasItem(20);
    Item old = new Item("Sulfuras, Hand of Ragnaros", Integer.MAX_VALUE, 20);

    check(item, old, 5);
    check(item, old, 5);
    check(item, old, 25);
  }

  private void passedDays(Item item, int days) {
    for (int i = 0; i < days; i++) {
      item.updateQuality();
    }
  }

  private void oldItemPassDays(Item item, int days) {
    Item[] items = new Item[]{item};
    GildedRose rose = new GildedRose(items);
    for (int i = 0; i < days; i++) {
      rose.updateQuality();
    }
  }

  private void check(Item item, Item old, int passedDays) {
    passedDays(item, passedDays);
    oldItemPassDays(old, passedDays);
    assertThat(item.name, is(old.name));
    assertThat(item.quality, is(old.quality));
    assertThat(item.sellIn, is(old.sellIn));
  }
}
