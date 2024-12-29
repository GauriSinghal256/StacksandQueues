import java.util.ArrayList;

public class stackUsingArrayList {

    static class stack{
        static ArrayList<Integer> list = new ArrayList<>();

        // function to check whether the stack is empty or not
        public static boolean isEmpty(){
            return list.size()==0;
        }

        // push
        public void push(int data){
                    list.add(data);
                }
        
        // pop
        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
                }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        
        // peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
        
    @SuppressWarnings("static-access")
            public static void main(String[] args) {
                stack s =new stack();
                s.push(1);
                s.push(2);
        s.push(3);
        s.push(4);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
