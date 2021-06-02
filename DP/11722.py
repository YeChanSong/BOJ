import sys

n = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().split()))
cache = list(-1 for i in range(n))

def recur(idx):
    global cache, li, n
    
    if idx == n:
        return 0
    
    if cache[idx] != -1:
        return cache[idx]
    
    tmp = 0
    for i in range(idx+1,n):
        if li[i]<li[idx]:
            tmp = max(tmp,recur(i))
    tmp +=1
    cache[idx] = tmp
    return tmp
for i in range(n):
    recur(i)
print(max(cache))
