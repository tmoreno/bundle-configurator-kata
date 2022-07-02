package org.murciacrafters.kata.bundleconfigurator;

import java.util.ArrayList;
import java.util.List;

public final class BundleConfigurator {

    public String calculateBestBuy(List<Product> products) {
        if (products.isEmpty()) {
            return "";
        }

        if (products.size() == 1) {
            return products.get(0).name();
        }

        List<String> result = new ArrayList<>();

        for (Product product : products) {
            switch (product) {
                case P1 -> {
                    result.add("P1");

                    if (result.contains("P2")) {
                        result.remove("P1");
                        result.remove("P2");
                        result.add("B1");
                    }
                    else if (result.contains("P4")) {
                        result.remove("P1");
                        result.remove("P4");
                        result.add("B2");
                    }
                }

                case P2 -> {
                    result.add("P2");

                    if (result.contains("P1")) {
                        result.remove("P1");
                        result.remove("P2");
                        result.add("B1");
                    }
                }

                case P3 -> {
                    result.add("P3");
                }

                case P4 -> {
                    result.add("P4");

                    if (result.contains("P1")) {
                        result.remove("P1");
                        result.remove("P4");
                        result.add("B2");
                    }
                }

                case P5 -> {
                    result.add("P5");
                }
            }
        }

        return String.join(",", result);
    }
}
