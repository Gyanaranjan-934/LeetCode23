class Solution {
    private int recFunc(int ind,int[] cookies,int[] childrens){
        if(ind<0){
            int maxi = Integer.MIN_VALUE;
            for(int i:childrens)maxi = Math.max(i,maxi);
            return maxi;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<childrens.length;i++){
            childrens[i]+=cookies[ind];
            int res = recFunc(ind-1,cookies,childrens);
            ans = Math.min(ans,res);
            childrens[i]-=cookies[ind];
        }
        return ans;

    }
    public int distributeCookies(int[] cookies, int k) {
        int[] childrens = new int[k];
        return recFunc(cookies.length-1,cookies,childrens);
    }
}