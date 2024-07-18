import sys
N = int(sys.stdin.readline().strip())
idx = 1
cnt = 0
while 1:
    if '666' in str(idx):
        cnt +=1
    if '666' in str(idx) and cnt == N:
        break
    idx +=1
print(idx)