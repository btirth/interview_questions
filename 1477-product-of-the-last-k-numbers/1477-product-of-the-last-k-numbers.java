class ProductOfNumbers {
    int[] prefixProduct;
    int lastZeroIdx;
    int idx;

    public ProductOfNumbers() {
        prefixProduct = new int[40002];
        lastZeroIdx = -1;
        idx = 0;
    }
    
    public void add(int num) {
        if(num == 0) {
            lastZeroIdx = idx;
        }
        if(idx == 0 || prefixProduct[idx-1] == 0) {
            prefixProduct[idx] = num;
        } else {
            prefixProduct[idx] = prefixProduct[idx-1]*num;
        }

        idx++;
    }
    
    public int getProduct(int k) {
        if(lastZeroIdx != -1 && idx - lastZeroIdx <= k) {
            return 0;
        }

        if(idx == k || prefixProduct[idx-k-1] == 0) {
            return prefixProduct[idx-1];
        }

        return prefixProduct[idx-1] / prefixProduct[idx-k-1];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */