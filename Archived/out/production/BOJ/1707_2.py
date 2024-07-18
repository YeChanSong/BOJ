import sys
sys.setrecursionlimit(200000)
T = int(sys.stdin.readline().strip())

def dfsall():
    global adj,where, V,E, flag
    flag = False
    for i in range(V):
        if where[i] == -1:
            where[i] = 0
            dfs(i)
            if flag:
                return
    print("YES")

def dfs(idx):
    global adj,where,V,E, flag
    here = where[idx]
    for i in adj[idx]:
        if flag:
            return
        if where[i] == -1:
            where[i] = 1-here
            dfs(i)
        elif where[i]==here:
            print("NO")
            flag = True
            return

for i in range(T):
    V,E = map(int, sys.stdin.readline().split())
    adj = list([] for i in range(V))
    where = list(-1 for i in range(V))
    for i in range(E):
        s,d = map(int,sys.stdin.readline().split())
        adj[s-1].append(d-1)
        adj[d-1].append(s-1)
    dfsall()
