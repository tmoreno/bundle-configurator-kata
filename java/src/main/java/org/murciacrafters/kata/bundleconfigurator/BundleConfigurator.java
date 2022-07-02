package org.murciacrafters.kata.bundleconfigurator;

import java.util.ArrayList;
import java.util.List;

public final class BundleConfigurator {

    public String calculateBestBuy(List<Product> products) {
        List<String> result = new ArrayList<>();

        for (Product product : products) {
            switch (product) {
                case P1 -> addP1(result);
                case P2 -> addP2(result);
                case P3 -> addP3(result);
                case P4 -> addP4(result);
                case P5 -> addP5(result);
            }
        }

        return String.join(",", result);
    }

    private void addP1(List<String> result) {
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

    private void addP2(List<String> result) {
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
        else if (result.contains("B2") && result.contains("P3")) {
            result.remove("P3");
            result.remove("P2");
            result.remove("B2");
            result.add("B4");
        }
        else if (result.contains("P1")) {
            result.remove("P1");
            result.remove("P2");
            result.add("B1");
        }
    }

    private void addP3(List<String> result) {
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

    private void addP4(List<String> result) {
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

    private void addP5(List<String> result) {
        result.add("P5");

        if (result.contains("P1")) {
            result.remove("P1");
            result.remove("P5");
            result.add("B5");
        }
    }
}
