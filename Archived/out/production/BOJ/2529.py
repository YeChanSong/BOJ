import sys

K = int(sys.stdin.readline().strip())
A = list(sys.stdin.readline().split())
mn, mx = '987654321','-987654321'
used = list(False for i in range(10))
def recur(idx,hist):
    global mn,mx
    if idx==K:
        if hist<mn:
            mn = hist
        if hist>mx:
            mx = hist
        return
    for i in range(10):
        tmp = str(i)
        if used[i]:
            continue
        if len(hist)==0:
            used[i] = True
            recur(idx+1,hist+tmp)
            used[i] = False
            continue
        
        if A[idx] == '<' and hist[idx] < tmp:
            used[i] = True
            recur(idx+1,hist+tmp)
            used[i] = False
            continue
        if A[idx] == '>' and hist[idx] > tmp:
            used[i] = True
            recur(idx+1,hist+tmp)
            used[i] = False
            continue
    
recur(-1,'')
print(mx)
print(mn)