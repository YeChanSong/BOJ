import sys

N = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().strip().split()))
cache = list(-1 for i in range(N))

def recur(idx):
    if idx == N:
        return 0
    if cache[idx] != -1:
        return cache[idx]
    
    tmp =0
    for i in range(idx+1,N):
        if li[i]>li[idx]:
            tmp = max(tmp,recur(i))
    tmp +=1
    cache[idx] = tmp
    return tmp

for i in range(N):
    if cache[i]==-1:
        recur(i)

print(max(cache))