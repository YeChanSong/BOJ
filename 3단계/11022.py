import sys
c = int(sys.stdin.readline().strip())
for i in range(c):
    a,b = map(int,sys.stdin.readline().strip().split())
    print("Case #%d: %d + %d = %d"%(i+1,a,b,a+b))
