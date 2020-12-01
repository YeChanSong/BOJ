import sys

def rptr(idx,N):
    n = str(idx)
    tmp = idx
    for i in range(len(n)):
        tmp += int(n[i])
    if tmp == N:
        return idx

N = int(sys.stdin.readline().strip())
ans = None
for i in range(1,N+1):
    ans = rptr(i,N)
    if ans != None:
        break
if ans == None:
    ans = 0
print(ans)
