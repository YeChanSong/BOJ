#pypy3
import sys, collections

class State:
    board = list()
    N = 0
    M = 0
    def __init__(self,y=0,x=0,cnt=0):
        self.cnt = cnt
        self.pos = (y,x)
    def isOver(self):
        return self.pos[0] == State.N-1 and self.pos[1] == State.M-1
    def __eq__(self,target):
        return self.pos == target.pos and self.cnt == target.cnt
    def __hash__(self):
        return hash((self.pos, self.cnt))

def bfs(st):
    global Statemap
    if st.isOver():
        return 1
    q = collections.deque()
    q.append(st)
    Statemap.setdefault(st,1)
    x = [1,-1,0,0]
    y = [0,0,1,-1]
    while len(q):
        itm = q.popleft()
        cost = Statemap[itm]
        for i in range(4):
            if not (0<=itm.pos[0]+y[i]<State.N and 0<=itm.pos[1]+x[i]<State.M):
                continue
            if State.board[itm.pos[0]+y[i]][itm.pos[1]+x[i]] == '1':
                if itm.cnt == 0:
                    continue
                else:
                    tmp = State(itm.pos[0]+y[i],itm.pos[1]+x[i],0)      
            else:
                tmp = State(itm.pos[0]+y[i],itm.pos[1]+x[i],itm.cnt)
            
            if Statemap.get(tmp) != None:
                continue
            if tmp.isOver():
                return cost+1
            q.append(tmp)
            Statemap.setdefault(tmp,cost+1)
    return -1

State.N, State.M = map(int,sys.stdin.readline().strip().split())
for i in range(State.N):
    State.board.append(sys.stdin.readline().strip())
st = State(0,0,1)
Statemap = dict()
ans = 0
ans = bfs(st)
print(ans)