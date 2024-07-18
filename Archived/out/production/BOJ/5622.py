import sys
sys.setrecursionlimit(1000000)

def recur(init,idx,dl):
    if len(init) == idx:
        return 0
    
    tmp = -1
    for i in dl:
        if init[idx] in i:
            tmp = dl.index(i)
            break
    return tmp + 1 + recur(init,idx+1,dl)
    

init = sys.stdin.readline().strip()
dl = ['','','ABC','DEF','GHI','JKL','MNO','PQRS','TUV','WXYZ']
print(recur(init,0,dl))
