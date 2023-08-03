import sys

N = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().split()))
cache = list(-1 for i in range(N))

def recur(idx):
    global cache, li, N
    
    if cache[idx] != -1:
        return cache[idx]

    tmp = 0
    for i in range(idx+1,N):
        if li[idx]<li[i]:
            tmp = max(tmp,recur(i))
    tmp += li[idx]
    cache[idx] = tmp
    return tmp
for i in range(N):
    recur(i)
print(max(cache))