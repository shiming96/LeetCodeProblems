class Solution {

    //-------------------------------------------------
    //  BFS     广度优先遍历
    //-------------------------------------------------
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        int min = 1;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i = 0; i < len; i++) {
                TreeNode node = q.remove();
                if(node.left == null && node.right == null)
                    return min;
                else {
                    if(node.left != null)
                        q.add(node.left);
                    if(node.right != null)
                        q.add(node.right);
                }
            }
            ++min;
        }
        return min;
    }

    //-------------------------------------------------
    //  DFS     深度优先遍历
    //-------------------------------------------------
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(left == 0 || right == 0)
            return left + right + 1;
        return Math.min(left, right) + 1;
    }

}