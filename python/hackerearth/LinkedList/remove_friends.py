"""
https://www.hackerearth.com/zh/practice/data-structures/linked-list/singly-linked-list/practice-problems/algorithm/remove-friends-5/
Solution accepted. Custom implementations of Doubly Linked List and Stack were used to solve the problem.
See remove_friends_simple.py for a simpler solution and a faster one.
"""


class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
        self.prev = None


class Stack:
    def __init__(self):
        self.top = None
        self.size = 0

    def push(self, value):
        node = Node(value)
        if self.top is None:
            self.top = node
        else:
            node.next = self.top
            self.top = node
        self.size += 1

    def peek(self):
        return self.top.value

    def pop(self):
        node = self.top
        self.top = node.next
        self.size -= 1
        return node.value

    def empty(self):
        return self.size == 0


class ListIterator:
    def __init__(self, lst):
        self.current = lst.head

    def __iter__(self):
        return self

    def __next__(self):
        ret = self.current
        if ret:
            self.current = self.current.next
            return ret
        else:
            raise StopIteration()


class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def __iter__(self):
        return ListIterator(self)

    def __str__(self):
        return ' '.join([str(x.value) for x in self])

    def add(self, value):
        node = Node(value)
        if self.head is None:
            self.head = node
            self.tail = node
        else:
            node.prev = self.tail
            self.tail.next = node
            self.tail = node
        self.size += 1

    def remove(self, el):
        if self.tail is None:
            return  # Nothing to remove
        if self.head is el:
            if self.head == self.tail:
                self.head = self.tail = None
            else:
                tmp = self.head
                self.head = self.head.next
                self.head.prev = None
                tmp.next = None
        elif self.tail is el:
            tmp = self.tail
            self.tail = self.tail.prev
            self.tail.next = None
            tmp.prev = None
        else:
            tmp = el
            el.prev.next = el.next
            el.next.prev = el.prev
            tmp.next = None
            tmp.prev = None
        self.size -= 1

    def empty(self):
        return self.size == 0


def main():
    for _ in range(int(input())):
        n, k = map(int, input().split())
        values = map(int, input().split())
        ll = LinkedList()
        for value in values:
            ll.add(value)

        stack = Stack()
        count = 0

        for el in ll:  # Iterate each element in linked list
            if el.next and el.value < el.next.value:  # if the current element is less than next element
                ll.remove(el)
                count += 1
                r = True
            else:
                stack.push(el)      # For now push the node to stack
                r = False

            while count < k and r and not stack.empty():  # If any deletion occurs, we check the stack elements
                e = stack.peek()
                if e.next and e.value < e.next.value:
                    ll.remove(e)
                    stack.pop()
                    count += 1
                else:
                    break

            if count == k:
                break
        else:   # We have completed iterating the list once, but still want to verify that we had k deletions
            # If not, we will pop out last pushed k - count elements and remove them from list
            while count < k and not stack.empty():
                node = stack.pop()
                ll.remove(node)
                count += 1

        print(ll)


if __name__ == '__main__':
    main()
