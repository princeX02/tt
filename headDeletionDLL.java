public class headDeletionDLL {
    public static class Node {
        int data;
        Node next;
        Node back;

        Node(int  data){
            this.data=data;
            this.next=null;
            this.back=null;
        }   
    }

    public static Node convertArrayToDLL(int arr[]){
        if(arr.length==0) return null;

        Node head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            Node newNode=new Node(arr[i]);
            temp.next=newNode;
            newNode.back=temp;
            temp=newNode;
        }
        return head;
    }

    public static void printDLL(Node head){
        System.out.println();
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.print("NUll");
    }

    public static Node removedHead(Node head){
        if(head==null || head.next==null) return null;

        head=head.next;
        head.back=null;
        return head;
    }

    public static Node removedTail(Node head){
        if(head==null || head.next==null) return null;

        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node prev=temp.back;
        prev.next=null;
        temp.back=null;
        return head;
    }

    public static Node removedKthElements(Node head,int k){
        
        int count=0;
        Node temp=head;
        if(head==null)return null;
        while(temp!=null){
            count++;
            if(count==k)break;
            temp=temp.next;
        }

        Node prev=temp.back;
        Node font=temp.next;

        if(prev==null && font==null){
            return null;
        }else if(prev==null){
            return removedHead(head);
        }else if(font==null){
            return removedTail(head);
        }else{
            prev.next=font;
            font.back=prev;
            temp.next=null;
            temp.back=null;
            return head;
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        Node head=convertArrayToDLL(arr);
        printDLL(head);

        // head=removedHead(head);
        // printDLL(head);

        // head=removedTail(head);
        // printDLL(head);

        head=removedKthElements(head,3);
        printDLL(head);
    }
}
