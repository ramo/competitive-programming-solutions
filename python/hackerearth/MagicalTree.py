def get_total(input_str):
    s = 0
    pc = '+'
    for c in input_str:
        if c is '+' or c is '-':
            pc = c
        else:
            value = ord(c) - ord('0')
            s += (value if pc is '+' else -value)
    return s


def main():
    n = int(input())
    max_sum = 0
    for i in range(n):
        max_sum = max(max_sum, get_total(input()))
    print(max_sum)


if __name__ == '__main__':
    main()
