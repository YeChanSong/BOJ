import sys,collections

N,K = map(int,sys.stdin.readline().strip().split())

def bfs():
    dist = list(-1 for i in range(200000))
    dist[N] = 0
    q = collections.deque()
    q.append(N)
    while q:
        itm = q.popleft()
        if itm == K:
            break
        if itm*2<200000 and dist[itm*2]==-1:
            q.append(itm*2)
            dist[itm*2] = dist[itm]+1
        if itm+1<200000 and dist[itm+1]==-1:
            q.append(itm+1)
            dist[itm+1] = dist[itm]+1
        if itm-1>=0 and dist[itm-1]==-1:
            q.append(itm-1)
            dist[itm-1] = dist[itm]+1
    print(dist[K])
bfs()
