class SnapshotArray {
    private int id;
    private Map<Integer, Map<Integer, Integer>> map;

    public SnapshotArray(int length) {
        this.id = 0;
        this.map = new HashMap<>();
        
        for (int i = 0; i < length; i++) {
            this.map.computeIfAbsent(i, v -> new HashMap<>()).put(id, 0);
        }
    }
    
    public void set(int index, int val) {
        map.get(index).put(id, val);
    }
    
    public int snap() {
        return id++;
    }
    
    public int get(int index, int snap_id) {
        Map<Integer, Integer> subMap = map.get(index);
        
        while (!subMap.containsKey(snap_id)) snap_id--;
        
        return subMap.get(snap_id);
    }
}