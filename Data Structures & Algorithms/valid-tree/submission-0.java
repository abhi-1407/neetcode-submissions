class Solution {
    private int findPar(int node,int[] parent){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findPar(parent[node],parent); //path compression
    }
    

    private boolean hasCycle(int n, int[][] edges){
        int[] parent = new int[n];
        int[] size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            int parA = findPar(u,parent);
            int parB = findPar(v,parent);
            
            if(parA == parB){
                return true;
            }

            if(size[parA] <= size[parB]){
                //connect B with A
                size[parB] += size[parA];
                parent[parA] = parB;
            }else{
                size[parA] += size[parB];
                parent[parB] = parA;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }
        return !hasCycle(n,edges);
    }
}

