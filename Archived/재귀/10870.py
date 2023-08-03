import sys
sys.setrecursionlimit(10000000)

def recur(n):
    global cache
    if n == 0 or n == 1:
        cache[n] = n
        return n
    if cache[n] != None:
        return cache[n]
    
    tmp = recur(n-1) + recur(n-2)
    cache[n] = tmp
    return tmp

n = int(sys.stdin.readline().strip())
cache = [None for i in range(n+1)]
print(recur(n))
