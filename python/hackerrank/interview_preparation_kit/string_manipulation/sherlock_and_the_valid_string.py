from collections import Counter


def is_valid(s):
    c = Counter(Counter(s).values())
    if len(c) < 2:
        return True
    elif len(c) > 2:
        return False
    a, b = c.keys()
    return (c[a] == 1 and (a == 1 or abs(a - b) == 1)) or (c[b] == 1 and (b == 1 or abs(a - b) == 1))


def main():
    s = input()
    result = 'YES' if is_valid(s) else 'NO'
    print(result)


if __name__ == '__main__':
    main()
