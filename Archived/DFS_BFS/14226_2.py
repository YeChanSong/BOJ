import sys, collections

S = int(sys.stdin.readline().strip())

def bfs():
    global S
    q = collections.deque()
    MAX = 10**300
    times = list(list(MAX for i in range(S+1)) for j in range(S+1))
    q.append((1,0)); times[1][0] = 0
    
    while q:
        itm = q.popleft()
        
        if itm[0] == S:
            break
        
        if itm[0] != itm[1] and times[itm[0]][itm[0]] == MAX:
            q.append((itm[0],itm[0]))
            times[itm[0]][itm[0]] = times[itm[0]][itm[1]] +1
        
        if itm[1]!=0 and itm[0]+itm[1]<=S and times[itm[0]+itm[1]][itm[1]] == MAX:
            q.append((itm[0]+itm[1],itm[1]))
            times[itm[0]+itm[1]][itm[1]] = times[itm[0]][itm[1]] +1
        
        if itm[0]>1 and times[itm[0]-1][itm[1]] == MAX:
            q.append((itm[0]-1,itm[1]))
            times[itm[0]-1][itm[1]] = times[itm[0]][itm[1]] +1

    print(min(times[S]))
bfs()