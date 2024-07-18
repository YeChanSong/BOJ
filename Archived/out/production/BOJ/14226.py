import sys, collections

N = int(sys.stdin.readline().strip())
cache = list([987654321 for i in range(N+1)] for j in range(N+1))

def bfs():
    global cache
    
    q = collections.deque()
    q.append((1,0))
    cache[1][0] = 0

    while q:
        itm = q.popleft()
        
        if cache[itm[0]][itm[0]] == 987654321:
            q.append((itm[0],itm[0]))
            cache[itm[0]][itm[0]] = cache[itm[0]][itm[1]]+1
        if itm[0]+itm[1] <N+1 and cache[itm[0]+itm[1]][itm[1]] == 987654321:
            q.append((itm[0]+itm[1],itm[1]))
            cache[itm[0]+itm[1]][itm[1]] = cache[itm[0]][itm[1]]+1
        if itm[0]-1>1 and cache[itm[0]-1][itm[1]] == 987654321:
            q.append((itm[0]-1,itm[1]))
            cache[itm[0]-1][itm[1]] = cache[itm[0]][itm[1]]+1
bfs()
print(min(cache[N]))
