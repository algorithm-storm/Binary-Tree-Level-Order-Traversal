import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {


    public static void main(String[] args){

        String [] tree = {"3","9","20","#","#","15","7"};
        Queue<Integer> treeQ = new LinkedList<>();

        for(int i = 0 ; i < tree.length ; i++){
            if(tree[i] == "#"){
                treeQ.add(Integer.MAX_VALUE);
            }
            else{
                treeQ.add(Integer.parseInt(tree[i]));
            }
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(treeQ.poll());
        queue.add(root);

        while(!treeQ.isEmpty()){
            TreeNode node = queue.poll();

            int value = treeQ.poll();
            if(value == Integer.MAX_VALUE){
                node.left = null;
            }
            else{
                TreeNode left = new TreeNode(value);
                queue.add(left);
                node.left = left;
            }

            if(treeQ.isEmpty()){
                break;
            }

            value = treeQ.poll();
            if(value == Integer.MAX_VALUE){
                node.right = null;
            }
            else{
                TreeNode right = new TreeNode(value);
                queue.add(right);
                node.right = right;
            }
        }

        Solution a = new Solution();
        System.out.println(a.levelOrder(root));

    }


    /*
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size ; i++){
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(node.left!= null) {
                    queue.offer(node.left);
                }
                if(node.right!= null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }
}