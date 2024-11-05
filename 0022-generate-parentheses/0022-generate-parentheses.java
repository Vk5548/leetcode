class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrackGenerate(n, "", 0, 0, result);
        return result;
    }

    public void backtrackGenerate(int n, String currentCombination, int open, int close, List<String> result){
        if(currentCombination.length() == n * 2){
            result.add(currentCombination);
            return;
        }

        if(open < n)
            backtrackGenerate(n, currentCombination + "(" , open + 1, close, result);
        if(close < open)
            backtrackGenerate(n, currentCombination + ")", open, close + 1, result);
    }
}