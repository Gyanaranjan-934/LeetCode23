class Solution {
    public int[] rearrangeBarcodes(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxElem = -1;
        int maxFreq = 0;
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i)>maxFreq){
                maxElem = i;
                maxFreq = map.get(i);
            }
        }

        int k = 0;
        while(maxFreq>0){
            res[k] = maxElem;
            k+=2;
            maxFreq--;
        }

        map.remove(maxElem);

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            // System.out.println(key+"->"+value);
            while(value>0){
                if(k>=res.length)k=1;
                res[k] = key;
                k+=2;
                value--;
            }
        }
        return res;
    }
}