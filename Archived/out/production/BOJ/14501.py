import sys

N = int(sys.stdin.readline().strip())
li = list()
for i in range(N):
    li.append(list(map(int,sys.stdin.readline().split())))

cache = list(-1 for i in range(N))
def recur(idx):
    if idx + li[idx][0] -1 >= N:
        return 0
    if cache[idx] != -1:
        return cache[idx]
    tmp = 0
    for i in range(idx+li[idx][0],N):
        tmp = max(tmp,recur(i))
    cache[idx] = tmp + li[idx][1]
    return cache[idx]
    
for i in range(N):
    if cache[i]==-1:
        recur(i)
print(max(max(cache),0))