package com.gildedrose;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;

    private static final Map<String, ItemUpdater> specialUpdateMapper = new HashMap<>(3);

    public GildedRose(Item[] items) {
        this.items = items;
    }

    static {
        specialUpdateMapper.put("Aged Brie", new AgedBrieUpdater());
        specialUpdateMapper.put("Backstage passes to a TAFKAL80ETC concert", new BackstageUpdater());
        specialUpdateMapper.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
    }

    public void updateItem() {
        Arrays.stream(items).forEach(item -> {
            if (specialUpdateMapper.containsKey(item.name)) {
                specialUpdateMapper.get(item.name).update(item);
            } else {
                new DefaultItemUpdater().update(item);
            }
        });
    }
}
