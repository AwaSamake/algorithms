/**
 *
 * 2.5 Sum Lists
 *     You have two numbers represented by a linked list, where each node contains a
 *     single digit. The digits are stored in reverse order, such that the 1's digit is
 *     at the head of the list. Weite a function that adds the two numbers and returns
 *     the sum as a linked list.
 *     EXAMPLE
 *     Input: (7-> 1-> 6) + (5-> 9-> 2). That is, 617 + 295
 *     Output: 2-> 1-> 9. That is, 912
 *     FOLLOW UP
 *     Suppose the digits are stored in forward order. Repeat the above problem.
 *     Input: (6-> 1-> 7) + (2-> 9-> 5). That is, 617 + 295
 *     Output: 9-> 1-> 2. That is, 912
 *
 */
class SumLists {
    public static Node addLists(Node list1, Node list2) {
        Node result = null;
        int carry = 0, sum = 0, remainder;
        while (list1 != null && list2 != null) {
            sum = list1.data + list2.data + carry;
            list1 = list1.next;
            list2 = list2.next;
            carry = sum / 10;
            remainder = sum % 10;
            if (result == null) {
                result = new Node(remainder);
            } else {
                result.appendTail(result, remainder);
            }
        }
        if (list1 == null) {
            while (list2 != null) {
                sum = list2.data + carry;
                carry = 0;
                list2 = list2.next;
                remainder = sum % 10;
                if (result == null) {
                    result = new Node(remainder);
                } else {
                    result.appendTail(result, remainder);
                }
            }
        } else if (list2 == null) {
            while (list1 != null) {
                sum = list1.data + carry;
                carry = 0;
                list1 = list1.next;
                remainder = sum % 10;
                if (result == null) {
                    result = new Node(remainder);
                } else {
                    result.appendTail(result, remainder);
                }
            }
        }
        if (carry != 0) {
            result.appendTail(result, carry);
        }
        return result;
    }
    
    public static Node reverse(Node head) {
        if (head == null || head.next == null) { return head; }
        
        Node newHead = head;
        head = head.next;
        newHead.next = null;
        while (head != null) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            newHead = appendTail(temp, newHead);
        }
        return newHead;
    }
    
    public static Node appendTail(Node head, Node node) {
        if (head == null) {
            return node;
        }
        Node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = node;
        return head;
    }
    
	public static void main(String[] args) {
		Node list1 = new Node(7);
        list1.appendTail(list1, 1);
        list1.appendTail(list1, 6);
        
        Node list2 = new Node(5);
        list2.appendTail(list2, 9);
        list2.appendTail(list2, 3);
        
        list1.printList();
        list2.printList();
        
        Node result = addLists(list1, list2);
        result.printList();
        
        result = reverse(result);
        result.printList();
	}
}