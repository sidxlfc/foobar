//package com.google.challenges; 

public class Answer 
{
	public static void main(String args[])
	{
		double y[] = {2.2999999999999998, 15.0, 102.40000000000001, 3486.8000000000002};
		double x[] = {23.0, 150.0, 1024.0, 34868.0};
		System.out.println("Answer is : " + answer(y, x));
	}
	
	public static int answer(double[] y, double[] x) 
    { 
        int xl = x.length;
        int yl = y.length;
        int ans = 0;
        ans = (int)compare(y, x);
        return ans;   
    } 
    
    public static double compare(double[] y, double x[])
    {
        double temp[][] = new double[x.length][x.length];
        for (int i= 0; i< x.length; i++)
        {
            for (int j=0; j<y.length; j++)
            {
                temp[i][j] = ((x[i]-y[j])/x[i])*100;
            }
        }
        
        double z[] = new double[x.length];
        
        for (int i= 0; i< x.length - 1; i++)
        {
        z[i] = -10000;
            for (int j=0; j<y.length; j++)
            {
            	for(int k =0; k<x.length; k++)
            	{
            		if(temp[i][j]/temp[i+1][k] >= 0.99 && temp[i][j]/temp[i+1][k] <= 1.01)
            		{
            			z[i] = temp[i][j];
            		}
            	}
            }
        }
        
        for(int i=0; i<z.length; i++)
        {
            if(z[i] >= 0 && z[i] <=100)
            {
                return z[i];
            }
        }
    return 0;
    }
}