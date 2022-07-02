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

                    if (result.contains("P2") && result.contains("P3") && result.contains("P4")) {
                        result.remove("P1");
                        result.remove("P2");
                        result.remove("P3");
                        result.remove("P4");
                        result.add("B4");
                    }
                    else if (result.contains("B3") && result.contains("P2")) {
                        result.remove("P1");
                        result.remove("P2");
                        result.remove("B3");
                        result.add("B4");
                    }
                    else if (result.contains("P2")) {
                        result.remove("P1");
                        result.remove("P2");
                        result.add("B1");
                    }
                    else if (result.contains("P4")) {
                        result.remove("P1");
                        result.remove("P4");
                        result.add("B2");
                    }
                    else if (result.contains("P5")) {
                        result.remove("P1");
                        result.remove("P5");
                        result.add("B5");
                    }
                }

                case P2 -> {
                    result.add("P2");

                    if (result.contains("P1") && result.contains("P3") && result.contains("P4")) {
                        result.remove("P1");
                        result.remove("P2");
                        result.remove("P3");
                        result.remove("P4");
                        result.add("B4");
                    }
                    else if (result.contains("B3") && result.contains("P1")) {
                        result.remove("P1");
                        result.remove("P2");
                        result.remove("B3");
                        result.add("B4");
                    }
                    else if (result.contains("P1")) {
                        result.remove("P1");
                        result.remove("P2");
                        result.add("B1");
                    }
                }

                case P3 -> {
                    result.add("P3");

                    if (result.contains("P1") && result.contains("P2") && result.contains("P4")) {
                        result.remove("P1");
                        result.remove("P2");
                        result.remove("P3");
                        result.remove("P4");
                        result.add("B4");
                    }
                    else if (result.contains("B1") && result.contains("P4")) {
                        result.remove("P3");
                        result.remove("P4");
                        result.remove("B1");
                        result.add("B4");
                    }
                    else if (result.contains("P4")) {
                        result.remove("P3");
                        result.remove("P4");
                        result.add("B3");
                    }
                }

                case P4 -> {
                    result.add("P4");

                    if (result.contains("P1") && result.contains("P2") && result.contains("P3")) {
                        result.remove("P1");
                        result.remove("P2");
                        result.remove("P3");
                        result.remove("P4");
                        result.add("B4");
                    }
                    else if (result.contains("B1") && result.contains("P3")) {
                        result.remove("P3");
                        result.remove("P4");
                        result.remove("B1");
                        result.add("B4");
                    }
                    else if (result.contains("P1")) {
                        result.remove("P1");
                        result.remove("P4");
                        result.add("B2");
                    } else if (result.contains("P3")) {
                        result.remove("P3");
                        result.remove("P4");
                        result.add("B3");
                    }
                }

                case P5 -> {
                    result.add("P5");

                    if (result.contains("P1")) {
                        result.remove("P1");
                        result.remove("P5");
                        result.add("B5");
                    }
                }
            }
        }

        return String.join(",", result);
    }
}
