import sys

N = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().split()))
cache = list(-1 for i in range(N+1))
cache[0] =0

def recur(idx):
    global cache, li
    
    if cache[idx] != -1:
        return cache[idx]
    
    tmp = li[idx-1]
    for i in range(1,N):
        if idx-i<0:
            continue
        tmp = max(tmp,recur(idx-i)+li[i-1])
    cache[idx] = tmp
    return tmp

recur(N)
print(cache[N])
