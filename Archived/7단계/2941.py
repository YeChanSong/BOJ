import sys
sys.setrecursionlimit(1000000)

def recur(init,idx,dic):
    if len(init) == idx:
        return 0
    cnt = 0
    tmp = 0
    for i in dic:
        if init[idx:idx+len(i)] == i:
            cnt +=1
            tmp = len(i)
            break
    if cnt == 0:
        cnt = 1
        tmp = 1
    return cnt + recur(init,idx+tmp,dic)
    

init = sys.stdin.readline().strip()
dic = ['c=','c-','dz=','d-','lj','nj','s=','z=']
print(recur(init,0,dic))
