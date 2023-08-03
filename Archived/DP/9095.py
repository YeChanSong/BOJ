import sys

def recur(idx):
    global cache,N
    
    if idx <= 0:
        return 0
    
    if cache[idx] != -1:
        return cache[idx]

    total = 0
    total += recur(idx-1)
    total += recur(idx-2)
    total += recur(idx-3)
    cache[idx] = total
    return total

T = int(sys.stdin.readline().strip())
for i in range(T):
    cache = list(-1 for i in range(11))
    cache[1],cache[2],cache[3] = 1,2,4
    N = int(sys.stdin.readline().strip())
    ans = recur(N)
    print(ans)