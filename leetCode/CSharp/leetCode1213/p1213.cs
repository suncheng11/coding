public class Solution {
    public IList<int> ArraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        HashSet<int> set1 = new HashSet<int>();
        HashSet<int> set2 = new HashSet<int>();

        foreach(int item in arr1){
            set1.Add(item);
        }
        foreach(int item in arr2){
            set2.Add(item);
        }

        IList<int> ret = new List<int> ();

        foreach(int item in arr3){
            if(set1.Contains(item) && set2.Contains(item)){
                ret.Add(item);
            }
        }

        return ret;
    }
}