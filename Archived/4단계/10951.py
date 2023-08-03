import sys

while 1:
    init = sys.stdin.readline().strip()
    if init == '':
        break
    else:
        a,b = map(int,init.split())
    print(a+b)
