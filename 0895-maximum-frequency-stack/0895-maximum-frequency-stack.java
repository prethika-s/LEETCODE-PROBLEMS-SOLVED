class FreqStack {
    public HashMap<Integer, Stack<Integer>> stacks;
    public HashMap<Integer, Integer> freqMap;
    public int maxFreq;
    public FreqStack() {
        stacks = new HashMap<>();
        freqMap = new HashMap<>();
        maxFreq=0;
    }
    
    public void push(int val) {
        int element = val;
        freqMap.put(element, freqMap.getOrDefault(element,0)+1);
        int freq = freqMap.get(element);
        if(freq>maxFreq){
            maxFreq = freq;
            Stack<Integer> idxStack = new Stack<>();
            idxStack.push(element);
            stacks.put(maxFreq,idxStack);
        }
        else{
            Stack<Integer> tempStack = stacks.get(freq);
            if (tempStack == null) {
                tempStack = new Stack<>();
                stacks.put(freq, tempStack);
            }
            tempStack.push(element);
        }
    }
    
    public int pop() {
        if (maxFreq == 0 || !stacks.containsKey(maxFreq)) {
            return -1; // or throw new RuntimeException("Empty FreqStack");
        }
        Stack<Integer> maxFreqStack = stacks.get(maxFreq);
         if (maxFreqStack == null || maxFreqStack.isEmpty()) {
            // find the correct maxFreq
            while (maxFreq > 0 && (!stacks.containsKey(maxFreq) || stacks.get(maxFreq).isEmpty())) {
                maxFreq--;
            }
            if (maxFreq == 0) return -1;
            maxFreqStack = stacks.get(maxFreq);
        }
        int poppedElement = maxFreqStack.pop();
        freqMap.put(poppedElement, freqMap.get(poppedElement) - 1);
        if(freqMap.get(poppedElement)==0) freqMap.remove(poppedElement);
        if(maxFreqStack.size()==0){
            stacks.remove(maxFreqStack);
            while (maxFreq > 0 && (!stacks.containsKey(maxFreq) || stacks.get(maxFreq).isEmpty())) {
                maxFreq--;
            }
        } 
        return poppedElement;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */