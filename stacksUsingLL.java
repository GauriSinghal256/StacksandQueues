public class stacksUsingLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Stack{
        static Node head = null;

        // function to check that stack is empty or not
        public boolean isEmpty(){
            return head==null;
        }

        // push 
        public void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // pop
        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Stack s =new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while(!s.isEmpty()){
        System.out.println(s.peek());
        s.pop();
        }
        System.out.println(s.peek());
    }
}
