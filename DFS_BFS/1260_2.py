import sys, collections

N,M,V = map(int,sys.stdin.readline().split())
adj = list([] for i in range(N))
tmp_adj = list()
for i in range(M):
    s,d = map(int,sys.stdin.readline().split())
    tmp_adj.append((s-1,d-1))
    tmp_adj.append((d-1,s-1))
tmp_adj.sort(key=lambda x:(x[0],x[1]))
for s,d in tmp_adj:
    adj[s].append(d)

visited = list(False for i in range(N))
dfs_hist = list()
def dfs(idx):
    global adj,visited,dfs_hist
    
    visited[idx] = True
    dfs_hist.append(idx+1)
    
    for i in adj[idx]:
        if visited[i] == True:
            continue
        dfs(i)
dfs(V-1)
print(' '.join(map(str,dfs_hist)))
dist = list(-1 for i in range(N))
bfs_hist = list()
def bfs(idx):
    global adj,dist,bfs_hist
    q = collections.deque()
    
    q.append(idx)
    dist[idx] = 0
    
    while q:
        itm = q.popleft()
        bfs_hist.append(itm+1)
        for i in adj[itm]:
            if dist[i] != -1:
                continue
            q.append(i)
            dist[i] = dist[itm]+1
bfs(V-1)
print(' '.join(map(str,bfs_hist)))