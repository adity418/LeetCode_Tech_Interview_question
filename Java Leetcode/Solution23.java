// 23. Merge k Sorted Lists

import java.util.ArrayList;
import java.util.List;

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

public class Solution23 {
    public ListNode mergeKList(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        while (lists.length > 1) {
            List<ListNode> temp = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null;
                temp.add(mergeLists(l1, l2));
            }
            lists = temp.toArray(new ListNode[0]);
        }
        return lists[0];
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode();
        ListNode ans = node;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        node.next = l1 != null ? l1 : l2;
        return ans.next;
    }

}

// /**
// * Definition for singly-linked list.
// * public class ListNode {
// * int val;
// * ListNode next;
// * ListNode() {}
// * ListNode(int val) { this.val = val; }
// * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// * }
// */
// class Solution {
// public ListNode mergeKLists(ListNode[] lists) {
// int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
// for (ListNode list : lists) {
// while (list != null) {
// int val = list.val;
// if (val > max) {
// max = val;
// }
// if (val < min) {
// min = val;
// }
// list = list.next;
// }
// }
// ListNode[] table = new ListNode[max - min + 1];
// for (int i = lists.length - 1; i >= 0; i--) {
// ListNode node = lists[i], temp;
// while (node != null) {
// temp = node.next;
// node.next = table[node.val - min];
// table[node.val - min] = node;
// node = temp;
// }
// }
// ListNode result = new ListNode();
// ListNode pointer = result;
// for (ListNode node : table) {
// if (node != null) {
// pointer.next = node;
// pointer = pointer.next;
// while (node.next != null) node = node.next;
// pointer = node;
// }
// }
// return result.next;
// }
// }