import sys
n = sys.stdin.readline().strip()
tmp = 100
cp = n
cnt = 0
while 1:
    if n == str(tmp):
        break
    
    cnt += 1
    if len(cp) == 1:
        tmp = int(cp)
        cp = cp[0] + str(tmp)
    else:
        tmp = int(cp[0]) + int(cp[1])
        if tmp < 10:
            cp = cp[1] + str(tmp)
        else:
            cp = cp[1] + str(tmp)[1]
    tmp = int(cp)
    
print(cnt)
