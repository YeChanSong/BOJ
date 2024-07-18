import sys
sys.setrecursionlimit(10000)

def recur(idx):
    
    if idx>N:
        return 0
    
    if cache[idx] != -1:
        return cache[idx]
    
    ret = recur(idx+1) + 2*recur(idx+2)
    cache[idx] = ret
    return ret

N = int(sys.stdin.readline().strip())
cache = list(-1 for i in range(N+1))
cache[N] = 1
ans = recur(0)%10007
print(ans)
