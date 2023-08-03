import sys

n = int(sys.stdin.readline().strip())
cache = list(-1 for i in range(n+1))
cache[0]=1
def recur(idx):
    if idx <0:
        return 0
    
    if cache[idx] != -1:
        return cache[idx]
    
    tmp = 3* recur(idx-2)
    for i in range(idx-4,-1,-2):
        tmp += 2* recur(i)
    cache[idx] = tmp
    return tmp
recur(n)
print(cache[n])