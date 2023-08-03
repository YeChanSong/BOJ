import sys
sys.setrecursionlimit(100000)
def recur(idx,color):
    global cache, cost
    
    if idx == 1:
        cache[idx][color] = cost[idx-1][color]
        return cost[idx-1][color]

    if cache[idx][color] != None:
        return cache[idx][color]
    
    colors = [i for i in range(3)]
    colors.remove(color)
    tmp = min(recur(idx-1,colors[0]) ,recur(idx-1,colors[1])) + cost[idx-1][color]
    cache[idx][color] = tmp
    return tmp


N = int(sys.stdin.readline().strip())
cost = []
for i in range(N):
    cost.append(list(map(int,sys.stdin.readline().strip().split())))

cache = [[None,None,None] for i in range(N+1)] # R G B
ans = min(recur(N,0),recur(N,1),recur(N,2))
print(ans)
