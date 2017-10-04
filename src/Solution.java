import java.util.*;

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

        String data = "{3,9,20,#,#,15,7}";

        String [] tree = data.substring(1,data.length()-1).split(",");
        //Queue<String> treeQ = new LinkedList<>(Arrays.asList(tree));
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
        queue.add(root);
        TreeNode node = root;

        for(int i = 1 ; i < tree.length ; i++) {

            if( i % 2 == 1 ){
                node = queue.poll();
                if(!tree[i].equals("#")){
                    node.left = new TreeNode(Integer.parseInt(tree[i]));
                    queue.offer(node.left);
                }
            }else{
                if(!tree[i].equals("#")){
                    node.right = new TreeNode(Integer.parseInt(tree[i]));
                    queue.offer(node.right);
                }
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