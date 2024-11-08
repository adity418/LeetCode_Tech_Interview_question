# 19. Remove Nth node from end of the List

class ListNode:
    def __init__(self, val=0, next=None):
        self.val= val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head, n):
        res = ListNode(0, head)
        dummy = res

        for _ in range(n):
            head = head.next

        while head:
            head = head.next
            dummy = dummy.next

        dummy.next = dummy.next.next

        return res.next
