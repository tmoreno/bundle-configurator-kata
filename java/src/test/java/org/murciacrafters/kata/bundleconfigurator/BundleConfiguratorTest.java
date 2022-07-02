package org.murciacrafters.kata.bundleconfigurator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

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

    @ParameterizedTest
    @EnumSource(Product.class)
    void given_a_buy_with_only_one_single_product_then_best_buy_config_is_that_product(Product product) {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<Product> products = List.of(product);
        String bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).isEqualTo(product.name());
    }

    @Test
    void should_return_B1_when_buy_P1_and_P2_products() {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<Product> products = List.of(Product.P1, Product.P2);
        String bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).isEqualTo("B1");
    }

    @Test
    void should_return_B2_when_buy_P1_and_P4_products() {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<Product> products = List.of(Product.P1, Product.P4);
        String bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).isEqualTo("B2");
    }

    @Test
    void order_is_irrelevant() {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<Product> products = List.of(Product.P2, Product.P1);
        String bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).isEqualTo("B1");
    }
}
