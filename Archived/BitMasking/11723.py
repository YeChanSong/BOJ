import sys

M = int(sys.stdin.readline().strip())
ans = 0; mx = sum(list(1<<i for i in range(21)))

for i in range(M):
    init = list(sys.stdin.readline().split())
    if len(init)>1:
        inst,x = init[0], init[1]
    else:
        inst = init[0]
    
    if inst == 'add':
        ans |= (1<<int(x))
    elif inst == 'check':
        tmp = ans & (1<<int(x))
        if tmp == 0:
            print(0)
        else:
            print(1)
    elif inst == 'remove':
        ans &= ~(1<<int(x))
    elif inst == 'toggle':
        ans ^= (1<<int(x))
    elif inst == 'empty':
        ans = 0
    else:
        ans = mx
        