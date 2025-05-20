package Problem_3_Hiring_k_workers;

import java.util.PriorityQueue;

/**
 * here we are using two priority queue to store before and after candidates
 * after kth hiring we get total cost required
 * select worker who has the least cost from both queue ,and it cost matches tie-break with index value
 * T.C.-O((Candidates+K)∗LogCandidates)
 * s.C.-O(Candidates)
 */
class Solution {
    /**
     *
     * @param costs       array where costs[i] is the cost of hiring ith worker.
     * @param k           no. of employees to hire
     * @param candidates  total persons to take at one time
     * @return             total cost required tp hire k workers.
     */
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> frontHeap=new PriorityQueue<>((a, b)->a[0]!=b[0]?
                Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        PriorityQueue<int[]> backHeap=new PriorityQueue<>((a,b)->a[0]!=b[0]?
                Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));

        long totalCosts=0;
        int n=costs.length;
        int left=0;
        int right=n-1;

        for(int i=0;i<candidates && left<=right;i++){
            frontHeap.offer(new int[]{costs[left],left});
            left++;
        }

        for(int i=0;i<candidates && left<=right;i++){
            backHeap.offer(new int[]{costs[right],right});
            right--;
        }

        for(int hire=0;hire<k;hire++){
            if(!frontHeap.isEmpty() && !backHeap.isEmpty()){
                if(frontHeap.peek()[0]<=backHeap.peek()[0]){
                    totalCosts+=frontHeap.poll()[0];
                    if(left<=right){
                        frontHeap.offer(new int[]{costs[left],left});
                        left++;
                    }
                }else{
                    totalCosts+=backHeap.poll()[0];
                    if(left<=right){
                        backHeap.offer(new int[]{costs[right],right});
                        right--;
                    }
                }
            }else if(!frontHeap.isEmpty()){
                totalCosts+=frontHeap.poll()[0];
                if(left<=right){
                    frontHeap.offer(new int[]{costs[left],left});
                    left++;
                }
            }else{
                totalCosts+=backHeap.poll()[0];
                if(left<=right){
                    backHeap.offer(new int[]{costs[right],right});
                    right--;
                }

            }
        }
        return totalCosts;
    }

    public static void main(String[] args) {
        int[] costs={17,12,10,2,7,2,11,20,8};
        int k=3;
        int candidates=4;
        Solution solution=new Solution();
        System.out.println("Total cost required: "+solution.totalCost(costs,k,candidates));
    }
}