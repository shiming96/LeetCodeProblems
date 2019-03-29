class Solution {
    
    //--------------------------------------------------
    // 中序遍历
    //--------------------------------------------------
    public boolean isValidBST(TreeNode root) {
       ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        
        for(int i = 1; i < list.size(); i++) {
            if(list.get(i-1) >= list.get(i))
                return false;
        }
        return true;
        
    }
    private void inOrder(TreeNode root, ArrayList list) {
        if(root == null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }


    //--------------------------------------------------
    // 优化中序遍历     记录前继节点值
    //--------------------------------------------------

    //用例会卡int的最小值边界，所以用long
    long last = Long.MIN_VALUE;
    
    public boolean isValidBST1(TreeNode root) {
        
        boolean ans = true;
        
        if(root == null)
            return true;
        
        ans = ans && isValidBST(root.left);
        if(last < root.val)
            last = root.val;
        else
            return false;
        ans = ans && isValidBST(root.right);
        return ans;
      
    }

    
}