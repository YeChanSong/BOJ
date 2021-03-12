import sys

def recur(idx,curr):
    
    if cache[idx][curr] != -1:
        return cache[idx][curr]
    
    if curr == 1:
        ret = recur(idx+1,0)
    else:
        ret = recur(idx+1,1) + recur(idx+1,0)
    cache[idx][curr] = ret
    return ret

N = int(sys.stdin.readline().strip())
cache = list([-1,-1] for i in range(N))
cache[N-1] = [1,1]
ans = recur(0,1)
print(ans)