package org.murciacrafters.kata.bundleconfigurator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BundleConfiguratorTest {

    private static Stream<Arguments> bundles() {
        return Stream.of(
            Arguments.of(List.of(Product.P1, Product.P2), "B1"),
            Arguments.of(List.of(Product.P1, Product.P4), "B2"),
            Arguments.of(List.of(Product.P3, Product.P4), "B3"),
            Arguments.of(List.of(Product.P1, Product.P2, Product.P3, Product.P4), "B4"),
            Arguments.of(List.of(Product.P1, Product.P5), "B5")
        );
    }

    private static Stream<Arguments> bundlesAnyOrder() {
        return Stream.of(
                Arguments.of(List.of(Product.P2, Product.P1), "B1"),
                Arguments.of(List.of(Product.P4, Product.P1), "B2"),
                Arguments.of(List.of(Product.P4, Product.P3), "B3"),
                Arguments.of(List.of(Product.P4, Product.P3, Product.P2, Product.P1), "B4"),
                Arguments.of(List.of(Product.P4, Product.P3, Product.P1, Product.P2), "B4"),
                Arguments.of(List.of(Product.P4, Product.P1, Product.P3, Product.P2), "B4"),
                Arguments.of(List.of(Product.P1, Product.P4, Product.P3, Product.P2), "B4"),
                Arguments.of(List.of(Product.P5, Product.P1), "B5")
        );
    }

    @Test
    void should_empty_when_buy_nothing() {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<Product> products = List.of();
        List<String> bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).isEmpty();
    }

    @ParameterizedTest
    @EnumSource(Product.class)
    void given_a_buy_with_only_one_single_product_then_best_buy_config_is_that_product(Product product) {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<Product> products = List.of(product);
        List<String> bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).containsExactly(product.name());
    }

    @ParameterizedTest
    @MethodSource("bundles")
    void should_return_bundle(List<Product> products, String bundle) {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<String> bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).containsExactlyInAnyOrder(bundle);
    }

    @ParameterizedTest
    @MethodSource("bundlesAnyOrder")
    void order_is_irrelevant(List<Product> products, String bundle) {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<String> bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).containsExactlyInAnyOrder(bundle);
    }

    @Test
    void should_return_B1_and_P3_when_buy_P1_and_P2_and_P3() {
        BundleConfigurator bundleConfigurator = new BundleConfigurator();

        List<Product> products = List.of(Product.P1, Product.P2, Product.P3);
        List<String> bestBuyConfig = bundleConfigurator.calculateBestBuy(products);

        assertThat(bestBuyConfig).containsExactlyInAnyOrder("B1", "P3");
    }
}
