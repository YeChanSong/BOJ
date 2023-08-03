import sys, collections

N,K = map(int,sys.stdin.readline().split())
dist = list(-1 for i in range(100001))
before = list(-1 for i in range(100001))

def bfs():
    global N,K, dist, before
    q = collections.deque()
    q.append(N)
    dist[N] = 0
    before[N] = N
    while q:
        itm = q.popleft()
        
        if itm == K:
            break
        
        if itm*2<100001 and dist[itm*2] == -1:
            q.append(itm*2)
            dist[itm*2] = dist[itm]+1
            before[itm*2] = itm
        if itm+1<100001 and dist[itm+1] == -1:
            q.append(itm+1)
            dist[itm+1] = dist[itm]+1
            before[itm+1] = itm
        if itm-1 >= 0 and dist[itm-1] == -1:
            q.append(itm-1)
            dist[itm-1] = dist[itm]+1
            before[itm-1] = itm
bfs()
print(dist[K])
idx = K
hist = list()
while not (idx == N):
    hist.append(idx)
    idx = before[idx]
hist.append(N)
hist.reverse()
print(' '.join(map(str,hist)))