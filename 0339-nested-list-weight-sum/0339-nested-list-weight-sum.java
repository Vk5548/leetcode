/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */


 /* 
 Q: Nested List, o/p multiplication of number to its depth and add with rest of the result
 Cq: Max -depth? 
 `~ max length of the nested list?
 `Nested Integer is an interface
 `or can the list contain empty sublists
 Are there any null-elements or invalid structures



 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }
    private int dfs(List<NestedInteger> nestedList, int depth){
        int total = 0;
        for(NestedInteger nested: nestedList){
            if(nested.isInteger()){
                total += depth * nested.getInteger();
            }else{
                total += dfs(nested.getList(), depth + 1);
            }
        }
        return total;



    }
}