class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = version1.length();
        int n2 = version2.length();
        int i = 0;
        int j = 0;

        while(i<n1 || j<n2) {
            int v1 = 0;
            int v2 = 0;

            if(i<n1) {
                int start1 = i;
                while(i<n1 && version1.charAt(i) != '.') {
                    i++;
                }

                System.out.println(start1+" "+i);
                v1 = Integer.parseInt(version1.substring(start1, i));
                i++;
            }

            if(j<n2) {
                int start2 = j;
                while(j<n2 && version2.charAt(j) != '.') {
                    j++;
                }

                v2 = Integer.parseInt(version2.substring(start2, j));
                j++;
            }

            if(v1 > v2) {
                return 1;
            } else if(v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
}