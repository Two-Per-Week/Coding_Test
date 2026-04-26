def solution(d, budget):
    answer = 0
    
    d.sort()
    d.append(0)
    
    for i in range(len(d) - 1):
        if d[i] <= budget:
            answer = i + 1
        else:
            break
    
        d[i + 1] += d[i]
        
    return answer
