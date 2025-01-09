import java.util.*;
public class stackQues {

    // ques1 push at the bottom of the stack
    public static  void pushAtBottom(Stack<Integer> s ,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // ques2 reverse the string using stack
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while(! s.isEmpty()){
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }

    // function to print the stack 
    public static void printStack(Stack<Integer> s){
        while(! s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }

    // ques3 reverse a stack
    // first approach here tc: O(n) and sc: O(n)
    public static void reverse(Stack<Integer> s){
        Stack<Integer>st = new Stack<>();
        while(!s.isEmpty()){
            st.push(s.pop());
        }
        printStack(st);
    }

    // 2nd approach here tc: O(n) and no extra space i.e by using recursion
    public static void reverse2(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverse2(s);
        pushAtBottom(s, top);
    }

    // ques4 stock span problem
    public static void stockSpan(int stocks[] , int span[]){
        Stack<Integer> s = new Stack<>();
        span[0]=1;
        s.push(0);

        for(int i=1;i<stocks.length ; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice >stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i]=i-prevHigh;
            }
            s.push(i);
        }
    }

    // ques5 valid parenthesis
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length() ;i++){
            char ch = str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if( (s.peek()=='(' && ch==')') || (s.peek()=='{' && ch=='}') || (s.peek()=='[' && ch==']')){
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    
    // ques6 duplicate parenthesis
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length() ;i++){
            char ch = str.charAt(i);
            if(ch==')'){
                int count=0;
                while(s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    s.pop();
                }
            }else{
                s.push(ch);
            }
        }
        return false;
     }

    //  max area in historgam 
    public static void maxArea(int arr[]){
        int maxArea =0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        // next smaller right
        Stack<Integer> s =new Stack<>();
        for(int i=arr.length-1 ; i>=0 ; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }else{
                nsr[i] = arr[s.peek()];
            }
        s.push(i);
        }

        // next smaller left
        s =new Stack<>();
        for(int i=0 ; i<arr.length ; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=arr.length;
            }else{
                nsl[i] = arr[s.peek()];
            }
        s.push(i);
        }
        // current area 
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i]-1;
            int currArea = height*width;
            maxArea = Math.max(maxArea,currArea);
        }
        System.out.println("Max area of the histogram is" + maxArea);

    }
    
    

    public static void main(String[] args) {
        //  Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // pushAtBottom(s,4);
        // String str = "hello";
        // System.out.println(reverseString(str));
        // reverse(s);
        // reverse2(s);
        // printStack(s);
    //     int stocks[] ={100 ,80 , 60,70,60,85,100};
    //     int span[] = new int[stocks.length];
    //     stockSpan(stocks, span);
    //    System.out.println( Arrays.toString(span));


       // next greater element
       // first method is brute force that we will apply two loops and compare each element to get the next greater element 
       // second approach 
      
    //    int arr[] ={4,5,8,2,3,1};
    //    Stack<Integer> s =new Stack<>();
    //    int nextGrt[] = new int[arr.length];
    //    for(int i=arr.length-1 ; i>=0 ; i--){
    //     while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
    //         s.pop();
    //     }
    //     if(s.isEmpty()){
    //         nextGrt[i]=-1;
    //     }else{
    //         nextGrt[i] = arr[s.peek()];
    //     }
    //     s.push(i);
    //    }

    //    System.out.println(Arrays.toString(nextGrt));


    //    next greater left
    // int arr[] ={4,5,8,2,3,1};
    // Stack<Integer> s =new Stack<>();
    // int nextGrtLeft[] = new int[arr.length];
    // for(int i=0 ; i<arr.length ; i++){
    //     while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
    //         s.pop();
    //     }
    //     if(s.isEmpty()){
    //         nextGrtLeft[i]=-1;
    //     }else{
    //         nextGrtLeft[i] = arr[s.peek()];
    //     }
    //     s.push(i);
    //    }
    //    System.out.println(Arrays.toString(nextGrtLeft));

    // next smaller right
    // int arr[] ={4,5,8,2,3,1};
    // Stack<Integer> s =new Stack<>();
    // int nextSmall[] = new int[arr.length];
    // for(int i=arr.length-1 ; i>=0 ; i--){
    // while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
    //     s.pop();
    // }
    // if(s.isEmpty()){
    //     nextSmall[i]=-1;
    // }else{
    //     nextSmall[i] = arr[s.peek()];
    // }
    // s.push(i);
    // }

    // System.out.println(Arrays.toString(nextSmall));

    // String str = "({[]}({}))";
    // System.out.println(isValid(str));

    String str ="((a+b)+(c+d))";
    System.out.println(isDuplicate(str));

    int arr[] = {2 ,1 ,5 ,6 ,2 ,3};
    maxArea(arr);

    }
}
