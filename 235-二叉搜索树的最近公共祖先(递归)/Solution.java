class Solution {
    
    //--------------------------------------------------
    // 利用二叉搜索树的性质进行递归
    // 非常容易理解
    //--------------------------------------------------
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        
        if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        
        return root;
    }
    
    
    
    
    
    
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        
        root.left = lowestCommonAncestor(root.left, p, q);
        root.right = lowestCommonAncestor(root.right, p, q);
        
        if(root.left == null)
            return root.right;
        if(root.right == null)
            return root.left;
        return root;
        
    }


}