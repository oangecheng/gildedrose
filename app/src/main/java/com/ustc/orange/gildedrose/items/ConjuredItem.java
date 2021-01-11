package com.ustc.orange.gildedrose.items;


import com.ustc.orange.gildedrose.Item;

/**
 * 魔法召唤物品
 * 价值减少速度是普通物品的{@link ConjuredItem#REDUCED_MULTIPLE}倍
 */
public class ConjuredItem extends Item {

  // 价值下降倍率
  private static final int REDUCED_MULTIPLE = 2;
  private static final String NAME = "conjured";

  public ConjuredItem(int sellIn, int quality) {
    super(NAME, sellIn, quality);
  }

  @Override
  protected int getReducedQualityOneDay(int sellIn) {
    return REDUCED_MULTIPLE * super.getReducedQualityOneDay(sellIn);
  }
}
