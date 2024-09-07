class MyQueue {
        Stack<Integer> fir;
        Stack<Integer> sec;
    public MyQueue() {
         fir = new Stack<>();
         sec = new Stack<>();

    }
    
    public void push(int x) {
        fir.push(x);
    }
    
    public int pop() {
        while(!fir.isEmpty()){
                sec.push(fir.pop());
        }
       int removed = sec.pop();
        while(!sec.isEmpty()){
                fir.push(sec.pop());
        }
        return removed;
    }
    
    public int peek() {
        while(!fir.isEmpty()){
                sec.push(fir.pop());
        }
       int peeked = sec.peek();
        while(!sec.isEmpty()){
                fir.push(sec.pop());
        }
        return peeked;
    }
    
    public boolean empty() {
        return fir.isEmpty();
    }
}
