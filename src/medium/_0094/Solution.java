package medium._0094;

import Structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzy at 0:15 on 2020/12/6.
 */
public class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}
