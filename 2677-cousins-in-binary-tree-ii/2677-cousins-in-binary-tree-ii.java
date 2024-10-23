class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<Integer> l=new ArrayList<>();
        l.add(root.val);
        while(!q.isEmpty()){
            int size=q.size();
            int sum1=0;
            while(size-->0){
                TreeNode curr=q.poll();
                if(curr.left!=null){
                    sum1+=curr.left.val;
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    sum1+=curr.right.val;
                    q.add(curr.right);
                }
            }
            l.add(sum1);
            
        }
       
        q.clear();
        q.add(root);
        int lvl=-1;
        while(!q.isEmpty()){
            lvl++;
            int size=q.size();
            
            while(size-->0){
                int sum1=0;
                TreeNode curr=q.poll();
                if(lvl==0 || lvl==1){
                    curr.val=0;
                }
                if(curr.left!=null){
                    sum1+=curr.left.val;
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    sum1+=curr.right.val;
                    q.add(curr.right);
                }
               
                if(lvl>=1){
                  //   System.out.print(lvl+" ");
                     if(curr.left!=null){
                          
                        curr.left.val=l.get(lvl+1)-sum1;
                     }
                    if(curr.right!=null){
                        curr.right.val=l.get(lvl+1)-sum1;
                     }
                }
            }
            
            
        }
        return root;
    }
}