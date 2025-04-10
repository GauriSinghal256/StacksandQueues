public class QueueUsingArray {
    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        Queue(int n){
            arr = new int[n];
            size = n; //the length of the array
            rear = -1;
        }
        // to check whether the queue is empty or not
        public static boolean isEmpty(){
            return rear == -1;
        }

        // add an element to queue
        public static void add(int data){
            if(rear == size-1){
                System.out.println("Queue is full");
                return;
            }
            rear = rear +1;
            arr[rear] = data;
        }

        // remove an element from queue
        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            for(int i=0 ; i<rear ; i++){
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
        }

        // peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            return front;
        }
    }
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        Queue q = new Queue(6);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
