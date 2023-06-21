import java.util.*;
import java.lang.*;
import java.io.*;
class Pair{
    int value;
    int freq;
    Pair(int val,int fr){
        this.value = val;
        this.freq = fr;
    }
}
class GFG
 {
    private static int[] helper(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        ArrayList<Pair> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            list.add(new Pair(entry.getKey(),entry.getValue()));
        }
        list.sort((x,y)->y.freq-x.freq);
        int k=0;
        for(Pair p : list){
            for(int i=0;i<p.freq;i++){
                arr[k++]=p.value;
            }
        }
        return arr;
    } 
	public static void main (String[] args)
	 {
	 	Scanner in  = new Scanner(System.in);
	 	ArrayList<int[]> list = new ArrayList<>();
	 	int t = in.nextInt();
	 	while(t!=0){
	 	    int n = in.nextInt();
	 	    int[] arr = new int[n];
	 	    for(int j=0;j<n;j++){
	 	        arr[j] = in.nextInt();
	 	    }
	 	    list.add(helper(arr));
	 	    t--;
	 	}
	 	for(int i=0;i<list.size();i++){
	 	    for(int j:list.get(i)){
	 	        System.out.print(j+" ");
	 	    }
	 	    System.out.println();
	 	}
	 }
}