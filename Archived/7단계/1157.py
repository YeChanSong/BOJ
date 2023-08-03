import sys, collections

a = collections.Counter()
init = sys.stdin.readline().strip()
for i in init.lower():
    a[i] +=1

tmp = -1
tmpc = ''
for i,v in a.most_common():
    if tmp < v:
        tmp = v
        tmpc = i
        continue
    if v == tmp:
        tmpc = '?'
        break
    else:
        break
    
print(tmpc.upper())
