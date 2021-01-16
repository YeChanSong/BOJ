import sys, collections

'''
양방향 탐색은 역방향 간선의 수가 많은 경우 사용하지 말자.
IDS는 메모리는 적게 써도 시간초과가 발생한다.
'''

def bfs():
    global s,d,distance

    q = collections.deque()
    q.append(s)
    distance[s] = 0
    
    while len(q):
        itm = q.popleft()
        if itm+1<100001 and distance[itm+1] == -1:
            q.append(itm+1)
            distance[itm+1] = distance[itm]+1
        if itm-1>=0 and distance[itm-1] == -1:
            q.append(itm-1)
            distance[itm-1] = distance[itm]+1
        if itm*2 <100001 and distance[itm*2] == -1:
            q.append(itm*2)
            distance[itm*2] = distance[itm]+1
        
s,d = map(int,sys.stdin.readline().strip().split())
distance = list(-1 for i in range(100001))
bfs()
print(distance[d])