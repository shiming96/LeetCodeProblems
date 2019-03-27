class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果叶子节点只有一个为null
        if((p==null && q != null) || (p != null && q == null)) {
            return false;
        }
        //如果叶子节点都为null
        if(p == null && q == null)
            return true;
        
        if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}