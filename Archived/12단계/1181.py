import sys

n = int(sys.stdin.readline().strip())
words = set()
for i in range(n):
    word = sys.stdin.readline().strip()
    words.add(word)
li = list(words)
li = sorted(li,key=lambda x: (len(x), x))
for i in li:
    print(i)
