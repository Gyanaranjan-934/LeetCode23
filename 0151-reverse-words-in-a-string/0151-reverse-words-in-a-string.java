class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strArr = s.split(" ");
        String res = "";
        for(int i=strArr.length-1;i>=0;i--){
            String temp = strArr[i].trim();
            if(temp!="")res += temp+" ";
        }
        return res.trim();
    }
}