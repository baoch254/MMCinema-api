package com.mm_cinema.customer.utils;

import java.util.concurrent.ThreadLocalRandom;

public class BarcodeUtil {
    private static final int BARCODE_LENGTH = 12;

    public static String generateNumericBarcode() {
        // Get timestamp (last 8 digits)
        long timestamp = System.currentTimeMillis() % 100000000;

        // Generate random 4 digits
        int randomDigits = ThreadLocalRandom.current().nextInt(10000); // 0-9999

        // Combine and format to fixed length
        return String.format("%08d%04d", timestamp, randomDigits)
                .substring(0, BARCODE_LENGTH);
    }

    public static boolean isValidBarcodeFormat(String barcode) {
        // Check if it's numeric only and correct length
        return barcode != null && barcode.matches("\\d{" + BARCODE_LENGTH + "}");
    }
}
