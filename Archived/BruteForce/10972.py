import sys

N = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().split()))
cmp = sorted(li,reverse=True)
if li == cmp:
    print(-1)
    sys.exit()
tmp = N-1
s,d = -1,-1
for i in range(tmp,0,-1):
    if li[i] > li[i-1]:
        s = i-1
        break
if s == -1:
    s = N-1
for i in range(tmp,-1,-1):
    if li[i]>li[s]:
        d = i
        break
if d == -1:
    d = s-1
li[d],li[s] = li[s],li[d]
li[s+1:] = li[N-1:s:-1]
print(' '.join(map(str,li)))