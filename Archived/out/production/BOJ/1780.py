import sys
sys.setrecursionlimit(100000)

def recur(y,x,ylim,xlim):
    global N,li, cntr
    
    if ylim == 1:
        return li[y][x]
    ans = list(0 for i in range(9))
    # -1 0 1 --> 0 1 2
    
    ans[0] = recur(y,x,ylim//3,xlim//3)+1
    ans[1] = recur(y,x+xlim//3,ylim//3,xlim//3)+1
    ans[2] = recur(y,x+2*xlim//3,ylim//3,xlim//3)+1
    ans[3] = recur(y+ylim//3,x,ylim//3,xlim//3)+1
    ans[4] = recur(y+ylim//3,x+xlim//3,ylim//3,xlim//3)+1
    ans[5] = recur(y+ylim//3,x+2*xlim//3,ylim//3,xlim//3)+1
    ans[6] = recur(y+2*ylim//3,x,ylim//3,xlim//3)+1
    ans[7] = recur(y+2*ylim//3,x+xlim//3,ylim//3,xlim//3)+1
    ans[8] = recur(y+2*ylim//3,x+2*xlim//3,ylim//3,xlim//3)+1

    if ans[0]==ans[1]==ans[2]==ans[3]==ans[4]==ans[5]==ans[6]==ans[7]==ans[8]:
        if N == ylim:
            cntr[ans[0]] += 1
        return ans[0]-1
    for i in range(9):
        cntr[ans[i]] +=1
    return 2
    
N = int(sys.stdin.readline().strip())
li = list()
cntr = [0,0,0,0]
for i in range(N):
    li.append(list(map(int,sys.stdin.readline().strip().split())))
recur(0,0,N,N)
for i in range(3):
    print(cntr[i])