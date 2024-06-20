class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start=1, end=position[position.length-1]-position[0]+1;
        while(start<end){
            int mid = start+(end-start)/2;
            int num = compute(position, mid);
            if(num>=m){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        if(compute(position, start-1)>=m) return start-1;
        return start;
    }
    private int compute(int[] position, int dist){
        int num = 1;
        int prev = position[0];
        for(int i=1; i<position.length; i++){
            if(position[i]-prev>=dist){
                num++;
                prev = position[i];
            }
        }
        return num;
    }
}