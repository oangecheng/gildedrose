package com.ustc.orange.gildedrose.items;

import androidx.annotation.NonNull;

import com.ustc.orange.gildedrose.Item;

/**
 * 后台门票
 * 物品价值随保质期sellIn变化：
 * sellIn  [10, MAX) 每天 +1
 * sellIn  [5, 10)   每天 +2
 * sellIn  [0, 5)    每天 +3
 * sellIn  (MIN, 0)  变为 0
 */
public class BackstagePassItem extends Item {

  private static final int QUALITY_REDUCED_DEFAULT = -1;
  private static final int QUALITY_REDUCED_IN_10_DAYS = -2;
  private static final int QUALITY_REDUCED_IN_5_DAYS = -3;
  private static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

  public BackstagePassItem(int sellIn, int quality) {
    super(NAME, sellIn, quality);
  }

  @Override
  protected int getReducedQualityOneDay(int sellIn) {
    if (sellIn >= 10) {
      return QUALITY_REDUCED_DEFAULT;
    } else if (sellIn >= 5) {
      return QUALITY_REDUCED_IN_10_DAYS;
    } else if (sellIn >= 0) {
      return QUALITY_REDUCED_IN_5_DAYS;
    }
    return Item.MAX_QUALITY;
  }
}
