
public class proj2 {

	int simulation = 100;
	
	public static void main(String[] args)
	{
		proj2 cte = new proj2();
		cte.runSim();
	
	}
	
	public int calcTime() {
		
		int t = 0;
		
		int attempt = 0;
		
		int max_attempts = 3;
		
		while (attempt < max_attempts)
		{
			double x = (Math.random() * ((4 - 0) + 0)) + 0;
			
			double newProb = (Math.random() * ((1 - 0) + 0)) + 0;
			double newProbR = Math.round(newProb * 10000.0) / 10000.0;
			
			double findWait = Math.pow(newProbR, 2.0/3.0);
			double waitTime = 4.0 * findWait;
			//System.out.println("Prob Val: " + newProb + " Prob Round: " + newProbR);

			//System.out.println("findWait: " + findWait);
			//System.out.println("waitTime: "  + waitTime);
			
			double xRound = Math.round(x * 10000.0) / 10000.0;
			//double xRound = 1.4;		//test var
			t = t + 3;					//dial 3 sec
			attempt  = attempt + 1;
			//System.out.println("attempt: " + attempt);
			//System.out.println("X Val: " + xRound);
			if(waitTime <= 1.5)
			{
				int newMTS = (int)Math.round(60 * waitTime);
				int MTS = (int)Math.round(60 * xRound);
				//System.out.println("MTS: " + newMTS);
				
				t = t + 2 + newMTS + 5;		//2 sec hang up, 5 sec connect, wait time in sec
				
				
				//System.out.println("newProb Var: " + newProb);
				
				if(newProb > 0.0 && newProb <= 0.2)
				{
					t = t + 72;
					break;
				}
				else if(newProb > 0.2 && newProb <= 0.5)
				{
					t = t + 96;
					break;
				}
				else if(newProb > 0.5 && newProb <= 0.6)
				{
					t = t + 81;
					break;
				}
				else if(newProb > 0.6 && newProb <= 1.0)
				{
					t = t + 114;
					break;
				}
				else
				{
					System.out.println("Error: Out of Bounds of Argument");
				}
			}
			else
			{
				t = t + 90 + 2;
				//System.out.println("no call");	
			}	
			//System.out.println(x);
			//System.out.println(xRound);
			//System.out.println(t);	
	}
		//System.out.println(t);
		return t;
	}
	public void runSim()
	{
		int totTime = 0;
		int[] times = new int[simulation];
		
		for(int i = 0; i < simulation; i++)
		{
			//proj2 cte = new proj2();
			//cte.calcTime();
			
			int result = calcTime();
			times[i] = result;
			
			totTime = totTime + result;
		}
		System.out.println("Total Time: " + totTime);
		double expected = totTime / simulation;
		System.out.println("Expected Output: " + expected);
		
		//int sortedTime[] = new int[simulation];
		
		java.util.Arrays.sort(times);
		
		
		double medianVal = (times[simulation / 2] + times[(simulation - 1) / 2]) / 2.0;
		System.out.println("Median Val: " + medianVal);
		
		
		
		for (int i = 0; i < times.length; i++) {
            System.out.println( times[i]);
        }
        
        //"Time " + (i + 1) + ": " +
        
	}
	
	
	
}
