class Solution {
    Set<String> bannedSet = new HashSet<>();
    Map<String, Integer> count = new HashMap<>();
    int max;
    String res;
    
    public String mostCommonWord(String paragraph, String[] banned) {
        StringBuilder sb = new StringBuilder("");
        for(String s : banned)  bannedSet.add(s);
        
        for(char c : paragraph.toCharArray()){
            if(c>='a'&&c<='z')  // replaceAll(정규 표현식, " ")으로 푸는 방법보다 빠르다. 
                sb.append(c);
            else if(c>='A'&&c<='Z')  
                sb.append((char)(c+'a'-'A'));
            else    
                process(sb);
        }
        
        process(sb);   // ex) paragraph="Bob" -> 마지막 단어가 process() 안되기 때문에 for문 나와서 한 번 더 해줘야한다.
        
        return res;
    }
    
    public void process(StringBuilder sb){
        if(sb.length()>0){
            String cur = sb.toString();
            if(!bannedSet.contains(cur)){
                int key = count.getOrDefault(cur,0)+1;
                count.put(cur, key);
                if(key > max){
                    max=key;
                    res=cur;
                }
            }   
        }
        sb.setLength(0);
    }
}
