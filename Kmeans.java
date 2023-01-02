import java.util.*;
class Kmeans{
    public static void main(String args[]){
        int dataset[][] = {
            {5,18},{5,32},{2,25},{4,19},{4,74},{2,75},{5,47},
            {3,46},{2,63},{4,75},{5,25},{4,19},{5,23},{4,57},
            {4,59},{1,44},{5,46},{1,47},{4,33},{4,42},{3,51},
            {4,29},{5,58},{1,55},{5,42},{5,68},{4,49},{2,36},
            {5,60},{5,51},{3,66},{5,47},{5,22},{1,26},{3,71},
            {1,39},{2,62},{5,68},{3,44},{2,61},{5,50},{2,42},
            {5,50},{5,72},{3,25},{1,46},{4,68},{3,62},{3,27},
            {4,42},{1,49},{4,21},{2,24},{5,43},{3,47},{2,29},
            {5,51},{4,41},{2,67},{2,58},{3,57},{5,71},{3,70},
            {5,23},{1,72},{2,29},{2,66},{5,63},{4,28},{5,50},
            {1,73},{3,74},{3,50},{1,59},{3,67},{1,38},{5,58},
            {2,22},{2,72},{4,72},{5,67},{2,56},{2,53},{4,75},
            {1,34},{1,24},{5,43},{3,72},{1,29},{5,24},{2,27},
            {2,32},{4,73},{4,26},{2,62},{5,64},{1,67},{2,24},
            {5,35},{4,53}
        };
        int i,j,k=2;
        int part1[][] = new int[100][2];
        int part2[][] = new int[100][2];
        float mean1[][] = new float[1][2];
        float mean2[][] = new float[1][2];

        float temp1[][] = new float[1][2], temp2[][] = new float[1][2]; 
        int sum11 = 0, sum12=0, sum21 = 0, sum22 = 0;
        double dist1, dist2;
        int i1=0, i2=0, itr=0;

        // Printing the dataset 
        System.out.println("Dataset: ");
        for(i=0;i<10;i++){
            System.out.println(dataset[i][0]+""+dataset[i][1]);
        }
        System.out.println("\nNumber of partitions: "+k);

        // Assuming (2,2) and (5,7) are random means
        mean1[0][0] = 3;
        mean1[0][1] = 25; 
        mean2[0][0] = 5;
        mean2[0][1] = 71;

        // Loop till the new mean and previous mean are same 
        while(!Arrays.deepEquals(mean1, temp1) || !Arrays.deepEquals(mean2, temp2)){

            //Empting the partitions
            for(i=0;i<100;i++){
                part1[i][0] = 0;
                part1[i][1] = 0;
                part2[i][0] = 0; 
                part2[i][1] = 0;
            }

            i1=0;i2=0;

        //Finding distance between mean and data point and store the data point in the corresponding partition
            for(i=0;i<100;i++) {
                dist1 = Math.sqrt(Math.pow(dataset[i][0]-mean1[0][0],2) + Math.pow(dataset[i][1]-mean1[0][1],2));
                dist2 = Math.sqrt(Math.pow(dataset[i][0]-mean2[0][0],2) + Math.pow(dataset[i][1]-mean2[0][1],2));
                if(dist1 < dist2){
                    part1[i1][0] = dataset[i][0];
                    part1[i1][1] = dataset[i][1];
                    i1++;
                }
                else{
                    part2[i2][0] = dataset[i][0]; 
                    part2[i2][1] = dataset[i][1];
                    i2++;
                }
            }
            //Storing the previous mean 
            temp1[0][0] = mean1[0][0]; 
            temp1[0][1] = mean1[0][1]; 
            temp2[0][0] = mean2[0][0]; 
            temp2[0][1] = mean2[0][1];

            //Finding new mean for new partitions 
            sum11=0; sum12= 0; sum21= 0; sum22=0;
            for(i=0;i<i1;i++){ 
                sum11 += part1[i][0]; 
                sum12 += part1[i][1];
            }

            for(i=0;i<i2;i++){
                sum21 += part2[i][0];
                sum22 += part2[i][1];
            }
            mean1[0][0] = (float)sum11/i1;
            mean1[0][1] = (float)sum12/i1;
            mean2[0][0] = (float)sum21/i2;
            mean2[0][1] = (float)sum22/i2;
            itr++;
        }
        System.out.println("\nFinal Partition: ");

        System.out.println("Part1:"); 
        for(i=0;i<i1;i++){
            System.out.println(part1[i][0]+" "+part1[i][1]);
        }

        System.out.println("\nPart2"); 
        for(i=0;i<i2;i++) { 
            System.out.println(part2[1][0]+" "+part2[i][1]);
        }
        System.out.println("\nFinal Mean: ");
        System.out.println("Mean1: "+mean1[0][0]+" "+mean1[0][1]); 
        System.out.println("Mean2: "+mean2[0][0]+" "+mean2[0][1]); 
        System.out.println("\nTotal Iteration: "+itr);
    }
}