import sys

N,M = map(int,sys.stdin.readline().strip().split())
numList = list(i for i in range(1,N+1))
def recur(idx, hist):
    if idx == M:
        print(' '.join(map(str,hist)))
        return
    for i in numList:
        if len(hist) > 0 and i in hist:
            continue
        tmp = hist.copy()
        tmp.append(i)
        recur(idx+1,tmp)

recur(0,[])