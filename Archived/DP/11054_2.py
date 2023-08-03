import sys

n = int(sys.stdin.readline().strip())
li = list(map(int,sys.stdin.readline().split()))
LLDS = list(-1 for i in range(n)); RLDS = list(-1 for i in range(n))
ttl = list(0 for i in range(n))
def lrecur(idx):
    global n,li,LLDS
    
    if idx == n:
        return 0
    
    if LLDS[idx] != -1:
        return LLDS[idx]
    
    tmp = 0
    for i in range(idx+1,n):
        if li[i]<li[idx]:
            tmp = max(tmp,lrecur(i))
    tmp += 1
    LLDS[idx] = tmp
    return tmp

def rrecur(idx):
    global n,li,RLDS
    
    if idx == -1:
        return 0
    if RLDS[idx] != -1:
        return RLDS[idx]
    
    tmp = 0
    for i in range(idx-1,-1,-1):
        if li[i]<li[idx]:
            tmp = max(tmp,rrecur(i))
    tmp += 1
    RLDS[idx] = tmp
    return tmp

for i in range(n):
    lrecur(i)
    rrecur(i)
for i in range(n):
    ttl[i] = LLDS[i]+RLDS[i]-1
print(max(ttl))