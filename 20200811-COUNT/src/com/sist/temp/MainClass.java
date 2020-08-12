package com.sist.temp;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] emp={10,20,30,10,20,30};
        int[] dept={10,10,20,20,30,30};
        for(int e:emp)
        {
        	for(int d:dept)
        	{
        		if(e==d)
        		{
        			System.out.println(e+","+d);
        		}
        	}
        }
	}

}
