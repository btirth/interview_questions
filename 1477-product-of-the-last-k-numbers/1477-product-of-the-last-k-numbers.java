class ProductOfNumbers {

    int[] products;

    int idx = -1;
    int lastZero = -1;

    public ProductOfNumbers() {
        products = new int[40001];
        Arrays.fill(products, 1);
    }
    
    public void add(int num) {
        idx++;

        if(num == 0) {
            lastZero = idx;
            return;
        }

        if(idx == 0) {
            products[idx] = num;
        } else {
            products[idx] = (products[idx - 1] == 0 ? 1 : products[idx - 1]) * num;
        }
    }
    
    public int getProduct(int k) {
        if(idx - k < lastZero) {
            return 0;
        }

        if(k > idx) {
            return products[idx];
        }

        return products[idx] / products[idx - k];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */