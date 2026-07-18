class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            int len = str.length();
            sb.append(len);
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder();
        List<String> ls = new ArrayList<>();
        int len = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                len = len * 10 + (str.charAt(i) - '0');
            }
            else if(str.charAt(i) == '#'){
                ls.add(str.substring(i + 1,i + len + 1));
                i = i + len;
                len = 0;
            }
        }
        return ls;
    }
}