package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") && !items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                new DefaultItemUpdater().update(items[i]);
            } else if (items[i].name.equals("Aged Brie")) {
                new AgedBrieUpdater().update(items[i]);
            } else if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
                updateBackstageQuality(items[i]);
            } else {
                updateSulfurasQuality(items[i]);
            }
        }
    }

    private void updateSulfurasQuality(Item item){}

    private void updateBackstageQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }

        if (item.sellIn < 11) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        if (item.sellIn < 6) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
