class Solution {
    public boolean isPalindrome(String s) {
        Deque<Character> d = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                if(c>='A'&&c<='Z'){ d.add((char)(c+'a'-'A')); continue; }
                else    d.add(c);
            }
        }
        
      // list의 remove(0)은 O(n), deque의 poll()은 O(1)
        while(d.size()>1){
            if(d.poll()!=d.pollLast())  return false;
        }
        return true;
    }
}
