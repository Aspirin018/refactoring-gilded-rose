package com.gildedrose;


import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class GildedRoseTest {

    @Test
    public void should_reduced_by_1_when_is_not_special_item_and_quality_more_than_zero() {
        Item[] items = new Item[] { new Item("milk", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(4));
        assertThat(app.items[0].sellIn, is(0));
    }

    @Test
    public void should_not_change_when_is_not_special_item_and_quality_not_more_than_zero() {
        Item[] items = new Item[] { new Item("milk", 1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(0));
        assertThat(app.items[0].sellIn, is(0));
    }

    @Test
    public void should_be_reduced_by_2_when_is_not_special_item_and_quality_more_than_zero_and_sellin_less_than_zero() {
        Item[] items = new Item[] { new Item("milk", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(3));
        assertThat(app.items[0].sellIn, is(-1));
    }

    @Test
    public void should_be_reduced_by_1_when_is_not_special_item_and_quality_is_1_and_sellin_less_than_zero() {
        Item[] items = new Item[] { new Item("milk", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(0));
        assertThat(app.items[0].sellIn, is(-1));
    }

    @Test
    public void should_be_added_by_1_when_is_Aged_Brie_and_quality_less_than_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(6));
        assertThat(app.items[0].sellIn, is(0));
    }

    @Test
    public void should_not_change_when_is_Aged_Brie_and_quality_not_less_than_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 51) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(51));
        assertThat(app.items[0].sellIn, is(0));
    }

    @Test
    public void should_be_added_by_2_when_is_Aged_Brie_and_quality_less_than_50_and_sellin_less_than_zero() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(7));
        assertThat(app.items[0].sellIn, is(-1));
    }

    @Test
    public void should_be_added_by_3_when_is_Backstage_and_quality_less_than_50_and_sellin_less_than_6() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(8));
        assertThat(app.items[0].sellIn, is(0));
    }

    @Test
    public void should_be_added_by_2_when_is_Backstage_and_quality_less_than_50_and_sellin_less_than_11() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 7, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(7));
        assertThat(app.items[0].sellIn, is(6));
    }

    @Test
    public void should_be_added_by_1_when_is_Backstage_and_quality_less_than_50_and_sellin_not_less_than_11() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(6));
        assertThat(app.items[0].sellIn, is(11));
    }

    @Test
    public void should_be_0_when_is_Backstage_and_sellin_less_than_zero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(0));
        assertThat(app.items[0].sellIn, is(-1));
    }

    @Test
    public void should_not_be_changed_when_is_Sulfuras_and_sellin_not_less_than_zero() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(5));
        assertThat(app.items[0].sellIn, is(0));
    }

    @Test
    public void should_not_be_changed_when_is_Sulfuras_and_sellin_less_than_zero() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateItem();
        assertThat(app.items[0].quality, is(5));
        assertThat(app.items[0].sellIn, is(-1));
    }
}
