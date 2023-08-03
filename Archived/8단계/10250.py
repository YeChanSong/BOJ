import sys
c = int(sys.stdin.readline().strip())
for i in range(c):
    h,w,n = map(int,sys.stdin.readline().strip().split())
    y,x = 0,0
    a,b = n//h,n%h
    if b == 0:
        y = str(h)
    else:
        y = str(b)
    if a >= 9 and b != 0:
        x = str(a+1)
    elif a < 9 and b != 0:
        x = '0' + str(a+1)
    elif a >= 10 and b == 0:
        x = str(a)
    else:
        x = '0' + str(a)
    print(y+x)
