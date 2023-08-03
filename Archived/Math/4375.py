import sys

a = sys.stdin.readline().strip()
tmp = 0
while a!='':
    cnt = 0
    while 1:
        cnt +=1
        a = int(a)
        tmp=((tmp%a)*10 + 1)%a
        if tmp==0:
            break
    print(cnt)
    a = sys.stdin.readline().strip()