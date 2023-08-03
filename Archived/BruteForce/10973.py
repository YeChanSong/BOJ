import sys

N = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().split()))
s,d = -1,-1
for i in range(N-1,0,-1):
    if li[i]<=li[i-1]:
        s = i-1
        break
if s == -1:
    print(-1)
    sys.exit()
for i in range(s+1,N):
    if li[i]<li[s]:
        d = i
    else:
        break

li[s],li[d] = li[d],li[s]
li[s+1:] = li[N-1:s:-1]
print(' '.join(map(str,li)))
