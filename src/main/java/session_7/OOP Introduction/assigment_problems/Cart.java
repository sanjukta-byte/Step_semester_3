class Cart {
    private double[] prices;
    private final String cartId;

    Cart(String cartId, int capacity) {
        this.cartId = cartId;
        prices = new double[capacity];
    }

    void addItem(double price) {
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] == 0) {
                if (price > 0) {
                    prices[i] = price;
                } else {
                    System.out.println("Invalid price");
                }
                return;
            }
        }

        System.out.println("Cart is full");
    }

    double getTotal() {
        double total = 0;

        for (double price : prices) {
            total += price;
        }

        return total;
    }

    int getItemCount() {
        int count = 0;

        for (double price : prices) {
            if (price > 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}