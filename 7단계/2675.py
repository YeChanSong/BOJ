import sys
sys.setrecursionlimit(1000000)

def recur(init,times,idx):
    if idx == len(init):
        return ''
    return init[idx]*times + recur(init,times,idx+1)

C = int(sys.stdin.readline().strip())
for i in range(C):
    R, S = sys.stdin.readline().strip().split()
    print(recur(S,int(R),0))
