public class DeleteMiddle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // slow moves 1 step, fast moves 2 steps. when fast reaches the end,
    // slow is on the middle node. we keep 'prev' so we can unlink it.
    public ListNode deleteMiddle(ListNode head) {
        // only one node -> deleting the middle leaves an empty list
        if (head == null || head.next == null) {
            return null;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;
        return head;
    }

    // helper methods just for testing
    static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int x : arr) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummy.next;
    }

    static void print(ListNode head) {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeleteMiddle obj = new DeleteMiddle();

        print(obj.deleteMiddle(build(new int[] { 1, 3, 4, 7, 1, 2, 6 }))); // 1 -> 3 -> 4 -> 1 -> 2 -> 6
        print(obj.deleteMiddle(build(new int[] { 1, 2, 3, 4 })));          // 1 -> 2 -> 4
        print(obj.deleteMiddle(build(new int[] { 2, 1 })));                // 2
        print(obj.deleteMiddle(build(new int[] { 5 })));                   // (empty)
    }
}
