import sys

N = int(sys.stdin.readline().strip())
cache = list(-1 for i in range(N+1))
def recur(idx):
    if idx<0:
        return 0
    if idx == 0:
        return 1
    
    if cache[idx] != -1:
        return cache[idx]
    
    tmp = recur(idx-2)*3
    for i in range(4,N+1,2):
        tmp += recur(idx-i)*2
    cache[idx] = tmp
    return tmp

recur(N)
print(cache[N])