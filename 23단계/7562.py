import sys, collections

def bfs():
    global l,src,dst,distance
    x = [2,2,1,1,-1,-1,-2,-2]
    y = [1,-1,2,-2,2,-2,1,-1]
    
    if src == dst:
        return 0
    
    q = collections.deque()
    q.append(src)
    distance[src[0]][src[1]] = 0
    
    while len(q):
        itm = q.popleft()
        cost = distance[itm[0]][itm[1]]
        for i in range(8):
            if not(0<=itm[0]+y[i]<l and 0<=itm[1]+x[i]<l):
                continue
            
            if (itm[0]+y[i],itm[1]+x[i]) == dst:
                return cost +1
            
            if distance[itm[0]+y[i]][itm[1]+x[i]] == -1:
                q.append((itm[0]+y[i],itm[1]+x[i]))
                distance[itm[0]+y[i]][itm[1]+x[i]] = cost+1
            

T = int(sys.stdin.readline().strip())
for i in range(T):
    global l,src,dst,distance
    l = int(sys.stdin.readline().strip())
    distance = list([-1 for i in range(l)] for j in range(l))
    src = tuple(map(int,sys.stdin.readline().strip().split()))
    dst = tuple(map(int,sys.stdin.readline().strip().split()))
    ans = bfs()
    print(ans)