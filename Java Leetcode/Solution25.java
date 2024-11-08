// 25. Reverse Nodes in k-Group

class ListNode{
    int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}
}

class Solution25{
    public ListNode reverseKGroup(ListNode head, int k){
        if(head == null || k == 1){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;

        while(ptr != null){
            ListNode track = ptr;

            for(int i = 0; i < k && track != null; i++){
                track = track.next;
            }
            if(track == null){
                break;
            }
            ListNode[] updateNode = reverseLinkedList(ptr.next, k);

            ListNode prev = updateNode[0];
            ListNode curr = updateNode[1];

            ListNode lastNodeRevGrp =ptr.next;
            lastNodeRevGrp.next = curr;
            ptr.next = prev;
            ptr = lastNodeRevGrp;
        }
        return dummy.next;

    }
    private ListNode[] reverseLinkedList(ListNode head, int k){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next_node;

        for(int i = 0; i < k; i++){
            next_node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_node;
        }
        return new ListNode[] {prev, curr};
    }
}