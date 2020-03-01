package com.gildedrose;


import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class GildedRoseTest {

    @Test
    public void should_reduced_by_1_when_is_not_special_item_and_quality_more_than_zero() {
        Item[] items = new Item[] { new Item("milk", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.update_quality();
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sell_in, is(0));
    }
}
