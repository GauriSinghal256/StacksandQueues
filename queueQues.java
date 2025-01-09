import java.util.*;

public class queueQues {
    // first non repeating letters in the stream 
    public static void printNonRepeating(String str){
        int freq[] =new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            
        }
    }
    // interleaving 2 halves of a queue
    public static void interleave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        for(int i=0 ; i<size/2 ; i++){
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    // queue reversal
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        // interleave(q);
        // reverse(q);
        // while(!q.isEmpty()){
        //     System.out.print(q.remove()+" ");
        // }

        // deque using java collection faramework
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.add(2);
        deque.addLast(3);
        System.out.println(deque);
        deque.removeFirst();
        deque.removeLast();
        System.out.println(deque);
        
    }
    
}
