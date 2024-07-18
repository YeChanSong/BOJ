import sys, math

while 1:
    tri = sorted(list(map(int,sys.stdin.readline().strip().split())))
    if 0 in tri:
        break
    if tri[0] **2 + tri[1] **2 == tri[2] **2:
        print("right")
    else:
        print("wrong")
