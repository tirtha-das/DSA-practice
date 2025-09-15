// User function Template for Java

class Solution {
    
    Node merge(Node head1 , Node head2){
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        Node list1 = head1;
        Node list2 = head2;
        while(list1 != null && list2!=null){
            if(list1.data <= list2.data){
                res.bottom = list1;
                res = list1;
                list1 = list1.bottom;
            }else{
                
                res.bottom = list2;
                res = list2;
                list2 = list2.bottom;
            
            }
            
            res.next = null;
        }
        
        if(list1 != null) {
            res.bottom = list1;
        }
        if(list2 != null) {
            res.bottom= list2;
        }
        
        return dummyNode.bottom;
    }
    
    Node flatten(Node root) {
        if(root == null || root.next==null) return root;
        
        Node mergeHead = flatten(root.next);
        root = merge(root,mergeHead);
        return root;
    }
}
