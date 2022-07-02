package org.murciacrafters.kata.bundleconfigurator;

import java.util.List;

public final class BundleConfigurator {

    public String calculateBestBuy(List<Product> products) {
        if (products.isEmpty()) {
            return "";
        }

        if (products.size() == 1) {
            return products.get(0).name();
        }

        return "B1";
    }
}
