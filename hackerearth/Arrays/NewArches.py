"""
https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/nice-arches-1/
"""


def main():
    ans = 0
    for _ in range(int(input())):
        stack = []
        for c in input():
            if stack:
                top = stack.pop()
                if top != c:
                    stack.append(top)
                    stack.append(c)
            else:
                stack.append(c)

        if not stack:
            ans += 1
    print(ans)


if __name__ == '__main__':
    main()
