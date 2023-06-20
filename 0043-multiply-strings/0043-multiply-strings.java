class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] prod = new int[m + n];
        
        for (int i = m - 1; i >= 0; --i) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; --j) {
                int b = num2.charAt(j) - '0';
                prod[i + j + 1] += a * b;
                prod[i + j] += prod[i + j + 1] / 10;
                prod[i + j + 1] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prod.length; ++i) {
            if (sb.length() == 0 && prod[i] == 0) {
                continue;
            }
            sb.append(prod[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}