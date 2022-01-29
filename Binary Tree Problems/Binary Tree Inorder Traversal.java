/**

Problem : Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

**/

// Solution : 

class Solution {
    List list = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
        
        return list;
    }
}
