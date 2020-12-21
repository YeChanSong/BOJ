import sys
sys.setrecursionlimit(100000)

def recur(y,x):
    global cache, a, b
    
    if cache[y][x] != None:
        return cache[y][x]
    
    if a[x-1] == b[y-1]:
        cache[y][x] = recur(y-1,x-1) + 1
    else:
        cache[y][x] = max(recur(y-1,x), recur(y,x-1))
    
    return cache[y][x]
    
a = sys.stdin.readline().strip()
b = sys.stdin.readline().strip()
cache = list([None for i in range(len(a)+1)] for j in range(len(b)+1))
cache[0] = [0 for i in range(len(a)+1)]
for i in cache:
    i[0] = 0
recur(len(b),len(a))
print(cache[len(b)][len(a)])