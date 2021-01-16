import sys, collections

def bfs():
    global s,d, distance, dist
    q = collections.deque()
    q.append(s)
    q.append(d)
    distance[s] = 1
    distance[d] = -1
    mx, mn = 2*d-s+1, 0
    while len(q):
        itm = q.popleft()
        adder = distance[itm]<0 and distance[itm]-1 or distance[itm]+1
        if adder >0:
            x=[itm,1,-1]
            
        else:
            if itm%2==0 and itm != 0:
                q.append(itm//2)
                if distance[itm//2] == 0:
                    distance[itm//2] = adder
                elif distance[itm//2]*distance[itm] <0:
                    dist = abs(distance[itm//2]) + abs(distance[itm])
                    return
            x=[-1,1]
            
        for i in x:
            if mn<=itm+i<mx:
                q.append(itm+i)
                if distance[itm+i] == 0:
                    distance[itm+i] = adder
                elif distance[itm+i] * distance[itm] <0:
                    dist = abs(distance[itm+i]) + abs(distance[itm])
                    return 
                
global s,d, distance, dist
s,d = map(int,sys.stdin.readline().strip().split())
mx = d-s+1
dist = 0
distance = list(0 for i in range(0,mx+d))
if s == d:
    print(0)
else:
    if s > d:
        print(s-d)
    else:
        bfs()
        print(dist-1)