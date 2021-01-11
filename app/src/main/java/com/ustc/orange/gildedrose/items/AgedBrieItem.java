package com.ustc.orange.gildedrose.items;

import com.ustc.orange.gildedrose.Item;

/**
 * 陈年干酪
 * 物品价值随着时间增长而增长
 */
public class AgedBrieItem extends Item {

  private static final int QUALITY_REDUCED_DEFAULT = -1;
  private static final String NAME = "Aged Brie";

  public AgedBrieItem(int sellIn, int quality) {
    super(NAME, sellIn, quality);
  }

  @Override
  protected int getReducedQualityOneDay(int sellIn) {
    return QUALITY_REDUCED_DEFAULT;
  }
}
