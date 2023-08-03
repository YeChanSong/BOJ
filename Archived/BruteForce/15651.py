import sys

N,M = map(int,sys.stdin.readline().strip().split())
li = list(i for i in range(1,N+1))
def recur(idx, hist):
    if len(hist) == M:
        print(' '.join(map(str,hist)))
        return
    for i in range(0,N):
        tmp = hist.copy()
        tmp.append(li[i])
        recur(i,tmp)

recur(0,list())