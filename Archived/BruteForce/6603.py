import sys

init = list(map(int,sys.stdin.readline().split()))
def recur(idx,cnt):
    global K,S,used
    if cnt == 6:
        tmp = list()
        for i in range(K):
            if used[i]:
                tmp.append(str(S[i]))
        print(' '.join(tmp))
    
    for i in range(idx,K):
        if used[i]:
            continue
        used[i] = True
        recur(i,cnt+1)
        used[i] = False
    
while init[0]:
    K = init[0]; S = init[1:]
    used = list(False for i in range(K))
    recur(0,0)
    print()
    init = list(map(int,sys.stdin.readline().split()))
