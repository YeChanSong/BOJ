import sys
sys.setrecursionlimit(100001)

def recur(idx,cnt):
    global cache, wines
    
    if idx >= len(wines):
        return 0
    
    if cnt == 1:
        if cache[idx][0] != None:
            return cache[idx][0]
        
        tmp = wines[idx] + max(recur(idx+1, 2),recur(idx+2, 1), recur(idx+3, 1))
        cache[idx][0] = tmp
        return tmp
    
    else:
        if cache[idx][1] != None:
            return cache[idx][1]
        
        tmp = wines[idx] + max(recur(idx+2,1), recur(idx+3,1))
        cache[idx][1] = tmp
        return tmp
    
N = int(sys.stdin.readline().strip())
wines = []
for i in range(N):
    wines.append(int(sys.stdin.readline().strip()))
cache = list([None, None] for i in range(N))
ans = max(recur(0,1), recur(1,1))

print(ans)