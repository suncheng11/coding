public class ZigzagIterator {
    IList<int> data1;
    IList<int> data2;

    int cnt1 = 0;
    int cnt2 = 0;

    boolean from2 = false;

    public ZigzagIterator(IList<int> v1, IList<int> v2) {
        data1 = v1;
        data2 = v2;
    }

    public bool HasNext() {
        return cnt1 < data1.Count || cnt2 < data2.Count;
    }

    public int Next() {
        if(from2){
            int ret = data2[cnt2++];
            if(cnt1 < data1.Count){
                from2 = !from2;
            }
            return ret;
        }
         int ret = data1[cnt1++];
            if(cnt2 < data2.Count){
                from2 = !from2;
            }
            return ret;
    }
}

/**
 * Your ZigzagIterator will be called like this:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.HasNext()) v[f()] = i.Next();
 */