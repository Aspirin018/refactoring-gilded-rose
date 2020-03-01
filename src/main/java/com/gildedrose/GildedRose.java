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
                new BackstageUpdater().update(items[i]);
            } else {
                new SulfurasUpdater().update(items[i]);
            }
        }
    }
}
