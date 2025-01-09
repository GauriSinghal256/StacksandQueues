import java.util.Stack;

public class queueUsingStack2 {
        static class queue{
            static Stack<Integer> s1 = new Stack<>();
            static Stack<Integer> s2 = new Stack<>();
        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        // add
        public static void add(int data){
            s1.push(data);
        }
        // remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int front = s2.pop();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return front;
        }
        // peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int front = s2.peek();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return front;
        }
    }
        @SuppressWarnings("static-access")
    public static void main(String[] args) {
        queue q = new queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
    
