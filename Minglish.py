def answer(words):
    temp = "";
    tempList = [];
    j = 1;
    flag = False;
    for i in range(0, len(words) - 1) :
        word = words[i];
        nextWord = words[i + 1];
        
        if word[0] == nextWord[0] :
            flag = True;
            for k in range(0, len(words) - 1) :
                word = words[k];
                nextWord = words[k + 1];

                if word[0] != nextWord[0] :
                    j = j + 1;
            break;

    if flag == True :
        #print "first if";
        arrayList = [[] for i in range(0, j)];
        #print arrayList;

        for word in words :
            if (word[0] not in temp) :
                temp = temp + word[0];

        j = 0;
        
        for i in range(0, len(words) - 1) :
            word = words[i];
            nextWord = words[i + 1];

            if word[0] != nextWord[0] :
                if word not in arrayList[j] :
                    arrayList[j].append(word);
                j = j + 1;
                if nextWord not in arrayList[j] :
                    arrayList[j].append(nextWord);

            else :
                if word not in arrayList[j] :
                    arrayList[j].append(word);

                if nextWord not in arrayList[j] :
                    arrayList[j].append(nextWord);

        for i in range(0, len(arrayList)) :
            if (len(arrayList[i]) > 1) :
                tempList = arrayList[i];
                for k in range (0, len(tempList) - 1) :
                    w1 = tempList[k];
                    w2 = tempList[k + 1];

                    l = len(w2);
                    if len(w1) < len(w2) :
                        l = len(w1);
                    
                    for k in range (0, l) :
                        if (w1[k] == w2[k]) :
                            pass;

                        else :
                            if w1[k] not in temp and w2[k] not in temp :
                                pass;
                            
                            elif w1[k] not in temp and w2[k] in temp :
                                print "elif 1 before : " + temp;
                                a = temp.find(w2[k]);
                                temp = temp[:a] + w1[k] + temp[a:];
                                print "elif 1 after : " + temp;
                                
                            elif w1[k] in temp and w2[k] not in temp :
                                print "elif 2 before : " + temp;
                                a = temp.find(w1[k]);
                                temp = temp[:a + 1] + w2[k] + temp[a + 1:];
                                print "elif 2 after : " + temp;
                                
                            else :
                                pass;    
                                
        print arrayList;
        return temp;
    
    else : 
        #print "first else";
        for word in words :
            if not word[0] in temp :
                temp = temp + word[0];
        
        return temp;
    
    return j;

print answer(['c', 'cac', 'cb', 'bcc', 'ba']);

'''
Minglish lesson
===============
Welcome to the lab, minion. Henceforth you shall do the bidding of Professor Boolean. Some say he's mad, trying to develop a zombie serum and all... but we think he's brilliant! 

First things first - Minions don't speak English, we speak Minglish. Use the Minglish dictionary to learn! The first thing you'll learn is how to use the dictionary.

Open the dictionary. Read the page numbers, figure out which pages come before others. You recognize the same letters used in English, but the order of letters is completely different in Minglish than English (a < b < c < ...).

Given a sorted list of dictionary words (you know they are sorted because you can read the page numbers), can you find the alphabetical order of the Minglish alphabet? For example, if the words were ["z", "yx", "yz"] the alphabetical order would be "xzy," which means x < z < y. The first two words tell you that z < y, and the last two words tell you that x < z.

Write a function answer(words) which, given a list of words sorted alphabetically in the Minglish alphabet, outputs a string that contains each letter present in the list of words exactly once; the order of the letters in the output must follow the order of letters in the Minglish alphabet. 

The list will contain at least 1 and no more than 50 words, and each word will consist of at least 1 and no more than 50 lowercase letters [a-z]. It is guaranteed that a total ordering can be developed from the input provided (i.e. given any two distinct letters, you can tell which is greater), and so the answer will exist and be unique.

Languages
=========

To provide a Python solution, edit solution.py
To provide a Java solution, edit solution.java

Test cases
==========

Inputs:
    (string list) words = ["y", "z", "xy"]
Output:
    (string) "yzx"

Inputs:
    (string list) words = ["ba", "ab", "cb"]
Output:
    (string) "bac"
'''