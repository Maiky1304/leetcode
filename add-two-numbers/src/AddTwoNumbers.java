import java.math.BigInteger;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers testCase = new AddTwoNumbers();

        ListNode l1 = testCase.createListNode(2,4,9);
        ListNode l2 = testCase.createListNode(5,6,4,9);

        System.out.printf("Input: l1 = %s, l2 = %s%n", l1, l2);

        ListNode output = testCase.run(l1, l2);
        System.out.println("Output: " + output.toString());

        ListNode expect = testCase.createListNode(7,0,4,0,1);
        System.out.printf("Success: %b", output.equals(expect));
    }

    public ListNode createListNode(int... nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1; i < nums.length; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        return head;
    }

    public ListNode run(ListNode l1, ListNode l2) {
        BigInteger l1i = new BigInteger(listNodeAndChildrenJoined(l1));
        BigInteger l2i = new BigInteger(listNodeAndChildrenJoined(l2));

        BigInteger sum = l2i.add(l1i);
        String lsumStr = sum.toString();

        return createReversedListNode(lsumStr);
    }

    public ListNode createReversedListNode(String lsumStr) {
        ListNode head = new ListNode(Integer.parseInt( lsumStr.substring(lsumStr.length() - 1)));
        ListNode current = head;

        for (int i = lsumStr.length()-2; i >= 0; i--) {
            int j = Integer.parseInt(String.valueOf(lsumStr.charAt(i)));
            current.next = new ListNode(j);
            current = current.next;
        }

        return head;
    }

    public String listNodeAndChildrenJoined(ListNode listNode) {
        StringBuilder output = new StringBuilder();

        while (listNode != null) {
            output.append(listNode.val);
            listNode = listNode.next;
        }

        return output.reverse().toString();
    }

}
