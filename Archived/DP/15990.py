import sys
sys.setrecursionlimit(1000000)
T = int(sys.stdin.readline().strip())
cache = list(list(-1 for i in range(100001)) for i in range(3))
def recur(idx, bef):
    global cache
    
    if idx <0:
        return 0
    if idx == 0:
        return 1

    if cache[bef-1][idx] != -1:
        return cache[bef-1][idx]

    tmp = 0
    for i in range(1,4):
        if bef == i:
            continue
        tmp += recur(idx-i,i)%1000000009
        tmp %=1000000009
    cache[bef-1][idx] = tmp
    return tmp

for  i in range(T):
    N = int(sys.stdin.readline().strip())
    
    a=recur(N-1,1)%1000000009
    b=recur(N-2,2)%1000000009
    c=recur(N-3,3)%1000000009
    print((a+b+c)%1000000009)