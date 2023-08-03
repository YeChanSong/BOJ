import sys

N = int(sys.stdin.readline().strip())
perm = list()
used = list(False for i in range(N+1))
def recur(idx):
    global N
    if idx == N+1:
        print(' '.join(map(str,perm)))
        return
    for i in range(1,N+1):
        if used[i]:
            continue
        used[i] = True
        perm.append(i)
        recur(idx+1)
        used[i]=False
        perm.pop()
recur(1)