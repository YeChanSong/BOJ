import sys

def dfsall():
    global start, ops, visited, alist
    for i in range(len(ops)):
        if start[i] == True:
            continue
        visited = [False for i in range(len(ops))]
        start[i] = True
        dfs(i,1,alist[0])

def dfs(idx,cnt,acc):
    global mx, mn, ops, alist, visited
    
    if visited[idx] == True:
        return
        
    visited[idx] = True
    
    tmp = acc
    if ops[idx] == 0:
        tmp += alist[cnt]
    elif ops[idx] == 1:
        tmp -= alist[cnt]
    elif ops[idx] == 2:
        tmp *= alist[cnt]
    else:
        if tmp <0:
            ttmp = abs(tmp)
            ttmp = ttmp // alist[cnt]
            tmp = ttmp * (-1)
        else:
            tmp //= alist[cnt]
    
    if cnt == len(ops):
        if tmp > mx:
            mx = tmp
        if tmp < mn:
            mn = tmp
        visited[idx] = False
        return

    for i in range(len(ops)):
        
        if i == idx or visited[i] == True:
            continue
        dfs(i, cnt+1,tmp)
    visited[idx] = False


N = int(sys.stdin.readline().strip())
alist = list(map(int,sys.stdin.readline().strip().split()))
init = list(map(int,sys.stdin.readline().strip().split()))
ops = []
for i in range(len(init)):
    if i == 0: # +
        for j in range(init[i]):
            ops.append(0)
        continue
    if i == 1: # -
        for j in range(init[i]):
            ops.append(1)
        continue
    if i == 2: # x
        for j in range(init[i]):
            ops.append(2)
        continue
    if i == 3: # //
        for j in range(init[i]):
            ops.append(3)
        continue
#cases = set(itertools.permutations(ops,len(ops)))
mx, mn = -987654321, 987654321
start = [False for i in range(len(ops))]
dfsall()
print(mx,mn)