class SnapshotArray {
    
    private int snaps = 0;
    private List<Value>[] lists;

    public SnapshotArray(int length) {
        lists = new List[length];
        for (int i = 0; i < length; ++i) {
            lists[i] = new ArrayList<>();
            lists[i].add(new Value(0, snaps));
        }
    }
    
    public void set(int index, int value) {
        var list = lists[index];
        var last = list.get(list.size() - 1);
        if (last.snap_id == snaps)
            last.x = value;
        else
            list.add(new Value(value, snaps));
    }
    
    public int snap() {
        return snaps++;
    }
    
    public int get(int index, int snap_id) {
        var list = lists[index];
        int left = 0, right = list.size() - 1;
        while (left + 1 < right) {
            int mid = left + ((right - left) >> 1);
            if (list.get(mid).snap_id < snap_id)
                left = mid;
            else if (list.get(mid).snap_id > snap_id)
                right = mid - 1;
            else 
                return list.get(mid).x;
        }
        if (list.get(right).snap_id <= snap_id)
            return list.get(right).x;
        return list.get(left).x;
    }
}

class Value {
    int x;
    final int snap_id;
    Value(int _x, int _s) {
        x = _x;
        snap_id = _s;
    }
}