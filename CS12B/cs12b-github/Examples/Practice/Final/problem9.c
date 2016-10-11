/* Given the NodeObj structure and Node reference below, write a recursive C function with heading int
sumList(Node H) that returns the sum of all the items in a linked list headed by H. An empty list is
headed by NULL and has sum 0 */

typedef struct NodeObj {
  int item;
  struct NodeObj* next;
}NodeObj;

typedef NodeObj* Node;

int sumList(Node H) {
  if (H == NULL) {
    return 0;
  } else {
    return H.item + sumList(H.next);
  }
}
