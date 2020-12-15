package easy._0543;

import Structure.TreeNode;

/**
 * Created by fzy at 22:42 on 2020/12/6.
 */
public class Solution {
    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res - 1;
    }
    int depth(TreeNode root) {
        if (root == null)
            return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        res = Math.max(res,L+R+1);
        return Math.max(L,R)+1;
    }
}
