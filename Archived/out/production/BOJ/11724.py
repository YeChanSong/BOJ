import sys
sys.setrecursionlimit(1000000)
N,M = map(int,sys.stdin.readline().split())
adj = list([] for i in range(N))
visited = list(False for i in range(N))
cnt = 0
for i in range(M):
    s,d = map(int,sys.stdin.readline().split())
    adj[s-1].append(d-1)
    adj[d-1].append(s-1)

def dfsall():
    global adj, cnt
    for i in range(N):
        if visited[i]:
            continue
        dfs(i)
        cnt+=1
        
def dfs(idx):
    global adj, visited
    visited[idx] = True
    
    for i in adj[idx]:
        if visited[i]:
            continue
        dfs(i)
dfsall()
print(cnt)