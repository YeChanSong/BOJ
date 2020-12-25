import sys

expr = list(sys.stdin.readline().strip().split('-'))
ans = None
for i in expr:
    
    if '+' in i:
        tmp = list(map(int,i.split('+')))
        add = sum(tmp)
    else:
        add = int(i)
    
    if ans == None:
        ans = add
    else:
        ans -= add
print(ans)