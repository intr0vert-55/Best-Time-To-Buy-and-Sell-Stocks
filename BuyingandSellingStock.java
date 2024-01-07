import java.util.Scanner;
class BuyingandSellingStock{
   public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of days : ");
        int days = s.nextInt();
        System.out.print("Enter the prices : ");
        int [] arr = new int [days];
        for(int i = 0;i < days;i++){
            arr[i] = s.nextInt();
        }
        s.close();
        Solution sol = new Solution();
        System.out.println("The maximum profit that can be gained is : "+sol.maxProfit(arr));
   } 
}
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int i = 0;
        int minima = -1, maxima = -1, tempMaxima = -1, tempMinima = -1;
        while(i < prices.length){
            if(minima != -1){
                if(tempMaxima != -1){
                    if(prices[i] < tempMaxima){
                        maxima = tempMaxima;
                        profit += maxima - minima;
                        tempMaxima = -1;
                        minima = -1;
                        maxima = -1;
                    }
                    else{
                        tempMaxima = prices[i];
                        i++;
                    }
                }
                else{
                    try{
                        if(prices[i] > prices[i+1]){
                            maxima = prices[i];
                            profit += maxima - minima;
                            minima = -1;
                            maxima = -1;
                            i++;
                        }
                        else{
                            tempMaxima = prices[i+1];
                            i += 2;
                        }
                    }
                    catch(Exception e){
                        if(minima < prices[i])
                            tempMaxima = prices[i];
                    }
                }
            }
            else{
                if(tempMinima != -1){
                    if(tempMinima < prices[i]){
                        minima = tempMinima;
                        tempMinima = -1;
                    }
                    else{
                        tempMinima = prices[i];
                        i++;
                    }
                }
                else{
                    try{
                        if(prices[i] < prices[i+1]){
                            minima = prices[i];
                            i++;
                        }
                        else{
                            tempMinima = prices[i+1];
                            i += 2;
                        }
                    }
                    catch(Exception e){
                        break;
                    }
                }
            }
        }
        if(tempMaxima != -1){
            profit += tempMaxima - minima;
        }
        return profit;
    }
}


// This might actually be more complicated than other's solutions.
// But it is made without using any recursive function if that could feel more complicated.
// This is question number 122 (Best Time to Buy and Sell Stocks ii) in leetcode.
// It gets executed with a run time of 2ms and takes a memory of 45.67MB.
// The concept/algorithm used here is the concept used by GeeksForGeeks.
// Thanks to them for that.
// The link to that explanation is in the link below : 
// https://youtu.be/JaosdXkUWTs?si=DNXh4u89m1GBp94Z
