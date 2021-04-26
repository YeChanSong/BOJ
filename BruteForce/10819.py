import sys

N = int(sys.stdin.readline().strip())
li = sorted(map(int,sys.stdin.readline().split()))
perm = list()
used = list(False for i in range(N))
mx = -987654321
def recur(idx):
    global N,mx
    if idx == N:
        tmp = 0
        for i in range(N-1):
            tmp+=abs(perm[i]-perm[i+1])
        mx = max(mx,tmp)
        return
    for i in range(N):
        if used[i]:
            continue
        used[i] = True
        perm.append(li[i])
        recur(idx+1)
        used[i]=False
        perm.pop()
recur(0)
print(mx)