class Solution {
    int[] isPossible;
    List<List<String>> recipeIngredients;
    List<String> suppliesList;
    HashMap<String, Integer> recipeIdxMap;

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        recipeIdxMap = new HashMap<>();
        int n = recipes.length;
        suppliesList = Arrays.asList(supplies);
        isPossible = new int[n]; // 0 - not process, 1 - isPossible, 2 - Not Possible, 3 - In Process (Cycle detection)
        recipeIngredients = ingredients;

        for(int i=0; i<n; i++) {
            recipeIdxMap.put(recipes[i], i);
        }

        for(int i=0; i<n; i++) {
            if(isPossible[i] == 0) {
                checkIfRecipePossible(i);
            }
        }

        List<String> allPossibleRecipes = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(isPossible[i] == 1) {
                allPossibleRecipes.add(recipes[i]);
            }
        }

        return allPossibleRecipes;
    }

    int checkIfRecipePossible(int recipeIdx) {
        if(isPossible[recipeIdx] != 0) {
            return isPossible[recipeIdx];
        }

        isPossible[recipeIdx] = 3;

        for(String ing: recipeIngredients.get(recipeIdx)) {
            if(recipeIdxMap.containsKey(ing)) {
                if(checkIfRecipePossible(recipeIdxMap.get(ing)) != 1) {
                    isPossible[recipeIdx] = 2;
                    return 2;
                }
            } else if(!suppliesList.contains(ing)) {
                isPossible[recipeIdx] = 2;
                return 2; 
            }
        }

        isPossible[recipeIdx] = 1;
        return 1;
    }
}