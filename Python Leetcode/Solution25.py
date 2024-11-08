# 25. Reverse Nodes in k-Group

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseKGroup(self, head, k):
        if head is None or k == 1:
            return head

        dummy = ListNode(0)
        dummy.next = head
        ptr = dummy

        while ptr is not None:
            track = ptr

            for i in range(k):
                track = track.next
                if track is None:
                    return dummy.next

            prev, curr = self.reverseLinkedList(ptr.next, k)

            lastNodeRevGrp = ptr.next
            lastNodeRevGrp.next = curr
            ptr.next = prev
            ptr = lastNodeRevGrp

        return dummy.next

    def reverseLinkedList(self, head, k):
        prev = None
        curr = head

        for _ in range(k):
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node

        return prev, curr

