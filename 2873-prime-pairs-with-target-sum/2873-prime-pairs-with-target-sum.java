class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isPrime = sieveOfEratosthenes(n);

        for(int i=1; i<=n/2; i++) {
            if(isPrime[i] && isPrime[n-i]) {
                ans.add(List.of(new Integer[]{i, n-i}));
            }    
        }
        
        return ans;
    }

    boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        return isPrime;
    }
}