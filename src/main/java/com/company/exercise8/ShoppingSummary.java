package com.company.exercise8;

class ShoppingSummary {
    private int totalItems = 0;
    private double totalPrice = 0.0;

    public void addItem(Item item) {
        totalItems++;
        totalPrice += item.getPrice();
    }

    public void combine(ShoppingSummary other) {
        totalItems += other.totalItems;
        totalPrice += other.totalPrice;
    }

    public double getAveragePrice() {
        return totalItems == 0 ? 0 : totalPrice / totalItems;
    }

    @Override
    public String toString() {
        return String.format(
                "Items: %d, Total: $%.2f, Average(2f): $%.2f",
                totalItems,
                totalPrice,
                getAveragePrice()
        );
    }

}
