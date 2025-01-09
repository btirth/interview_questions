class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int left = 0;
        int right = skill.length - 1;
        long chemistry = 0;
        int reqSkills = skill[left] + skill[right];
        while(left < right) {
            if(skill[left] + skill[right] != reqSkills) {
                return -1;
            }

            chemistry += (skill[left] * skill[right]);
            left++;
            right--;
        }

        return chemistry;
    }
}