class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        String[] strArr = new String[numRows];
        for(int i=0;i<numRows;i++)strArr[i]="";
        int k = 0;
        int i = 1;
        int ind = 0;
        while(ind<s.length()){
            strArr[k] += s.charAt(ind);
            if(k==0)i=1;
            else if(k==numRows-1)i=-1;
            k+=i;
            ind++;
        }
        String res = "";
        for(String str : strArr)res+=str;
        return res;
    }
}