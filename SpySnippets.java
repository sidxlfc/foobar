import java.util.*;

class SpySnippets 
{   
    public static String answer(String document, String[] searchTerms) 
    { 
        List<String> pa = new ArrayList<String>();

        List<String> temp = new ArrayList<String>();
        
        String doc[] = document.split(" ");
        
        for(String s : searchTerms)
        {
        	temp.add(s);
        }

        List<String> newtemp = temp;

        int count = 0;
        String tString = "";
        
        for(String s : doc)
        {
        	comeHere : 
			if (newtemp.contains(s))
			{
				tString += s + " ";				
				newtemp.remove(s);
				for(int i = count + 1; i < doc.length; i++)
				{
					tString += doc[i] + " ";
					
					if (newtemp.contains(doc[i]))
					{
						newtemp.remove(doc[i]);
						if(newtemp.isEmpty())
						{
							//System.out.println("newtemp is empty, count = " + count);
							pa.add(tString.substring(0, tString.length() - 1));
							//newtemp = temp;
							for(String s2 : searchTerms)
        					{
        						newtemp.add(s2);
        					}
        					tString = "";
							//System.out.println("newtemp = " + newtemp);
							//count++;
							break comeHere;
						}
					}
				}
			}
		count++;
		}

	Comparator<String> x = new Comparator<String>()
    {
        @Override
        public int compare(String o1, String o2)
        {
            if(o1.length() < o2.length())
                return -1;

            if(o2.length() < o1.length())
                return 1;
                
            return 0;
        }
    };

    Collections.sort(pa,  x);
    
    return pa.get(0);	
    }

    public static void main(String args[]) 
    {
    	String document = "a b c d a";
    	String searchTerms[] = {"a", "c", "d"};

    	System.out.println(answer(document, searchTerms));
    }
}

/*
Spy snippets
============

You've been recruited by the team building Spy4Rabbits, a highly advanced search engine used to help fellow agents discover files and intel needed to continue the operations against Dr. Boolean's evil experiments. The team is known for recruiting only the brightest rabbit engineers, so there's no surprise they brought you on board. While you're elbow deep in some important encryption algorithm, a high-ranking rabbit official requests a nice aesthetic feature for the tool called "Snippet Search." While you really wanted to tell him how such a feature is a waste of time in this intense, fast-paced spy organization, you also wouldn't mind getting kudos from a leader. How hard could it be, anyway?

When someone makes a search, Spy4Rabbits shows the title of the page. Your commander would also like it to show a short snippet of the page containing the terms that were searched for. 

Write a function called answer(document, searchTerms) which returns the shortest snippet of the document, containing all of the given search terms. The search terms can appear in any order.

The length of a snippet is the number of words in the snippet. For example, the length of the snippet "tastiest color of carrot" is 4. (Who doesn't like a delicious snack!)

The document will be a string consisting only of lower-case letters [a-z] and spaces. Words in the string will be separated by a single space. A word could appear multiple times in the document.
searchTerms will be a list of words, each word comprised only of lower-case letters [a-z]. All the search terms will be distinct.

Search terms must match words exactly, so "hop" does not match "hopping".

Return the first sub-string if multiple sub-strings are shortest. For example, if the document is "world there hello hello where world" and the search terms are ["hello", "world"], you must return "world there hello".

The document will be guaranteed to contain all the search terms.

The number of words in the document will be at least one, will not exceed 500, and each word will be 1 to 10 letters long. Repeat words in the document are considered distinct for counting purposes.
The number of words in searchTerms will be at least one, will not exceed 100, and each word will not be more than 10 letters long.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
    (string) document = "many google employees can program"
    (string list) searchTerms = ["google", "program"]
Output:
    (string) "google employees can program"

Inputs:
    (string) document = "a b c d a"
    (string list) searchTerms = ["a", "c", "d"]
Output:
    (string) "c d a"

Use verify [file] to test your solution and see how it does. When you are finished editing your code, use submit [file] to submit your answer. If your solution passes the test cases, it will be removed from your home folder.
*/