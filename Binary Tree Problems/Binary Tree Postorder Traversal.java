/**

Problem : Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return list;
        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        
        return list;
    }
}

