class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();
        
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String temp = String.valueOf(ch);
            
            if(hmap.get(temp)==null)   hmap.put(temp, new ArrayList<String>());
            hmap.get(temp).add(s);
        }
        
        return new ArrayList<>(hmap.values());
    }
}
