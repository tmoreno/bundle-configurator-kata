package org.murciacrafters.kata.bundleconfigurator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BundleConfiguratorTest {

    @Test
    void should_empty_when_buy_nothing() {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<Product> products = List.of();
        String bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).isEqualTo("");
    }

    @Test
    void should_P1_when_buy_P1() {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<Product> products = List.of(Product.P1);
        String bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).isEqualTo("P1");
    }

    @Test
    void should_P2_when_buy_P2() {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<Product> products = List.of(Product.P2);
        String bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).isEqualTo("P2");
    }
}
