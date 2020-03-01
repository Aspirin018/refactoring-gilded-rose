package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater {

    private static final int CRITICAL_QUALITY = 50;
    private static final int CRITICAL_SELL_IN = 0;
    @Override
    public void update(Item item) {
        if (item.quality < CRITICAL_QUALITY) {
            item.quality++;
        }
        if (--item.sellIn < CRITICAL_SELL_IN && item.quality < CRITICAL_QUALITY) {
            item.quality++;
        }
    }
}
