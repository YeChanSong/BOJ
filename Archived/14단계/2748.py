import sys

def recur(idx):
    global cache
    
    if cache[idx] != None:
        return cache[idx]

    tmp = recur(idx-1) + recur(idx-2)
    cache[idx] = tmp
    
    return tmp

N = int(sys.stdin.readline().strip())
cache = [None for i in range(N+1)]
cache[0] = 0
cache[1] = 1
ans = recur(N)
print(ans)