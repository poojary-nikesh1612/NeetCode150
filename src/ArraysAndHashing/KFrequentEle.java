package ArraysAndHashing;

import java.util.*;

public class KFrequentEle {
    //better approach using priorityQueues TC->O(nlogk) & SC->O(n+k)
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<int[]> heap=new PriorityQueue<>((a, b)->Integer.compare(a[0],b[0]));

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            heap.offer(new int[]{entry.getValue(),entry.getKey()});

            if(heap.size()>k){
                heap.poll();
            }
        }


        int[]res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=heap.poll()[1];
        }
        return res;
    }

    //optimal one, TC->O(n) & SC->O(n)
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer>[] freq=new List[nums.length+1];

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int i=0;i<freq.length;i++){
            freq[i]=new ArrayList<>();
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[]res=new int[k];
        int index=0;
        for(int i=freq.length-1;i>0 && index<k;i--){
            for(int n:freq[i]){
                res[index++]=n;
                if(index==k){
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[]args){
        int[]arr={1,1,1,2,2,3};
        int[]ans=topKFrequent(arr,2);
        for(int num:ans){
            System.out.print(num+" ");
        }
    }
}
