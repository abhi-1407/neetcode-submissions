class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String str : strs){
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < s.length()){
            int j = i;
            while(s.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(s.substring(i,j));
            j++; //skip #

            String str = s.substring(j,j + len);

            result.add(str);

            i = j + len;
        }
        return result;
    }
}
