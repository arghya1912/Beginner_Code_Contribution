class Solution {
    int c;
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        int dots=n+1;
        int parent[]=new int[dots*dots];
        int rank[]=new int[dots*dots];
        c=1;
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<dots;i++){
            for(int j=0;j<dots;j++){
                if(i==0 || j==0 || i==dots-1||j==dots-1){
                    int cellno=i*dots+j;
                    if(cellno!=0)
                        union(0,cellno,rank,parent);
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            char ch[]=grid[i].toCharArray();
            for(int j=0;j<ch.length;j++){
                if(ch[j]=='/'){
                   
                     int cell1=i*dots+j+1;
                    int cell2=(i+1)*dots+j;
                    union(cell1,cell2,rank,parent);
                }
                else if(ch[j]=='\\'){
                     int cell1=i*dots+j;
                    int cell2=(i+1)*dots+j+1;
                    union(cell1,cell2,rank,parent);
                }
            }
        }
        return c;
    }
    public int findPar(int node,int parent[]){
        if(node==parent[node])return node;
        return parent[node]=findPar(parent[node],parent);
    }
    public void union(int u,int v,int rank[],int parent[]){
        u=findPar(u,parent);
        v=findPar(v,parent);
        if(u!=v){
            if(rank[u]<rank[v]){
                parent[u]=v;
            }
            else if(rank[v]<rank[u]){
                parent[v]=u;
            }
            else{
                parent[u]=v;
                rank[u]++;
            }
        }
        else{
            c++;
        }
    }
}