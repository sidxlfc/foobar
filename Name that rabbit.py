import operator

test = {}
values = {
    'a' : 1,
    'b' : 2,
    'c' : 3,
    'd' : 4,
    'e' : 5,
    'f' : 6,
    'g' : 7,
    'h' : 8,
    'i' : 9,
    'j' : 10,
    'k' : 11,
    'l' : 12,
    'm' : 13,
    'n' : 14,
    'o' : 15,
    'p' : 16,
    'q' : 17,
    'r' : 18,
    's' : 29,
    't' : 20,
    'u' : 21,
    'v' : 22,
    'w' : 23,
    'x' : 24,
    'y' : 25,
    'z' : 26
}

def lexo(sx, p, counter):
    
    temp = []
    for i in range(p, p + counter) :
        temp.append(sx[i])
        
    print "temp ", temp
    temp.sort()
    
    t = len(temp) - 1
    
    for i in range(p, p + counter) :
       sx[i] = temp[t]
       t -= 1

def find_value(st):
    value = 0
    #print "in find_value ", test
    for i in range(0, len(st)):
        value += values[st[i]]
    
    test[st] = value    
    
def answer(names):
    
    for i in range(0, len(names)):
        #print names[i]
        find_value(names[i])
    
    #print "before sort", test    
    sorted_x = sorted(test.items(), key=operator.itemgetter(1))
    #print "after sort", test
    
    for i in range(0, len(names) - 1) :
        (j, k) = sorted_x[i]
        (x, y) = sorted_x[i + 1]
        if k==y:
            counter = 0
            c = 0
            for c in range(i, len(sorted_x)):
                    (x, y) = sorted_x[c]
                    if k==y:
                        counter+=1
            lexo(sorted_x, i, counter)
            i+=counter
            print "counter = ", counter
            print "i = ", i
            print sorted_x
            
    #print(sorted_x)
    
    for i in range(0, len(names)):
        (j, k) = sorted_x[len(names) - i - 1]
        print sorted_x[i]
        names[i] = j
    
    print names

names = ["annie", "by", "zab", "liz", "aac", "al", "bonnie", "yaab", "cj", "aba", "xoxo","cba", "azb", "o", "kl", "acb","abb", "abz", "aaaaa", "a", "ab", "ba"]
answer(names) 