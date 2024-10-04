class Solution {
    public long dividePlayers(int[] skill) {
        int players = skill.length;
        if(players%2 != 0) {
            return -1;
        }

        int teams = players/2;
        long totalSkill = 0;
        for(int playerSkill: skill) {
            totalSkill += (long)playerSkill;
        }

        if(totalSkill % teams != 0) {
            return -1;
        }

        long chemistry = 0;
        Arrays.sort(skill);
        int left = 0;
        int right = players - 1;
        long equalSkill = totalSkill/teams;

        while(left < right) {
            if(skill[left] + skill[right] != equalSkill) {
                return -1;
            }

            chemistry += (long)(skill[left] * skill[right]);
            left++;
            right--;
        }

        return chemistry;
    }
}