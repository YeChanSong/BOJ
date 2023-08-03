import sys


def recur(y,x,cnt):
    global cache, triangle

    if cnt == len(triangle):
        return 0

    if cache[y][x] != None:
        return cache[y][x]
    
    tmp = max(recur(y+1,x,cnt+1), recur(y+1,x+1,cnt+1)) + triangle[y][x]
    cache[y][x] = tmp
    return tmp

N = int(sys.stdin.readline().strip())
triangle = list()
cache = []
for i in range(N):
    triangle.append(list(map(int,sys.stdin.readline().strip().split())))
    cache.append([None for i in range(len(triangle[i]))])
ans = recur(0,0,0)
print(ans)