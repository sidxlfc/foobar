def answer(x):
    
    sum = 0
    for i in range(0, len(x)) :
        sum += x[i]
        
    if sum % len(x) == 0 :
        return len(x)

    else :
        return len(x) - 1