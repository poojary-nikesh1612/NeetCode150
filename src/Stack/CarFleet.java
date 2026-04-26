package Stack;

import java.util.Arrays;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        int[][]pair=new int[n][2];

        for(int i=0;i<n;i++){
            pair[i][0]=position[i];
            pair[i][1]=speed[i];
        }
        Arrays.sort(pair,(a, b)->Integer.compare(b[0],a[0]));

        double curFleetTime=0;
        int fleetCnt=0;

        for(int[] p:pair){
            if(curFleetTime<(double)(target-p[0])/p[1]){
                fleetCnt++;
                curFleetTime=(double)(target-p[0])/p[1];
            }
        }
        return fleetCnt;
    }

    public static void main(String[]args){
        int[] position={10,8,0,5,3};
        int[]speed={2,4,1,1,3};
        System.out.println(carFleet(12,position,speed));
    }
}
