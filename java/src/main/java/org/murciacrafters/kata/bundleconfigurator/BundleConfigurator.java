package org.murciacrafters.kata.bundleconfigurator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class BundleConfigurator {

    public List<String> calculateBestBuy(List<Product> products) {

        int product1Count = 0;
        int product2Count = 0;
        int product3Count = 0;
        int product4Count = 0;
        int product5Count = 0;

        for (Product product : products) {
            switch (product) {
                case P1 -> product1Count++;
                case P2 -> product2Count++;
                case P3 -> product3Count++;
                case P4 -> product4Count++;
                case P5 -> product5Count++;
            }
        }

        int bundle1Count = Math.min(product1Count, product2Count);
        int bundle2Count = Math.min(product1Count, product4Count);
        int bundle3Count = Math.min(product3Count, product4Count);
        int bundle4Count = Math.min(product1Count, Math.min(product2Count, Math.min(product3Count, product4Count)));
        int bundle5Count = Math.min(product1Count, product5Count);

        product1Count -= bundle1Count + bundle2Count + bundle4Count + bundle5Count;
        product2Count -= bundle1Count + bundle4Count;
        product3Count -= bundle3Count + bundle4Count;
        product4Count -= bundle2Count + bundle3Count + bundle4Count;
        product5Count -= bundle5Count;

        bundle1Count -= bundle4Count;
        bundle2Count -= bundle4Count;
        bundle3Count -= bundle4Count;

        List<String> result = new ArrayList<>();
        IntStream.range(0, product1Count).forEach(x -> result.add("P1"));
        IntStream.range(0, product2Count).forEach(x -> result.add("P2"));
        IntStream.range(0, product3Count).forEach(x -> result.add("P3"));
        IntStream.range(0, product4Count).forEach(x -> result.add("P4"));
        IntStream.range(0, product5Count).forEach(x -> result.add("P5"));

        IntStream.range(0, bundle1Count).forEach(x -> result.add("B1"));
        IntStream.range(0, bundle2Count).forEach(x -> result.add("B2"));
        IntStream.range(0, bundle3Count).forEach(x -> result.add("B3"));
        IntStream.range(0, bundle4Count).forEach(x -> result.add("B4"));
        IntStream.range(0, bundle5Count).forEach(x -> result.add("B5"));

        return result;
    }
}
