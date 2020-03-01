package com.gildedrose;

public class BackstageUpdater implements ItemUpdater {

    private static final int CRITICAL_QUALITY = 50;
    private static final int SELL_IN_UPPER_LIMIT = 11;
    private static final int SELL_IN_LOWER_LIMIT = 6;
    private static final int SELL_IN_QUALITY = 0;
    @Override
    public void update(Item item) {
        if (item.quality < CRITICAL_QUALITY) {
            item.quality++;
        }

        if (item.sellIn < SELL_IN_UPPER_LIMIT && item.quality < CRITICAL_QUALITY) {
            item.quality++;
        }

        if (item.sellIn < SELL_IN_LOWER_LIMIT && item.quality < CRITICAL_QUALITY) {
            item.quality++;
        }

        item.sellIn--;

        if (item.sellIn < SELL_IN_QUALITY) {
            item.quality = 0;
        }
    }
}
