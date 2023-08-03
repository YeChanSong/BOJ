import sys, math
sys.setrecursionlimit(100000)

def recur(idx):
    global A,C
    if idx == 0:
        return 1
    
    if idx %2 == 1:
        return (int(A)%int(C) * recur(idx-1)%int(C)) % int(C)
    res = recur(idx//2)%int(C)
    return (res * res) % int(C)

A,B,C = sys.stdin.readline().strip().split()
ans = recur(int(B))
print(ans)