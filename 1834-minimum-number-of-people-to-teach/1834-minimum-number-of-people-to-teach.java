class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        /**
        We have friendships and langugages

        If I teach L1 to a user he can communicate with all of their friends who knows L1.

        I can only select 1 Language. but all users needs to talk with each other.

        First identify list of friendships who can't communicate without new language.
         */
        int users = languages.length;
        int minUsers = Integer.MAX_VALUE;
        List<Integer>[] knownLangs = new ArrayList[users + 1];

        for(int i=1; i<=users; i++) {
            List<Integer> knownLang = new ArrayList<>();

            for(int lang: languages[i-1]) {
                knownLang.add(lang);
            }

            knownLangs[i] = knownLang;
        }

        List<int[]> cantCommunicateFrnds = new ArrayList<>();
        for(int[] frnds: friendships) {
            int frnd1 = frnds[0];
            int frnd2 = frnds[1];
            boolean communicate = false;

            for(int lang: knownLangs[frnd1]) {
                if(knownLangs[frnd2].contains(lang)) {
                    communicate = true;
                    break;
                }
            }

            if(!communicate) {
                cantCommunicateFrnds.add(new int[]{frnd1, frnd2});
            }
        }

        for(int i=1; i<=n; i++) {
            int usersToTeach = helper(i, knownLangs, cantCommunicateFrnds);
            minUsers = Math.min(minUsers, usersToTeach);
        }

        return minUsers;
    }

    int helper(int lang, List<Integer>[] languages, List<int[]> friendships) {
        int count = 0;
        Set<Integer> tought = new HashSet<>();

        for(int[] frnds: friendships) {
            int frnd1 = frnds[0];
            int frnd2 = frnds[1];

            if(!languages[frnd1].contains(lang) && !tought.contains(frnd1)) {
                tought.add(frnd1);
            }

            if(!languages[frnd2].contains(lang) && !tought.contains(frnd2)) {
                tought.add(frnd2);
            }
        }

        return tought.size();
    }
}