import java.util.ArrayList;
import java.util.List;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();

        ListNode current = this;
        while(current != null) {
            list.add(current.val);
            current = current.next;
        }

        return list.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ListNode)) {
            return false;
        }

        return this.toString().equals(obj.toString());
    }
}
