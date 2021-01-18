import sys

N = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().strip().split()))
NGE = list(-1 for i in range(N))
stk = list()
stk.append((li[0],0))
for i in range(1,N):
    while len(stk):
        if stk[-1][0] < li[i]:
            tmp = stk.pop()
            NGE[tmp[1]] = li[i]
        else:
            break
    stk.append((li[i],i))     
print(' '.join(map(str,NGE)))