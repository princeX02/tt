public class ConvertArrayDLL {
    public static class Node {
        int data;
        Node next;
        Node back;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.back = null;
        }
    }

    public static Node convertArrayToDLL(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            newNode.back = temp;
            temp = newNode;
        }

        return head;
    }

    public static void printDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.print("NULL\n");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Node head = convertArrayToDLL(arr);
        printDLL(head);
    }
}
