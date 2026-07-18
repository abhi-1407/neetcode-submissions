class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;
        while(l < r){
            int lHeight = heights[l];
            int rHeight = heights[r];
            int area = Math.min(rHeight,lHeight) * (r-l);
            maxArea = Math.max(maxArea,area);
            if(rHeight >= lHeight){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
