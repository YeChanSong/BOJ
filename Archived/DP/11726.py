import sys
sys.setrecursionlimit(1004)

def recur(idx,lim):
    if idx>lim:
        return 0
    
    if cache[idx] != -1:
        return cache[idx]

    ret = recur(idx+1,lim)+recur(idx+2,lim)
    cache[idx] = ret
    return ret

n = int(sys.stdin.readline().strip())
cache = list(-1 for i in range(n+1))
cache[n] = 1
ans = recur(0,n)%10007
print(ans)
