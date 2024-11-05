// 24. Swap Nodes in pairs

class ListNode {
    int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, curr = head;

        while (curr != null && curr.next != null) {
            ListNode npn = curr.next.next;
            ListNode second = curr.next;

            second.next = curr;
            curr.next = npn;
            prev.next = second;

            prev = curr;
            curr = npn;

        }
        return dummy.next;
    }
}
