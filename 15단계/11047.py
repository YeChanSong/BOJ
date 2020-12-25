import sys

def recur(idx,left):
    global li, cnt
    
    if left == 0 or idx < 0:
        return
    
    if li[idx] > left:
        recur(idx-1,left)
    else:
        tmp = left
        a = tmp // li[idx]
        tmp %= li[idx]
        cnt += a
        recur(idx-1,tmp)

N, K = map(int,sys.stdin.readline().strip().split())
li = []
for i in range(N):
    li.append(int(sys.stdin.readline().strip()))
cnt = 0
recur(N-1,K)
print(cnt)