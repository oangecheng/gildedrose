package com.ustc.orange.gildedrose.items;

import com.ustc.orange.gildedrose.Item;

/**
 * 萨弗拉斯 物品，不具备保质期属性，因此不继承自普通物品直接实现
 * 价值不会变化
 */
public class SulfurasItem extends Item {

  private static final String NAME = "Sulfuras, Hand of Ragnaros";

  public SulfurasItem(int quality) {
    super(NAME, Integer.MAX_VALUE, quality);
  }

  @Override
  protected void updateQuality() {
    // do nothing
  }
}
