import sys
N = int(sys.stdin.readline().strip())
stack = list()
for i in range(N):
    cmd = sys.stdin.readline().strip()
    if cmd[:4] == 'push':
        stack.append(int(cmd[5:]))
    elif cmd[:4] == 'size':
        print(len(stack))
    elif cmd[:3] == 'pop':
        if len(stack) == 0:
            print(-1)
        else:
            print(stack.pop())
    elif cmd[:5] == 'empty':
        if len(stack) == 0:
            print(1)
        else:
            print(0)
    else:
        # top
        if len(stack) == 0:
            print(-1)
        else:
            print(stack[-1])
        