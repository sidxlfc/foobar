/*

Save Beta Rabbit
================

Oh no! The mad Professor Boolean has trapped Beta Rabbit in an NxN grid of rooms. In the center of each room (except for the top left room) is a hungry zombie. In order to be freed, and to avoid being eaten, Beta Rabbit must move through this grid and feed the zombies.

Beta Rabbit starts at the top left room of the grid. For each room in the grid, there is a door to the room above, below, left, and right. There is no door in cases where there is no room in that direction. However, the doors are locked in such a way that Beta Rabbit can only ever move to the room below or to the right. Once Beta Rabbit enters a room, the zombie immediately starts crawling towards him, and he must feed the zombie until it is full to ward it off. Thankfully, Beta Rabbit took a class about zombies and knows how many units of food each zombie needs be full.

To be freed, Beta Rabbit needs to make his way to the bottom right room (which also has a hungry zombie) and have used most of the limited food he has. He decides to take the path through the grid such that he ends up with as little food as possible at the end.

Write a function answer(food, grid) that returns the number of units of food Beta Rabbit will have at the end, given that he takes a route using up as much food as possible without him being eaten, and ends at the bottom right room. If there does not exist a route in which Beta Rabbit will not be eaten, then return -1.

food is the amount of food Beta Rabbit starts with, and will be a positive integer no larger than 200.

grid will be a list of N elements. Each element of grid will itself be a list of N integers each, denoting a single row of N rooms. The first element of grid will be the list denoting the top row, the second element will be the list denoting second row from the top, and so on until the last element, which is the list denoting the bottom row. In the list denoting a single row, the first element will be the amount of food the zombie in the left-most room in that row needs, the second element will be the amount the zombie in the room to its immediate right needs and so on. The top left room will always contain the integer 0, to indicate that there is no zombie there.

The number of rows N will not exceed 20, and the amount of food each zombie requires will be a positive integer not exceeding 10.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
    (int) food = 7
    (int) grid = [[0, 2, 5], [1, 1, 3], [2, 1, 1]]
Output:
    (int) 0

Inputs:
    (int) food = 12
    (int) grid = [[0, 2, 5], [1, 1, 3], [2, 1, 1]]
Output:
    (int) 1

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.

*/

package com.google.challenges; 

public class Answer {   
    public static int answer(int food, int[][] grid) 
    { 
    	int count = 0, temp = 0;
    	int len = grid[0].length;

    	int pointer = grid[0][0];

    	int c = 2*len - 1;
    	int x = 0, y = 0, x1 = 0, y1 = 0;
    	
    	for (int j = 1; j <= c; j++)
    	{
    		if (x == len - 1)
    		{
    			if (y == len - 1)
    			{
    			    count += grid[x][y];
    			    temp += grid[y][x];
    				break;
    			}

    			else if (y < len - 1)
    			{
    				//System.out.println("if elif, x = " + x + " y = " + y + " count = " + count);
    				for (int i = y + 1; i < len; i++)
    				{
    					//move all the way down
    					//System.out.println("if elif for, x = " + x + " y = " + i + " element = " + grid[i][x] + " count = " + count);
    					//if (count + grid[i][x] <= food)
    					//{
    						count += grid[i][x];
    						temp += grid[x][i];
    					//}
    					//System.out.println("(after) if elif for, x = " + x + " y = " + i + " element = " + grid[i][x] + " count = " + count);
    				}
    				break;
    			}

    			else
    			{
    				//System.out.println("Something's wrong, y = " + y);
    			}
    		}

    		else if (x < len - 1)
    		{
    			if(y == len - 1)
    			{
    				for (int i = x + 1; i < len; i++)
    				{
    					// move all the way to the right
    					count += grid[y][i];
    					temp += grid[i][y];
    				}
    				break;
    			}

    			else if (y < len - 1)
    			{
    				if (grid[y + 1][x] <= grid[y][x + 1])
    				{
    					//System.out.println("if elif elif if, x = " + x + " y = " + y + " count = " + count);
    					//if (count + grid[y][x + 1] >= food)
    					//{
    					    count += grid[y][x + 1];
    					    temp += grid[x + 1][y];
    					    x++;
    					//}
    					
    					/*else
    					{
    					    count += grid[y + 1][x];
    					    y++;
    					}*/
    					
    				}	

    				else
    				{
    					//System.out.println("if elif elif else, x = " + x + " y = " + y + " count = " + count);
    					count += grid[y + 1][x];
    					temp += grid[x][y + 1];
    					y++;
    				}
    			}

    			else
    			{
    				//System.out.println("Something's wrong, y = " + y);
    			}
    		}

    		else
    		{
    			//System.out.println("Something's wrong, x = " + x);
    		}
    	}
    	
    	
        
        
        if (temp <= count)
        {
    	    if (food - count >= 0)
    	    {
    	    	return food - count;
    	    }

    	    else
    	    {
    		    return (food - count) / food;
    	    }
        }
        
        else
        {
            if (food - temp >= 0)
    	    {
    	    	return (food - temp) / food;
    	    }

    	    else
    	    {
    		    return (food - temp) / temp;
    	    }
        }
    } 
}

/*
def answer(food, grid):
    N = len(grid)
    ans_grid = [[set() for i in range(N)] for j in range(N)]
    ans_grid[0][0] |= {grid[0][0]}
    for (row, row_val) in enumerate(grid):
        for (col, val) in enumerate(row_val):
            if row != 0:
                ans_grid[row][col] |= {val + x for x in ans_grid[row-1][col]
                                       if (val + x) <= food}
            if col != 0:
                ans_grid[row][col] |= {val + x for x in ans_grid[row][col-1]
                                       if (val + x) <= food}
    all_ans = sorted(ans_grid[N-1][N-1], reverse=True)
    for el in all_ans:
        if el <= food:
            return food-el
    return -1
    */