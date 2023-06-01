class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int n = salary.length;
        if(n==3){
            return salary[1];
        }
        int c = 0;
        for(int i=0; i<n; i++){
            c+=salary[i];
        }
        double d = c-salary[0]-salary[n-1];
        double e = d/(salary.length-2);
        return e;
    }
}