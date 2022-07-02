package org.murciacrafters.kata.bundleconfigurator;

import java.util.List;

public final class BundleConfigurator {

    public String calculateBestBuy(List<Product> products) {
        return products.get(0).name();
    }
}
