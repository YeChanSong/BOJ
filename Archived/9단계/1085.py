import sys

x,y,w,h = map(int,sys.stdin.readline().strip().split())

y1, y2 = y, h-y
ycheck = y1 > y2 and y2 or y1
x1, x2 = x, w-x
xcheck = x1 > x2 and x2 or x1
res = xcheck > ycheck and ycheck or xcheck
print(res)
