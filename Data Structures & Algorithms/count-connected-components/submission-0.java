class Solution {
    private int findUpar(int[] parent,int node){
        if(parent[node] == node){
            return node;
        }
        return parent[node] = findUpar(parent,parent[node]);
    }

    private int findComp(int n, int[][] edges){

        int[] size = new int[n];
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int parU = findUpar(parent,u);
            int parV = findUpar(parent,v);

            if (parU == parV) continue;

            if(size[parU] <= size[parV]){
                size[parV] += size[parU];
                parent[parU] = parV; 
                
            }else{
                size[parU] += size[parV];
                parent[parV] = parU;
            }
        }

        int count = 0;
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                count++;
            }
        }
        return count;
    }
    public int countComponents(int n, int[][] edges) {
        return findComp(n,edges);
    }
}
