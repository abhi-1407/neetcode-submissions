class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.putIfAbsent(num,0);
            freq.put(num,freq.get(num) + 1);
        }

        List<Integer>[] freqArr = new ArrayList[nums.length + 1];

        for(int i = 0; i < freqArr.length; i++){
            freqArr[i] = new ArrayList<>();
        }
        
        for(int num : freq.keySet()){
            int frequency = freq.get(num);
            freqArr[frequency].add(num);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = freqArr.length - 1; i >= 0 && ans.size() < k ; i--){
            List<Integer> temp = freqArr[i];
            for(int j = 0; j < temp.size(); j++){
                ans.add(temp.get(j));
                if(ans.size() == k){
                    break;
                }
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
