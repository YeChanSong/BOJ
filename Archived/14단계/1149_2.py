import sys
sys.setrecursionlimit(10000)
def recur(color, idx):
    global N, cost, cache
    
    if idx == N:
        return 0

    if cache[idx][color] != -1:
        return cache[idx][color]

    tmp = 10000000
    for i in range(3):
        if i == color:
            continue
        tmp = min(tmp, recur(i,idx+1))

    tmp += cost[idx][color]
    cache[idx][color] = tmp
    return tmp

N = int(sys.stdin.readline().strip())
cost = list()
cache = list([-1,-1,-1] for i in range(N))
for i in range(N):
    cost.append(tuple(map(int,sys.stdin.readline().strip().split())))
recur(0,0)
recur(1,0)
recur(2,0)
ans = min(cache[0][0],cache[0][1],cache[0][2])
print(ans)