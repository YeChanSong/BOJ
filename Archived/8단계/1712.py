import sys

A,B,C = map(int,sys.stdin.readline().strip().split())
prof = C-B
if prof <= 0:
    print(-1)
else:
    cnt = A // prof
    print(cnt+1)
