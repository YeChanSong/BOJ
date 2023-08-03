import sys

N,M = map(int,sys.stdin.readline().split())
adj = list([] for i in range(N))
for i in range(M):
    s,d = map(int,sys.stdin.readline().split())
    adj[s].append(d)
    adj[d].append(s)

def dfsall():
    global visited, hist
    visited = list()
    hist = list()
    for i in range(N):
        visited = list(False for i in range(N))
        hist = list()
        dfs(i,0)

def dfs(idx, dpth):
    global visited
    visited[idx] = True
    if dpth == 4:
        print(1)
        sys.exit()

    for i in adj[idx]:
        if visited[i]:
            continue
        dfs(i,dpth+1)
    visited[idx] = False
    hist.append(idx)
dfsall()
print(0)