package com.ustc.orange.gildedrose;

import androidx.annotation.NonNull;

public class Item {

  public static final int MAX_QUALITY = 50;
  public static final int MIN_QUALITY = 0;
  private static final int QUALITY_REDUCED_DEFAULT = 1;
  private static final int QUALITY_REDUCED_AFTER_EXPIRED = 2 * QUALITY_REDUCED_DEFAULT;

  public String name;
  public int sellIn;
  public int quality;

  public Item(@NonNull String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  protected void updateQuality() {
    sellIn--;
    quality = quality - getReducedQualityOneDay(sellIn);
    checkQuality();
  }

  /**
   * 每天价值下降的数值
   *
   * @param sellIn 剩余保质期
   * @return >0 表示下降  <0则为上升  =0则不变化
   */
  protected int getReducedQualityOneDay(int sellIn) {
    return sellIn >= 0 ? QUALITY_REDUCED_DEFAULT : QUALITY_REDUCED_AFTER_EXPIRED;
  }

  protected void checkQuality() {
    quality = Math.min(Item.MAX_QUALITY, Math.max(Item.MIN_QUALITY, quality));
  }

  @NonNull
  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}
